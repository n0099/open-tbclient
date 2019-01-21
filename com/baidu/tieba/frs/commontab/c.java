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
    private FrsCommonTabFragment dSa;
    private boolean dSg;
    private d dSq;
    private FrsCommonTabRequestData dSu;
    private FrsCommonTabNetModel dSv;
    private FrsDynamicRequestData dSw;
    private FrsDynamicModel dSx;
    private boolean dSy;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> dSz = new HashSet<>();
    private int mPn = 1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.dSa = frsCommonTabFragment;
            if (i2 == 89) {
                this.dSg = true;
                this.dSw = new FrsDynamicRequestData();
                this.dSw.forumId = i;
                this.dSw.scrH = l.aQ(TbadkCoreApplication.getInst());
                this.dSw.scrW = l.aO(TbadkCoreApplication.getInst());
                this.dSw.scrDip = l.aR(TbadkCoreApplication.getInst());
                this.dSx = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.dSw);
                this.dSx.a(this);
                this.dSx.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.dSg = false;
            this.dSu = new FrsCommonTabRequestData();
            this.dSu.fid = i;
            this.dSu.tabId = i2;
            this.dSv = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.dSu);
            this.dSv.a(this);
            this.dSv.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void aEv() {
        this.dSy = true;
        if (!this.dSg) {
            if (!this.dSv.Fv()) {
                this.mPn = 1;
                this.dSu.pn = this.mPn;
                this.dSv.OP();
            }
        } else if (!this.dSx.Fv()) {
            if (aq.Ee().Eg()) {
                this.dSw.qType = 2;
            } else {
                this.dSw.qType = 1;
            }
            this.dSw.lastThreadId = 0L;
            this.dSx.OP();
        }
    }

    public void aaA() {
        this.dSy = false;
        if (!this.dSg) {
            if (!this.dSv.Fv()) {
                this.mPn++;
                this.dSu.pn = this.mPn;
                this.dSv.OP();
            }
        } else if (!this.dSx.Fv()) {
            if (aq.Ee().Eg()) {
                this.dSw.qType = 2;
            } else {
                this.dSw.qType = 1;
            }
            this.dSx.OP();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.dSy) {
            this.dSq = dVar;
            this.dSz.clear();
            Iterator<h> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next instanceof bb) {
                    String tid = ((bb) next).getTid();
                    if (!this.dSz.contains(tid)) {
                        this.dSz.add(tid);
                    }
                }
            }
        } else {
            this.dSq.hasMore = dVar.hasMore;
            this.dSq.userMap.putAll(dVar.userMap);
            Iterator<h> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (next2 instanceof bb) {
                    String tid2 = ((bb) next2).getTid();
                    if (!this.dSz.contains(tid2)) {
                        ((bb) next2).awg = this.dSa.isBrandForum;
                        this.dSq.threadList.add(next2);
                        this.dSz.add(tid2);
                    }
                }
            }
        }
        this.dSa.a(this.dSq);
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
                            this.dSw.lastThreadId = com.baidu.adp.lib.g.b.d(((bb) hVar).getId(), 0L);
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
                    this.dSa.a(errorData);
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
                            this.dSw.lastThreadId = com.baidu.adp.lib.g.b.d(((bb) hVar).getId(), 0L);
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
                    this.dSa.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.dSq == null || v.I(this.dSq.threadList)) ? false : true;
    }
}
