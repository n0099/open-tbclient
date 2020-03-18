package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tieba.frs.o;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class c implements NetModel.b {
    private d gwF;
    private FrsCommonTabRequestData gwK;
    private FrsCommonTabNetModel gwL;
    private FrsDynamicRequestData gwM;
    private FrsDynamicModel gwN;
    private boolean gwO;
    private FrsCommonTabFragment gwk;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> gwP = new HashSet<>();
    private int mPn = 1;
    private long gwQ = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.gwk = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.gwM = new FrsDynamicRequestData();
                this.gwM.forumId = i;
                this.gwM.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.gwM.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.gwM.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.gwN = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.gwM);
                this.gwN.a(this);
                this.gwN.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.gwK = new FrsCommonTabRequestData();
            this.gwK.fid = i;
            this.gwK.tabId = i2;
            this.gwK.isDefaultNavTab = tk(i2) ? 1 : 0;
            this.gwK.tabName = str;
            this.gwK.isGeneralTab = i3;
            this.gwL = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.gwK);
            this.gwL.a(this);
            this.gwL.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    private boolean tk(int i) {
        return (this.gwk == null || this.gwk.gwx == null || this.gwk.gwx.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void tl(int i) {
        this.gwO = true;
        if (!this.isDynamic) {
            if (!this.gwL.isLoading()) {
                this.mPn = 1;
                this.gwK.pn = this.mPn;
                this.gwK.sortType = i;
                if (this.gwQ >= 0) {
                    this.gwK.lastThreadId = this.gwQ;
                }
                this.gwL.loadData();
            }
        } else if (!this.gwN.isLoading()) {
            if (ar.aGH().aGI()) {
                this.gwM.qType = 2;
            } else {
                this.gwM.qType = 1;
            }
            this.gwM.lastThreadId = 0L;
            this.gwN.loadData();
        }
    }

    public void tm(int i) {
        this.gwO = false;
        if (!this.isDynamic) {
            if (!this.gwL.isLoading()) {
                this.mPn++;
                this.gwK.pn = this.mPn;
                this.gwK.sortType = i;
                this.gwK.lastThreadId = -1L;
                this.gwL.loadData();
            }
        } else if (!this.gwN.isLoading()) {
            if (ar.aGH().aGI()) {
                this.gwM.qType = 2;
            } else {
                this.gwM.qType = 1;
            }
            this.gwN.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.gwO) {
            this.gwF = dVar;
            this.gwP.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bj) {
                    String tid = ((bj) next).getTid();
                    if (!this.gwP.contains(tid)) {
                        this.gwP.add(tid);
                    }
                }
            }
        } else {
            this.gwF.hasMore = dVar.hasMore;
            this.gwF.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bj) {
                    String tid2 = ((bj) next2).getTid();
                    if (!this.gwP.contains(tid2)) {
                        ((bj) next2).cUp = this.gwk.isBrandForum;
                        this.gwF.threadList.add(next2);
                        this.gwP.add(tid2);
                    }
                }
            }
        }
        this.gwk.a(this.gwF);
        return true;
    }

    public void am(bj bjVar) {
        if (bjVar != null && this.gwF != null && this.gwF.threadList != null) {
            if (v.isEmpty(this.gwF.threadList)) {
                this.gwF.threadList.add(bjVar);
            } else {
                if (this.gwF.threadList.size() == 1 && (this.gwF.threadList.get(0) instanceof o)) {
                    this.gwF.threadList.remove(0);
                }
                this.gwF.threadList.add(0, bjVar);
            }
            this.gwk.a(this.gwF);
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
                        m mVar = (m) v.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (mVar instanceof bj) {
                            this.gwM.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.gwk.a(errorData);
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
                        m mVar = (m) v.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (mVar instanceof bj) {
                            this.gwM.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bj) mVar).getId(), 0L);
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
                    this.gwk.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.gwF == null || v.isEmpty(this.gwF.threadList)) ? false : true;
    }

    public void dw(long j) {
        this.gwQ = j;
    }

    public boolean bGW() {
        return this.gwO;
    }
}
