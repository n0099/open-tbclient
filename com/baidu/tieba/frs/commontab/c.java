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
    private FrsCommonTabFragment jbC;
    private d jbY;
    private FrsCommonTabRequestData jcf;
    private FrsCommonTabNetModel jcg;
    private FrsDynamicRequestData jch;
    private FrsDynamicModel jci;
    private boolean jcj;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> jck = new HashSet<>();
    private int mPn = 1;
    private long jcl = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.jbC = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.jch = new FrsDynamicRequestData();
                this.jch.forumId = i;
                this.jch.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.jch.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.jch.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.jci = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.jch);
                this.jci.a(this);
                this.jci.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.jcf = new FrsCommonTabRequestData();
            this.jcf.fid = i;
            this.jcf.tabId = i2;
            this.jcf.isDefaultNavTab = As(i2) ? 1 : 0;
            this.jcf.tabName = str;
            this.jcf.isGeneralTab = i3;
            this.jcg = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.jcf);
            this.jcg.a(this);
            this.jcg.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.jcf != null) {
            this.jcf.tabType = i;
        }
    }

    private boolean As(int i) {
        return (this.jbC == null || this.jbC.jbQ == null || this.jbC.jbQ.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void At(int i) {
        this.jcj = true;
        if (!this.isDynamic) {
            if (!this.jcg.isLoading()) {
                this.mPn = 1;
                this.jcf.pn = this.mPn;
                this.jcf.sortType = i;
                if (this.jcl >= 0) {
                    this.jcf.lastThreadId = this.jcl;
                }
                this.jcg.loadData();
            }
        } else if (!this.jci.isLoading()) {
            if (av.btX().btY()) {
                this.jch.qType = 2;
            } else {
                this.jch.qType = 1;
            }
            this.jch.lastThreadId = 0L;
            this.jci.loadData();
        }
    }

    public void Au(int i) {
        this.jcj = false;
        if (!this.isDynamic) {
            if (!this.jcg.isLoading()) {
                this.mPn++;
                this.jcf.pn = this.mPn;
                this.jcf.sortType = i;
                this.jcf.lastThreadId = -1L;
                this.jcg.loadData();
            }
        } else if (!this.jci.isLoading()) {
            if (av.btX().btY()) {
                this.jch.qType = 2;
            } else {
                this.jch.qType = 1;
            }
            this.jci.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.jcj) {
            this.jbY = dVar;
            this.jck.clear();
            Iterator<q> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof by) {
                    String tid = ((by) next).getTid();
                    if (!this.jck.contains(tid)) {
                        this.jck.add(tid);
                    }
                }
            }
        } else {
            this.jbY.hasMore = dVar.hasMore;
            this.jbY.userMap.putAll(dVar.userMap);
            Iterator<q> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof by) {
                    String tid2 = ((by) next2).getTid();
                    if (!this.jck.contains(tid2)) {
                        ((by) next2).eLT = this.jbC.isBrandForum;
                        this.jbY.threadList.add(next2);
                        this.jck.add(tid2);
                    }
                }
            }
        }
        this.jbC.a(this.jbY);
        return true;
    }

    public void ap(by byVar) {
        if (byVar != null && this.jbY != null && this.jbY.threadList != null) {
            if (y.isEmpty(this.jbY.threadList)) {
                this.jbY.threadList.add(byVar);
            } else {
                if (this.jbY.threadList.size() == 1 && (this.jbY.threadList.get(0) instanceof s)) {
                    this.jbY.threadList.remove(0);
                }
                this.jbY.threadList.add(0, byVar);
            }
            this.jbC.a(this.jbY);
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
                            this.jch.lastThreadId = com.baidu.adp.lib.f.b.toLong(((by) qVar).getId(), 0L);
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
                    this.jbC.a(errorData);
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
                            this.jch.lastThreadId = com.baidu.adp.lib.f.b.toLong(((by) qVar).getId(), 0L);
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
                    this.jbC.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.jbY == null || y.isEmpty(this.jbY.threadList)) ? false : true;
    }

    public d cFy() {
        return this.jbY;
    }

    public void gn(long j) {
        this.jcl = j;
    }

    public boolean cFz() {
        return this.jcj;
    }
}
