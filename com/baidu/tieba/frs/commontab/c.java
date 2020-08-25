package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import com.baidu.tieba.frs.s;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class c implements NetModel.b {
    private d ibR;
    private FrsCommonTabRequestData ibY;
    private FrsCommonTabNetModel ibZ;
    private FrsCommonTabFragment ibw;
    private FrsDynamicRequestData ica;
    private FrsDynamicModel icb;
    private boolean icc;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> icd = new HashSet<>();
    private int mPn = 1;
    private long ice = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.ibw = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.ica = new FrsDynamicRequestData();
                this.ica.forumId = i;
                this.ica.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.ica.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.ica.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.icb = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.ica);
                this.icb.a(this);
                this.icb.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.ibY = new FrsCommonTabRequestData();
            this.ibY.fid = i;
            this.ibY.tabId = i2;
            this.ibY.isDefaultNavTab = xE(i2) ? 1 : 0;
            this.ibY.tabName = str;
            this.ibY.isGeneralTab = i3;
            this.ibZ = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.ibY);
            this.ibZ.a(this);
            this.ibZ.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.ibY != null) {
            this.ibY.tabType = i;
        }
    }

    private boolean xE(int i) {
        return (this.ibw == null || this.ibw.ibJ == null || this.ibw.ibJ.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void xF(int i) {
        this.icc = true;
        if (!this.isDynamic) {
            if (!this.ibZ.isLoading()) {
                this.mPn = 1;
                this.ibY.pn = this.mPn;
                this.ibY.sortType = i;
                if (this.ice >= 0) {
                    this.ibY.lastThreadId = this.ice;
                }
                this.ibZ.loadData();
            }
        } else if (!this.icb.isLoading()) {
            if (au.bjr().bjs()) {
                this.ica.qType = 2;
            } else {
                this.ica.qType = 1;
            }
            this.ica.lastThreadId = 0L;
            this.icb.loadData();
        }
    }

    public void xG(int i) {
        this.icc = false;
        if (!this.isDynamic) {
            if (!this.ibZ.isLoading()) {
                this.mPn++;
                this.ibY.pn = this.mPn;
                this.ibY.sortType = i;
                this.ibY.lastThreadId = -1L;
                this.ibZ.loadData();
            }
        } else if (!this.icb.isLoading()) {
            if (au.bjr().bjs()) {
                this.ica.qType = 2;
            } else {
                this.ica.qType = 1;
            }
            this.icb.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.icc) {
            this.ibR = dVar;
            this.icd.clear();
            Iterator<q> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof bw) {
                    String tid = ((bw) next).getTid();
                    if (!this.icd.contains(tid)) {
                        this.icd.add(tid);
                    }
                }
            }
        } else {
            this.ibR.hasMore = dVar.hasMore;
            this.ibR.userMap.putAll(dVar.userMap);
            Iterator<q> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof bw) {
                    String tid2 = ((bw) next2).getTid();
                    if (!this.icd.contains(tid2)) {
                        ((bw) next2).edQ = this.ibw.isBrandForum;
                        this.ibR.threadList.add(next2);
                        this.icd.add(tid2);
                    }
                }
            }
        }
        this.ibw.a(this.ibR);
        return true;
    }

    public void am(bw bwVar) {
        if (bwVar != null && this.ibR != null && this.ibR.threadList != null) {
            if (y.isEmpty(this.ibR.threadList)) {
                this.ibR.threadList.add(bwVar);
            } else {
                if (this.ibR.threadList.size() == 1 && (this.ibR.threadList.get(0) instanceof s)) {
                    this.ibR.threadList.remove(0);
                }
                this.ibR.threadList.add(0, bwVar);
            }
            this.ibw.a(this.ibR);
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
                    if (!y.isEmpty(dVar2.threadList)) {
                        q qVar = (q) y.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (qVar instanceof bw) {
                            this.ica.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bw) qVar).getId(), 0L);
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
                    this.ibw.a(errorData);
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
                    if (!y.isEmpty(dVar2.threadList)) {
                        q qVar = (q) y.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (qVar instanceof bw) {
                            this.ica.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bw) qVar).getId(), 0L);
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
                    this.ibw.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.ibR == null || y.isEmpty(this.ibR.threadList)) ? false : true;
    }

    public d cpl() {
        return this.ibR;
    }

    public void eI(long j) {
        this.ice = j;
    }

    public boolean cpm() {
        return this.icc;
    }
}
