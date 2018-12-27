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
    private d dRG;
    private FrsCommonTabRequestData dRK;
    private FrsCommonTabNetModel dRL;
    private FrsDynamicRequestData dRM;
    private FrsDynamicModel dRN;
    private boolean dRO;
    private FrsCommonTabFragment dRq;
    private boolean dRw;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> dRP = new HashSet<>();
    private int mPn = 1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.dRq = frsCommonTabFragment;
            if (i2 == 89) {
                this.dRw = true;
                this.dRM = new FrsDynamicRequestData();
                this.dRM.forumId = i;
                this.dRM.scrH = l.aQ(TbadkCoreApplication.getInst());
                this.dRM.scrW = l.aO(TbadkCoreApplication.getInst());
                this.dRM.scrDip = l.aR(TbadkCoreApplication.getInst());
                this.dRN = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.dRM);
                this.dRN.a(this);
                this.dRN.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.dRw = false;
            this.dRK = new FrsCommonTabRequestData();
            this.dRK.fid = i;
            this.dRK.tabId = i2;
            this.dRL = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.dRK);
            this.dRL.a(this);
            this.dRL.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void aDY() {
        this.dRO = true;
        if (!this.dRw) {
            if (!this.dRL.Fi()) {
                this.mPn = 1;
                this.dRK.pn = this.mPn;
                this.dRL.Ox();
            }
        } else if (!this.dRN.Fi()) {
            if (aq.DR().DT()) {
                this.dRM.qType = 2;
            } else {
                this.dRM.qType = 1;
            }
            this.dRM.lastThreadId = 0L;
            this.dRN.Ox();
        }
    }

    public void aad() {
        this.dRO = false;
        if (!this.dRw) {
            if (!this.dRL.Fi()) {
                this.mPn++;
                this.dRK.pn = this.mPn;
                this.dRL.Ox();
            }
        } else if (!this.dRN.Fi()) {
            if (aq.DR().DT()) {
                this.dRM.qType = 2;
            } else {
                this.dRM.qType = 1;
            }
            this.dRN.Ox();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.dRO) {
            this.dRG = dVar;
            this.dRP.clear();
            Iterator<h> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next instanceof bb) {
                    String tid = ((bb) next).getTid();
                    if (!this.dRP.contains(tid)) {
                        this.dRP.add(tid);
                    }
                }
            }
        } else {
            this.dRG.hasMore = dVar.hasMore;
            this.dRG.userMap.putAll(dVar.userMap);
            Iterator<h> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (next2 instanceof bb) {
                    String tid2 = ((bb) next2).getTid();
                    if (!this.dRP.contains(tid2)) {
                        ((bb) next2).avD = this.dRq.isBrandForum;
                        this.dRG.threadList.add(next2);
                        this.dRP.add(tid2);
                    }
                }
            }
        }
        this.dRq.a(this.dRG);
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
                            this.dRM.lastThreadId = com.baidu.adp.lib.g.b.d(((bb) hVar).getId(), 0L);
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
                    this.dRq.a(errorData);
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
                            this.dRM.lastThreadId = com.baidu.adp.lib.g.b.d(((bb) hVar).getId(), 0L);
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
                    this.dRq.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.dRG == null || v.I(this.dRG.threadList)) ? false : true;
    }
}
