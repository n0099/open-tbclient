package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes22.dex */
public class c implements NetModel.b {
    private boolean isDynamic;
    private FrsCommonTabFragment jbA;
    private d jbW;
    private FrsCommonTabRequestData jcd;
    private FrsCommonTabNetModel jce;
    private FrsDynamicRequestData jcf;
    private FrsDynamicModel jcg;
    private boolean jch;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> jci = new HashSet<>();
    private int mPn = 1;
    private long jcj = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.jbA = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.jcf = new FrsDynamicRequestData();
                this.jcf.forumId = i;
                this.jcf.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.jcf.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.jcf.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.jcg = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.jcf);
                this.jcg.a(this);
                this.jcg.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.jcd = new FrsCommonTabRequestData();
            this.jcd.fid = i;
            this.jcd.tabId = i2;
            this.jcd.isDefaultNavTab = As(i2) ? 1 : 0;
            this.jcd.tabName = str;
            this.jcd.isGeneralTab = i3;
            this.jce = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.jcd);
            this.jce.a(this);
            this.jce.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.jcd != null) {
            this.jcd.tabType = i;
        }
    }

    private boolean As(int i) {
        return (this.jbA == null || this.jbA.jbO == null || this.jbA.jbO.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void At(int i) {
        this.jch = true;
        if (!this.isDynamic) {
            if (!this.jce.isLoading()) {
                this.mPn = 1;
                this.jcd.pn = this.mPn;
                this.jcd.sortType = i;
                if (this.jcj >= 0) {
                    this.jcd.lastThreadId = this.jcj;
                }
                this.jce.loadData();
            }
        } else if (!this.jcg.isLoading()) {
            if (av.btX().btY()) {
                this.jcf.qType = 2;
            } else {
                this.jcf.qType = 1;
            }
            this.jcf.lastThreadId = 0L;
            this.jcg.loadData();
        }
    }

    public void Au(int i) {
        this.jch = false;
        if (!this.isDynamic) {
            if (!this.jce.isLoading()) {
                this.mPn++;
                this.jcd.pn = this.mPn;
                this.jcd.sortType = i;
                this.jcd.lastThreadId = -1L;
                this.jce.loadData();
            }
        } else if (!this.jcg.isLoading()) {
            if (av.btX().btY()) {
                this.jcf.qType = 2;
            } else {
                this.jcf.qType = 1;
            }
            this.jcg.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.jch) {
            this.jbW = dVar;
            this.jci.clear();
            Iterator<q> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof by) {
                    String tid = ((by) next).getTid();
                    if (!this.jci.contains(tid)) {
                        this.jci.add(tid);
                    }
                }
            }
        } else {
            this.jbW.hasMore = dVar.hasMore;
            this.jbW.userMap.putAll(dVar.userMap);
            Iterator<q> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof by) {
                    String tid2 = ((by) next2).getTid();
                    if (!this.jci.contains(tid2)) {
                        ((by) next2).eLT = this.jbA.isBrandForum;
                        this.jbW.threadList.add(next2);
                        this.jci.add(tid2);
                    }
                }
            }
        }
        this.jbA.a(this.jbW);
        return true;
    }

    public void ap(by byVar) {
        if (byVar != null && this.jbW != null && this.jbW.threadList != null) {
            if (y.isEmpty(this.jbW.threadList)) {
                this.jbW.threadList.add(byVar);
            } else {
                if (this.jbW.threadList.size() == 1 && (this.jbW.threadList.get(0) instanceof s)) {
                    this.jbW.threadList.remove(0);
                }
                this.jbW.threadList.add(0, byVar);
            }
            this.jbA.a(this.jbW);
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
                        if (qVar instanceof by) {
                            this.jcf.lastThreadId = com.baidu.adp.lib.f.b.toLong(((by) qVar).getId(), 0L);
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
                    this.jbA.a(errorData);
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
                        if (qVar instanceof by) {
                            this.jcf.lastThreadId = com.baidu.adp.lib.f.b.toLong(((by) qVar).getId(), 0L);
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
                    this.jbA.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.jbW == null || y.isEmpty(this.jbW.threadList)) ? false : true;
    }

    public d cFx() {
        return this.jbW;
    }

    public void gn(long j) {
        this.jcj = j;
    }

    public boolean cFy() {
        return this.jch;
    }
}
