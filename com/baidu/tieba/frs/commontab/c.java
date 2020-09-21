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
/* loaded from: classes21.dex */
public class c implements NetModel.b {
    private FrsCommonTabFragment iiG;
    private d ijb;
    private FrsCommonTabRequestData iji;
    private FrsCommonTabNetModel ijj;
    private FrsDynamicRequestData ijk;
    private FrsDynamicModel ijl;
    private boolean ijm;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> ijn = new HashSet<>();
    private int mPn = 1;
    private long ijo = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.iiG = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.ijk = new FrsDynamicRequestData();
                this.ijk.forumId = i;
                this.ijk.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.ijk.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.ijk.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.ijl = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.ijk);
                this.ijl.a(this);
                this.ijl.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.iji = new FrsCommonTabRequestData();
            this.iji.fid = i;
            this.iji.tabId = i2;
            this.iji.isDefaultNavTab = yd(i2) ? 1 : 0;
            this.iji.tabName = str;
            this.iji.isGeneralTab = i3;
            this.ijj = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.iji);
            this.ijj.a(this);
            this.ijj.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.iji != null) {
            this.iji.tabType = i;
        }
    }

    private boolean yd(int i) {
        return (this.iiG == null || this.iiG.iiT == null || this.iiG.iiT.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void ye(int i) {
        this.ijm = true;
        if (!this.isDynamic) {
            if (!this.ijj.isLoading()) {
                this.mPn = 1;
                this.iji.pn = this.mPn;
                this.iji.sortType = i;
                if (this.ijo >= 0) {
                    this.iji.lastThreadId = this.ijo;
                }
                this.ijj.loadData();
            }
        } else if (!this.ijl.isLoading()) {
            if (au.bkm().bkn()) {
                this.ijk.qType = 2;
            } else {
                this.ijk.qType = 1;
            }
            this.ijk.lastThreadId = 0L;
            this.ijl.loadData();
        }
    }

    public void yf(int i) {
        this.ijm = false;
        if (!this.isDynamic) {
            if (!this.ijj.isLoading()) {
                this.mPn++;
                this.iji.pn = this.mPn;
                this.iji.sortType = i;
                this.iji.lastThreadId = -1L;
                this.ijj.loadData();
            }
        } else if (!this.ijl.isLoading()) {
            if (au.bkm().bkn()) {
                this.ijk.qType = 2;
            } else {
                this.ijk.qType = 1;
            }
            this.ijl.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.ijm) {
            this.ijb = dVar;
            this.ijn.clear();
            Iterator<q> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof bw) {
                    String tid = ((bw) next).getTid();
                    if (!this.ijn.contains(tid)) {
                        this.ijn.add(tid);
                    }
                }
            }
        } else {
            this.ijb.hasMore = dVar.hasMore;
            this.ijb.userMap.putAll(dVar.userMap);
            Iterator<q> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof bw) {
                    String tid2 = ((bw) next2).getTid();
                    if (!this.ijn.contains(tid2)) {
                        ((bw) next2).ege = this.iiG.isBrandForum;
                        this.ijb.threadList.add(next2);
                        this.ijn.add(tid2);
                    }
                }
            }
        }
        this.iiG.a(this.ijb);
        return true;
    }

    public void an(bw bwVar) {
        if (bwVar != null && this.ijb != null && this.ijb.threadList != null) {
            if (y.isEmpty(this.ijb.threadList)) {
                this.ijb.threadList.add(bwVar);
            } else {
                if (this.ijb.threadList.size() == 1 && (this.ijb.threadList.get(0) instanceof s)) {
                    this.ijb.threadList.remove(0);
                }
                this.ijb.threadList.add(0, bwVar);
            }
            this.iiG.a(this.ijb);
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
                            this.ijk.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bw) qVar).getId(), 0L);
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
                    this.iiG.a(errorData);
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
                            this.ijk.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bw) qVar).getId(), 0L);
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
                    this.iiG.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.ijb == null || y.isEmpty(this.ijb.threadList)) ? false : true;
    }

    public d csz() {
        return this.ijb;
    }

    public void eS(long j) {
        this.ijo = j;
    }

    public boolean csA() {
        return this.ijm;
    }
}
