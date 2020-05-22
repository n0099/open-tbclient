package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import com.baidu.tieba.frs.p;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class c implements NetModel.b {
    private d huK;
    private FrsCommonTabRequestData huO;
    private FrsCommonTabNetModel huP;
    private FrsDynamicRequestData huQ;
    private FrsDynamicModel huR;
    private boolean huS;
    private FrsCommonTabFragment hup;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> huT = new HashSet<>();
    private int mPn = 1;
    private long huU = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.hup = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.huQ = new FrsDynamicRequestData();
                this.huQ.forumId = i;
                this.huQ.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.huQ.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.huQ.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.huR = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.huQ);
                this.huR.a(this);
                this.huR.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.huO = new FrsCommonTabRequestData();
            this.huO.fid = i;
            this.huO.tabId = i2;
            this.huO.isDefaultNavTab = un(i2) ? 1 : 0;
            this.huO.tabName = str;
            this.huO.isGeneralTab = i3;
            this.huP = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.huO);
            this.huP.a(this);
            this.huP.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    private boolean un(int i) {
        return (this.hup == null || this.hup.huC == null || this.hup.huC.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void uo(int i) {
        this.huS = true;
        if (!this.isDynamic) {
            if (!this.huP.isLoading()) {
                this.mPn = 1;
                this.huO.pn = this.mPn;
                this.huO.sortType = i;
                if (this.huU >= 0) {
                    this.huO.lastThreadId = this.huU;
                }
                this.huP.loadData();
            }
        } else if (!this.huR.isLoading()) {
            if (ar.aUW().aUX()) {
                this.huQ.qType = 2;
            } else {
                this.huQ.qType = 1;
            }
            this.huQ.lastThreadId = 0L;
            this.huR.loadData();
        }
    }

    public void up(int i) {
        this.huS = false;
        if (!this.isDynamic) {
            if (!this.huP.isLoading()) {
                this.mPn++;
                this.huO.pn = this.mPn;
                this.huO.sortType = i;
                this.huO.lastThreadId = -1L;
                this.huP.loadData();
            }
        } else if (!this.huR.isLoading()) {
            if (ar.aUW().aUX()) {
                this.huQ.qType = 2;
            } else {
                this.huQ.qType = 1;
            }
            this.huR.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.huS) {
            this.huK = dVar;
            this.huT.clear();
            Iterator<o> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next instanceof bk) {
                    String tid = ((bk) next).getTid();
                    if (!this.huT.contains(tid)) {
                        this.huT.add(tid);
                    }
                }
            }
        } else {
            this.huK.hasMore = dVar.hasMore;
            this.huK.userMap.putAll(dVar.userMap);
            Iterator<o> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                o next2 = it2.next();
                if (next2 instanceof bk) {
                    String tid2 = ((bk) next2).getTid();
                    if (!this.huT.contains(tid2)) {
                        ((bk) next2).dHx = this.hup.isBrandForum;
                        this.huK.threadList.add(next2);
                        this.huT.add(tid2);
                    }
                }
            }
        }
        this.hup.a(this.huK);
        return true;
    }

    public void ap(bk bkVar) {
        if (bkVar != null && this.huK != null && this.huK.threadList != null) {
            if (v.isEmpty(this.huK.threadList)) {
                this.huK.threadList.add(bkVar);
            } else {
                if (this.huK.threadList.size() == 1 && (this.huK.threadList.get(0) instanceof p)) {
                    this.huK.threadList.remove(0);
                }
                this.huK.threadList.add(0, bkVar);
            }
            this.hup.a(this.huK);
        }
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
                    if (!v.isEmpty(dVar2.threadList)) {
                        o oVar = (o) v.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (oVar instanceof bk) {
                            this.huQ.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bk) oVar).getId(), 0L);
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
                    this.hup.a(errorData);
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
                    if (!v.isEmpty(dVar2.threadList)) {
                        o oVar = (o) v.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (oVar instanceof bk) {
                            this.huQ.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bk) oVar).getId(), 0L);
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
                    this.hup.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.huK == null || v.isEmpty(this.huK.threadList)) ? false : true;
    }

    public void eg(long j) {
        this.huU = j;
    }

    public boolean bXS() {
        return this.huS;
    }
}
