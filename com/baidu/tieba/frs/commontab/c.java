package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bh;
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
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class c implements NetModel.b {
    private FrsCommonTabFragment fCN;
    private boolean fCT;
    private d fDg;
    private FrsCommonTabRequestData fDj;
    private FrsCommonTabNetModel fDk;
    private FrsDynamicRequestData fDl;
    private FrsDynamicModel fDm;
    private boolean fDn;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> fDo = new HashSet<>();
    private int mPn = 1;
    private long fDp = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.fCN = frsCommonTabFragment;
            if (i2 == 89) {
                this.fCT = true;
                this.fDl = new FrsDynamicRequestData();
                this.fDl.forumId = i;
                this.fDl.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.fDl.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.fDl.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.fDm = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.fDl);
                this.fDm.a(this);
                this.fDm.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.fCT = false;
            this.fDj = new FrsCommonTabRequestData();
            this.fDj.fid = i;
            this.fDj.tabId = i2;
            this.fDj.isDefaultNavTab = qS(i2) ? 1 : 0;
            this.fDk = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.fDj);
            this.fDk.a(this);
            this.fDk.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    private boolean qS(int i) {
        return (this.fCN == null || this.fCN.fCY == null || this.fCN.fCY.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void bmA() {
        this.fDn = true;
        if (!this.fCT) {
            if (!this.fDk.isLoading()) {
                this.mPn = 1;
                this.fDj.pn = this.mPn;
                if (this.fDp >= 0) {
                    this.fDj.lastThreadId = this.fDp;
                }
                this.fDk.loadData();
            }
        } else if (!this.fDm.isLoading()) {
            if (ar.amO().isFrsShowBigImage()) {
                this.fDl.qType = 2;
            } else {
                this.fDl.qType = 1;
            }
            this.fDl.lastThreadId = 0L;
            this.fDm.loadData();
        }
    }

    public void aIW() {
        this.fDn = false;
        if (!this.fCT) {
            if (!this.fDk.isLoading()) {
                this.mPn++;
                this.fDj.pn = this.mPn;
                this.fDj.lastThreadId = -1L;
                this.fDk.loadData();
            }
        } else if (!this.fDm.isLoading()) {
            if (ar.amO().isFrsShowBigImage()) {
                this.fDl.qType = 2;
            } else {
                this.fDl.qType = 1;
            }
            this.fDm.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.fDn) {
            this.fDg = dVar;
            this.fDo.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bh) {
                    String tid = ((bh) next).getTid();
                    if (!this.fDo.contains(tid)) {
                        this.fDo.add(tid);
                    }
                }
            }
        } else {
            this.fDg.hasMore = dVar.hasMore;
            this.fDg.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bh) {
                    String tid2 = ((bh) next2).getTid();
                    if (!this.fDo.contains(tid2)) {
                        ((bh) next2).cen = this.fCN.isBrandForum;
                        this.fDg.threadList.add(next2);
                        this.fDo.add(tid2);
                    }
                }
            }
        }
        this.fCN.a(this.fDg);
        return true;
    }

    public void ac(bh bhVar) {
        if (bhVar != null && this.fDg != null && this.fDg.threadList != null) {
            if (v.isEmpty(this.fDg.threadList)) {
                this.fDg.threadList.add(bhVar);
            } else {
                this.fDg.threadList.add(0, bhVar);
            }
            this.fCN.a(this.fDg);
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
                        if (mVar instanceof bh) {
                            this.fDl.lastThreadId = com.baidu.adp.lib.g.b.toLong(((bh) mVar).getId(), 0L);
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
                    this.fCN.a(errorData);
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
                        if (mVar instanceof bh) {
                            this.fDl.lastThreadId = com.baidu.adp.lib.g.b.toLong(((bh) mVar).getId(), 0L);
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
                    this.fCN.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.fDg == null || v.isEmpty(this.fDg.threadList)) ? false : true;
    }

    public void cM(long j) {
        this.fDp = j;
    }

    public boolean bmF() {
        return this.fDn;
    }
}
