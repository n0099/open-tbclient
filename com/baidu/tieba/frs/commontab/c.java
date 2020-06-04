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
    private FrsCommonTabFragment huA;
    private d huV;
    private FrsCommonTabRequestData huZ;
    private FrsCommonTabNetModel hva;
    private FrsDynamicRequestData hvb;
    private FrsDynamicModel hvc;
    private boolean hvd;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> hve = new HashSet<>();
    private int mPn = 1;
    private long hvf = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.huA = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.hvb = new FrsDynamicRequestData();
                this.hvb.forumId = i;
                this.hvb.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.hvb.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.hvb.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.hvc = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.hvb);
                this.hvc.a(this);
                this.hvc.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.huZ = new FrsCommonTabRequestData();
            this.huZ.fid = i;
            this.huZ.tabId = i2;
            this.huZ.isDefaultNavTab = up(i2) ? 1 : 0;
            this.huZ.tabName = str;
            this.huZ.isGeneralTab = i3;
            this.hva = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.huZ);
            this.hva.a(this);
            this.hva.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.huZ != null) {
            this.huZ.tabType = i;
        }
    }

    private boolean up(int i) {
        return (this.huA == null || this.huA.huN == null || this.huA.huN.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void uq(int i) {
        this.hvd = true;
        if (!this.isDynamic) {
            if (!this.hva.isLoading()) {
                this.mPn = 1;
                this.huZ.pn = this.mPn;
                this.huZ.sortType = i;
                if (this.hvf >= 0) {
                    this.huZ.lastThreadId = this.hvf;
                }
                this.hva.loadData();
            }
        } else if (!this.hvc.isLoading()) {
            if (ar.aUX().aUY()) {
                this.hvb.qType = 2;
            } else {
                this.hvb.qType = 1;
            }
            this.hvb.lastThreadId = 0L;
            this.hvc.loadData();
        }
    }

    public void ur(int i) {
        this.hvd = false;
        if (!this.isDynamic) {
            if (!this.hva.isLoading()) {
                this.mPn++;
                this.huZ.pn = this.mPn;
                this.huZ.sortType = i;
                this.huZ.lastThreadId = -1L;
                this.hva.loadData();
            }
        } else if (!this.hvc.isLoading()) {
            if (ar.aUX().aUY()) {
                this.hvb.qType = 2;
            } else {
                this.hvb.qType = 1;
            }
            this.hvc.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.hvd) {
            this.huV = dVar;
            this.hve.clear();
            Iterator<o> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next instanceof bk) {
                    String tid = ((bk) next).getTid();
                    if (!this.hve.contains(tid)) {
                        this.hve.add(tid);
                    }
                }
            }
        } else {
            this.huV.hasMore = dVar.hasMore;
            this.huV.userMap.putAll(dVar.userMap);
            Iterator<o> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                o next2 = it2.next();
                if (next2 instanceof bk) {
                    String tid2 = ((bk) next2).getTid();
                    if (!this.hve.contains(tid2)) {
                        ((bk) next2).dHx = this.huA.isBrandForum;
                        this.huV.threadList.add(next2);
                        this.hve.add(tid2);
                    }
                }
            }
        }
        this.huA.a(this.huV);
        return true;
    }

    public void ap(bk bkVar) {
        if (bkVar != null && this.huV != null && this.huV.threadList != null) {
            if (v.isEmpty(this.huV.threadList)) {
                this.huV.threadList.add(bkVar);
            } else {
                if (this.huV.threadList.size() == 1 && (this.huV.threadList.get(0) instanceof p)) {
                    this.huV.threadList.remove(0);
                }
                this.huV.threadList.add(0, bkVar);
            }
            this.huA.a(this.huV);
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
                            this.hvb.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bk) oVar).getId(), 0L);
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
                    this.huA.a(errorData);
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
                            this.hvb.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bk) oVar).getId(), 0L);
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
                    this.huA.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.huV == null || v.isEmpty(this.huV.threadList)) ? false : true;
    }

    public void eg(long j) {
        this.hvf = j;
    }

    public boolean bXV() {
        return this.hvd;
    }
}
