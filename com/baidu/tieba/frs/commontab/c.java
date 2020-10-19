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
/* loaded from: classes22.dex */
public class c implements NetModel.b {
    private boolean isDynamic;
    private FrsCommonTabFragment ixD;
    private d ixY;
    private FrsCommonTabRequestData iyf;
    private FrsCommonTabNetModel iyg;
    private FrsDynamicRequestData iyh;
    private FrsDynamicModel iyi;
    private boolean iyj;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> iyk = new HashSet<>();
    private int mPn = 1;
    private long iyl = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.ixD = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.iyh = new FrsDynamicRequestData();
                this.iyh.forumId = i;
                this.iyh.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.iyh.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.iyh.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.iyi = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.iyh);
                this.iyi.a(this);
                this.iyi.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.iyf = new FrsCommonTabRequestData();
            this.iyf.fid = i;
            this.iyf.tabId = i2;
            this.iyf.isDefaultNavTab = yJ(i2) ? 1 : 0;
            this.iyf.tabName = str;
            this.iyf.isGeneralTab = i3;
            this.iyg = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.iyf);
            this.iyg.a(this);
            this.iyg.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.iyf != null) {
            this.iyf.tabType = i;
        }
    }

    private boolean yJ(int i) {
        return (this.ixD == null || this.ixD.ixQ == null || this.ixD.ixQ.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void yK(int i) {
        this.iyj = true;
        if (!this.isDynamic) {
            if (!this.iyg.isLoading()) {
                this.mPn = 1;
                this.iyf.pn = this.mPn;
                this.iyf.sortType = i;
                if (this.iyl >= 0) {
                    this.iyf.lastThreadId = this.iyl;
                }
                this.iyg.loadData();
            }
        } else if (!this.iyi.isLoading()) {
            if (au.bmV().bmW()) {
                this.iyh.qType = 2;
            } else {
                this.iyh.qType = 1;
            }
            this.iyh.lastThreadId = 0L;
            this.iyi.loadData();
        }
    }

    public void yL(int i) {
        this.iyj = false;
        if (!this.isDynamic) {
            if (!this.iyg.isLoading()) {
                this.mPn++;
                this.iyf.pn = this.mPn;
                this.iyf.sortType = i;
                this.iyf.lastThreadId = -1L;
                this.iyg.loadData();
            }
        } else if (!this.iyi.isLoading()) {
            if (au.bmV().bmW()) {
                this.iyh.qType = 2;
            } else {
                this.iyh.qType = 1;
            }
            this.iyi.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.iyj) {
            this.ixY = dVar;
            this.iyk.clear();
            Iterator<q> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof bw) {
                    String tid = ((bw) next).getTid();
                    if (!this.iyk.contains(tid)) {
                        this.iyk.add(tid);
                    }
                }
            }
        } else {
            this.ixY.hasMore = dVar.hasMore;
            this.ixY.userMap.putAll(dVar.userMap);
            Iterator<q> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof bw) {
                    String tid2 = ((bw) next2).getTid();
                    if (!this.iyk.contains(tid2)) {
                        ((bw) next2).esk = this.ixD.isBrandForum;
                        this.ixY.threadList.add(next2);
                        this.iyk.add(tid2);
                    }
                }
            }
        }
        this.ixD.a(this.ixY);
        return true;
    }

    public void an(bw bwVar) {
        if (bwVar != null && this.ixY != null && this.ixY.threadList != null) {
            if (y.isEmpty(this.ixY.threadList)) {
                this.ixY.threadList.add(bwVar);
            } else {
                if (this.ixY.threadList.size() == 1 && (this.ixY.threadList.get(0) instanceof s)) {
                    this.ixY.threadList.remove(0);
                }
                this.ixY.threadList.add(0, bwVar);
            }
            this.ixD.a(this.ixY);
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
                            this.iyh.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bw) qVar).getId(), 0L);
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
                    this.ixD.a(errorData);
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
                            this.iyh.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bw) qVar).getId(), 0L);
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
                    this.ixD.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.ixY == null || y.isEmpty(this.ixY.threadList)) ? false : true;
    }

    public d cvW() {
        return this.ixY;
    }

    public void fj(long j) {
        this.iyl = j;
    }

    public boolean cvX() {
        return this.iyj;
    }
}
