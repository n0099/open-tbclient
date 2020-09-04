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
    private FrsCommonTabFragment ibC;
    private d ibX;
    private FrsCommonTabRequestData ice;
    private FrsCommonTabNetModel icf;
    private FrsDynamicRequestData icg;
    private FrsDynamicModel ich;
    private boolean ici;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> icj = new HashSet<>();
    private int mPn = 1;
    private long ick = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.ibC = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.icg = new FrsDynamicRequestData();
                this.icg.forumId = i;
                this.icg.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.icg.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.icg.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.ich = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.icg);
                this.ich.a(this);
                this.ich.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.ice = new FrsCommonTabRequestData();
            this.ice.fid = i;
            this.ice.tabId = i2;
            this.ice.isDefaultNavTab = xE(i2) ? 1 : 0;
            this.ice.tabName = str;
            this.ice.isGeneralTab = i3;
            this.icf = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.ice);
            this.icf.a(this);
            this.icf.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.ice != null) {
            this.ice.tabType = i;
        }
    }

    private boolean xE(int i) {
        return (this.ibC == null || this.ibC.ibP == null || this.ibC.ibP.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void xF(int i) {
        this.ici = true;
        if (!this.isDynamic) {
            if (!this.icf.isLoading()) {
                this.mPn = 1;
                this.ice.pn = this.mPn;
                this.ice.sortType = i;
                if (this.ick >= 0) {
                    this.ice.lastThreadId = this.ick;
                }
                this.icf.loadData();
            }
        } else if (!this.ich.isLoading()) {
            if (au.bjr().bjs()) {
                this.icg.qType = 2;
            } else {
                this.icg.qType = 1;
            }
            this.icg.lastThreadId = 0L;
            this.ich.loadData();
        }
    }

    public void xG(int i) {
        this.ici = false;
        if (!this.isDynamic) {
            if (!this.icf.isLoading()) {
                this.mPn++;
                this.ice.pn = this.mPn;
                this.ice.sortType = i;
                this.ice.lastThreadId = -1L;
                this.icf.loadData();
            }
        } else if (!this.ich.isLoading()) {
            if (au.bjr().bjs()) {
                this.icg.qType = 2;
            } else {
                this.icg.qType = 1;
            }
            this.ich.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.ici) {
            this.ibX = dVar;
            this.icj.clear();
            Iterator<q> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof bw) {
                    String tid = ((bw) next).getTid();
                    if (!this.icj.contains(tid)) {
                        this.icj.add(tid);
                    }
                }
            }
        } else {
            this.ibX.hasMore = dVar.hasMore;
            this.ibX.userMap.putAll(dVar.userMap);
            Iterator<q> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof bw) {
                    String tid2 = ((bw) next2).getTid();
                    if (!this.icj.contains(tid2)) {
                        ((bw) next2).edU = this.ibC.isBrandForum;
                        this.ibX.threadList.add(next2);
                        this.icj.add(tid2);
                    }
                }
            }
        }
        this.ibC.a(this.ibX);
        return true;
    }

    public void am(bw bwVar) {
        if (bwVar != null && this.ibX != null && this.ibX.threadList != null) {
            if (y.isEmpty(this.ibX.threadList)) {
                this.ibX.threadList.add(bwVar);
            } else {
                if (this.ibX.threadList.size() == 1 && (this.ibX.threadList.get(0) instanceof s)) {
                    this.ibX.threadList.remove(0);
                }
                this.ibX.threadList.add(0, bwVar);
            }
            this.ibC.a(this.ibX);
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
                            this.icg.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bw) qVar).getId(), 0L);
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
                    this.ibC.a(errorData);
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
                            this.icg.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bw) qVar).getId(), 0L);
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
                    this.ibC.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.ibX == null || y.isEmpty(this.ibX.threadList)) ? false : true;
    }

    public d cpm() {
        return this.ibX;
    }

    public void eI(long j) {
        this.ick = j;
    }

    public boolean cpn() {
        return this.ici;
    }
}
