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
    private FrsDynamicModel dIA;
    private boolean dIB;
    private FrsCommonTabFragment dId;
    private boolean dIj;
    private d dIt;
    private FrsCommonTabRequestData dIx;
    private FrsCommonTabNetModel dIy;
    private FrsDynamicRequestData dIz;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> dIC = new HashSet<>();
    private int mPn = 1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.dId = frsCommonTabFragment;
            if (i2 == 89) {
                this.dIj = true;
                this.dIz = new FrsDynamicRequestData();
                this.dIz.forumId = i;
                this.dIz.scrH = l.aQ(TbadkCoreApplication.getInst());
                this.dIz.scrW = l.aO(TbadkCoreApplication.getInst());
                this.dIz.scrDip = l.aR(TbadkCoreApplication.getInst());
                this.dIA = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.dIz);
                this.dIA.a(this);
                this.dIA.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.dIj = false;
            this.dIx = new FrsCommonTabRequestData();
            this.dIx.fid = i;
            this.dIx.tabId = i2;
            this.dIy = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.dIx);
            this.dIy.a(this);
            this.dIy.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void aBz() {
        this.dIB = true;
        if (!this.dIj) {
            if (!this.dIy.Ee()) {
                this.mPn = 1;
                this.dIx.pn = this.mPn;
                this.dIy.Ns();
            }
        } else if (!this.dIA.Ee()) {
            if (aq.CN().CP()) {
                this.dIz.qType = 2;
            } else {
                this.dIz.qType = 1;
            }
            this.dIz.lastThreadId = 0L;
            this.dIA.Ns();
        }
    }

    public void YV() {
        this.dIB = false;
        if (!this.dIj) {
            if (!this.dIy.Ee()) {
                this.mPn++;
                this.dIx.pn = this.mPn;
                this.dIy.Ns();
            }
        } else if (!this.dIA.Ee()) {
            if (aq.CN().CP()) {
                this.dIz.qType = 2;
            } else {
                this.dIz.qType = 1;
            }
            this.dIA.Ns();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.dIB) {
            this.dIt = dVar;
            this.dIC.clear();
            Iterator<h> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next instanceof bb) {
                    String tid = ((bb) next).getTid();
                    if (!this.dIC.contains(tid)) {
                        this.dIC.add(tid);
                    }
                }
            }
        } else {
            this.dIt.hasMore = dVar.hasMore;
            this.dIt.userMap.putAll(dVar.userMap);
            Iterator<h> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (next2 instanceof bb) {
                    String tid2 = ((bb) next2).getTid();
                    if (!this.dIC.contains(tid2)) {
                        ((bb) next2).asd = this.dId.isBrandForum;
                        this.dIt.threadList.add(next2);
                        this.dIC.add(tid2);
                    }
                }
            }
        }
        this.dId.a(this.dIt);
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
                            this.dIz.lastThreadId = com.baidu.adp.lib.g.b.d(((bb) hVar).getId(), 0L);
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
                    this.dId.a(errorData);
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
                            this.dIz.lastThreadId = com.baidu.adp.lib.g.b.d(((bb) hVar).getId(), 0L);
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
                    this.dId.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.dIt == null || v.I(this.dIt.threadList)) ? false : true;
    }
}
