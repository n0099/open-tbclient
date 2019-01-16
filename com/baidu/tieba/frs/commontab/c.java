package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class c implements NetModel.b {
    private FrsCommonTabFragment dRZ;
    private boolean dSf;
    private d dSp;
    private FrsCommonTabRequestData dSt;
    private FrsCommonTabNetModel dSu;
    private FrsDynamicRequestData dSv;
    private FrsDynamicModel dSw;
    private boolean dSx;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> dSy = new HashSet<>();
    private int mPn = 1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.dRZ = frsCommonTabFragment;
            if (i2 == 89) {
                this.dSf = true;
                this.dSv = new FrsDynamicRequestData();
                this.dSv.forumId = i;
                this.dSv.scrH = l.aQ(TbadkCoreApplication.getInst());
                this.dSv.scrW = l.aO(TbadkCoreApplication.getInst());
                this.dSv.scrDip = l.aR(TbadkCoreApplication.getInst());
                this.dSw = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.dSv);
                this.dSw.a(this);
                this.dSw.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.dSf = false;
            this.dSt = new FrsCommonTabRequestData();
            this.dSt.fid = i;
            this.dSt.tabId = i2;
            this.dSu = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.dSt);
            this.dSu.a(this);
            this.dSu.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void aEv() {
        this.dSx = true;
        if (!this.dSf) {
            if (!this.dSu.Fv()) {
                this.mPn = 1;
                this.dSt.pn = this.mPn;
                this.dSu.OP();
            }
        } else if (!this.dSw.Fv()) {
            if (aq.Ee().Eg()) {
                this.dSv.qType = 2;
            } else {
                this.dSv.qType = 1;
            }
            this.dSv.lastThreadId = 0L;
            this.dSw.OP();
        }
    }

    public void aaA() {
        this.dSx = false;
        if (!this.dSf) {
            if (!this.dSu.Fv()) {
                this.mPn++;
                this.dSt.pn = this.mPn;
                this.dSu.OP();
            }
        } else if (!this.dSw.Fv()) {
            if (aq.Ee().Eg()) {
                this.dSv.qType = 2;
            } else {
                this.dSv.qType = 1;
            }
            this.dSw.OP();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.dSx) {
            this.dSp = dVar;
            this.dSy.clear();
            Iterator<h> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next instanceof bb) {
                    String tid = ((bb) next).getTid();
                    if (!this.dSy.contains(tid)) {
                        this.dSy.add(tid);
                    }
                }
            }
        } else {
            this.dSp.hasMore = dVar.hasMore;
            this.dSp.userMap.putAll(dVar.userMap);
            Iterator<h> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (next2 instanceof bb) {
                    String tid2 = ((bb) next2).getTid();
                    if (!this.dSy.contains(tid2)) {
                        ((bb) next2).awf = this.dRZ.isBrandForum;
                        this.dSp.threadList.add(next2);
                        this.dSy.add(tid2);
                    }
                }
            }
        }
        this.dRZ.a(this.dSp);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcHttpResponsedMessage != null) {
            d dVar = null;
            if (!mvcHttpResponsedMessage.hasError()) {
                if (mvcHttpResponsedMessage.getData() instanceof d) {
                    dVar = (d) mvcHttpResponsedMessage.getData();
                } else if (mvcHttpResponsedMessage.getData() instanceof com.baidu.tieba.frs.dynamic.a) {
                    com.baidu.tieba.frs.dynamic.a aVar = (com.baidu.tieba.frs.dynamic.a) mvcHttpResponsedMessage.getData();
                    d dVar2 = new d();
                    dVar2.threadList = aVar.threadList;
                    dVar2.hasMore = aVar.hasMore;
                    dVar2.userMap = aVar.userMap;
                    if (!v.I(dVar2.threadList)) {
                        h hVar = (h) v.d(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (hVar instanceof bb) {
                            this.dSv.lastThreadId = com.baidu.adp.lib.g.b.d(((bb) hVar).getId(), 0L);
                        }
                    }
                    dVar = dVar2;
                }
            }
            if (dVar == null || !b(dVar)) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                if (this.mErrorCode != 0) {
                    this.dRZ.a(errorData);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        if (mvcSocketResponsedMessage != null) {
            d dVar = null;
            if (!mvcSocketResponsedMessage.hasError()) {
                if (mvcSocketResponsedMessage.getData() instanceof d) {
                    dVar = (d) mvcSocketResponsedMessage.getData();
                } else if (mvcSocketResponsedMessage.getData() instanceof com.baidu.tieba.frs.dynamic.a) {
                    com.baidu.tieba.frs.dynamic.a aVar = (com.baidu.tieba.frs.dynamic.a) mvcSocketResponsedMessage.getData();
                    d dVar2 = new d();
                    dVar2.threadList = aVar.threadList;
                    dVar2.hasMore = aVar.hasMore;
                    dVar2.userMap = aVar.userMap;
                    if (!v.I(dVar2.threadList)) {
                        h hVar = (h) v.d(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (hVar instanceof bb) {
                            this.dSv.lastThreadId = com.baidu.adp.lib.g.b.d(((bb) hVar).getId(), 0L);
                        }
                    }
                    dVar = dVar2;
                }
            }
            if (dVar == null || !b(dVar)) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                if (this.mErrorCode != 0) {
                    this.dRZ.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.dSp == null || v.I(this.dSp.threadList)) ? false : true;
    }
}
