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
    private FrsCommonTabFragment dOC;
    private boolean dOI;
    private d dOS;
    private FrsCommonTabRequestData dOW;
    private FrsCommonTabNetModel dOX;
    private FrsDynamicRequestData dOY;
    private FrsDynamicModel dOZ;
    private boolean dPa;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> dPb = new HashSet<>();
    private int mPn = 1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.dOC = frsCommonTabFragment;
            if (i2 == 89) {
                this.dOI = true;
                this.dOY = new FrsDynamicRequestData();
                this.dOY.forumId = i;
                this.dOY.scrH = l.aQ(TbadkCoreApplication.getInst());
                this.dOY.scrW = l.aO(TbadkCoreApplication.getInst());
                this.dOY.scrDip = l.aR(TbadkCoreApplication.getInst());
                this.dOZ = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.dOY);
                this.dOZ.a(this);
                this.dOZ.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.dOI = false;
            this.dOW = new FrsCommonTabRequestData();
            this.dOW.fid = i;
            this.dOW.tabId = i2;
            this.dOX = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.dOW);
            this.dOX.a(this);
            this.dOX.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void aDj() {
        this.dPa = true;
        if (!this.dOI) {
            if (!this.dOX.Fi()) {
                this.mPn = 1;
                this.dOW.pn = this.mPn;
                this.dOX.Ow();
            }
        } else if (!this.dOZ.Fi()) {
            if (aq.DR().DT()) {
                this.dOY.qType = 2;
            } else {
                this.dOY.qType = 1;
            }
            this.dOY.lastThreadId = 0L;
            this.dOZ.Ow();
        }
    }

    public void aab() {
        this.dPa = false;
        if (!this.dOI) {
            if (!this.dOX.Fi()) {
                this.mPn++;
                this.dOW.pn = this.mPn;
                this.dOX.Ow();
            }
        } else if (!this.dOZ.Fi()) {
            if (aq.DR().DT()) {
                this.dOY.qType = 2;
            } else {
                this.dOY.qType = 1;
            }
            this.dOZ.Ow();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.dPa) {
            this.dOS = dVar;
            this.dPb.clear();
            Iterator<h> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next instanceof bb) {
                    String tid = ((bb) next).getTid();
                    if (!this.dPb.contains(tid)) {
                        this.dPb.add(tid);
                    }
                }
            }
        } else {
            this.dOS.hasMore = dVar.hasMore;
            this.dOS.userMap.putAll(dVar.userMap);
            Iterator<h> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (next2 instanceof bb) {
                    String tid2 = ((bb) next2).getTid();
                    if (!this.dPb.contains(tid2)) {
                        ((bb) next2).avD = this.dOC.isBrandForum;
                        this.dOS.threadList.add(next2);
                        this.dPb.add(tid2);
                    }
                }
            }
        }
        this.dOC.a(this.dOS);
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
                            this.dOY.lastThreadId = com.baidu.adp.lib.g.b.d(((bb) hVar).getId(), 0L);
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
                    this.dOC.a(errorData);
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
                            this.dOY.lastThreadId = com.baidu.adp.lib.g.b.d(((bb) hVar).getId(), 0L);
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
                    this.dOC.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.dOS == null || v.I(this.dOS.threadList)) ? false : true;
    }
}
