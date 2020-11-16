package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.av;
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
    private FrsCommonTabFragment iQJ;
    private d iRe;
    private FrsCommonTabRequestData iRl;
    private FrsCommonTabNetModel iRm;
    private FrsDynamicRequestData iRn;
    private FrsDynamicModel iRo;
    private boolean iRp;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> iRq = new HashSet<>();
    private int mPn = 1;
    private long iRr = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.iQJ = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.iRn = new FrsDynamicRequestData();
                this.iRn.forumId = i;
                this.iRn.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.iRn.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.iRn.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.iRo = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.iRn);
                this.iRo.a(this);
                this.iRo.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.iRl = new FrsCommonTabRequestData();
            this.iRl.fid = i;
            this.iRl.tabId = i2;
            this.iRl.isDefaultNavTab = zN(i2) ? 1 : 0;
            this.iRl.tabName = str;
            this.iRl.isGeneralTab = i3;
            this.iRm = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.iRl);
            this.iRm.a(this);
            this.iRm.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.iRl != null) {
            this.iRl.tabType = i;
        }
    }

    private boolean zN(int i) {
        return (this.iQJ == null || this.iQJ.iQW == null || this.iQJ.iQW.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void zO(int i) {
        this.iRp = true;
        if (!this.isDynamic) {
            if (!this.iRm.isLoading()) {
                this.mPn = 1;
                this.iRl.pn = this.mPn;
                this.iRl.sortType = i;
                if (this.iRr >= 0) {
                    this.iRl.lastThreadId = this.iRr;
                }
                this.iRm.loadData();
            }
        } else if (!this.iRo.isLoading()) {
            if (av.bqC().bqD()) {
                this.iRn.qType = 2;
            } else {
                this.iRn.qType = 1;
            }
            this.iRn.lastThreadId = 0L;
            this.iRo.loadData();
        }
    }

    public void zP(int i) {
        this.iRp = false;
        if (!this.isDynamic) {
            if (!this.iRm.isLoading()) {
                this.mPn++;
                this.iRl.pn = this.mPn;
                this.iRl.sortType = i;
                this.iRl.lastThreadId = -1L;
                this.iRm.loadData();
            }
        } else if (!this.iRo.isLoading()) {
            if (av.bqC().bqD()) {
                this.iRn.qType = 2;
            } else {
                this.iRn.qType = 1;
            }
            this.iRo.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.iRp) {
            this.iRe = dVar;
            this.iRq.clear();
            Iterator<q> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof bx) {
                    String tid = ((bx) next).getTid();
                    if (!this.iRq.contains(tid)) {
                        this.iRq.add(tid);
                    }
                }
            }
        } else {
            this.iRe.hasMore = dVar.hasMore;
            this.iRe.userMap.putAll(dVar.userMap);
            Iterator<q> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof bx) {
                    String tid2 = ((bx) next2).getTid();
                    if (!this.iRq.contains(tid2)) {
                        ((bx) next2).eER = this.iQJ.isBrandForum;
                        this.iRe.threadList.add(next2);
                        this.iRq.add(tid2);
                    }
                }
            }
        }
        this.iQJ.a(this.iRe);
        return true;
    }

    public void ap(bx bxVar) {
        if (bxVar != null && this.iRe != null && this.iRe.threadList != null) {
            if (y.isEmpty(this.iRe.threadList)) {
                this.iRe.threadList.add(bxVar);
            } else {
                if (this.iRe.threadList.size() == 1 && (this.iRe.threadList.get(0) instanceof s)) {
                    this.iRe.threadList.remove(0);
                }
                this.iRe.threadList.add(0, bxVar);
            }
            this.iQJ.a(this.iRe);
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
                        if (qVar instanceof bx) {
                            this.iRn.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bx) qVar).getId(), 0L);
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
                    this.iQJ.a(errorData);
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
                        if (qVar instanceof bx) {
                            this.iRn.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bx) qVar).getId(), 0L);
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
                    this.iQJ.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.iRe == null || y.isEmpty(this.iRe.threadList)) ? false : true;
    }

    public d cBh() {
        return this.iRe;
    }

    public void fJ(long j) {
        this.iRr = j;
    }

    public boolean cBi() {
        return this.iRp;
    }
}
