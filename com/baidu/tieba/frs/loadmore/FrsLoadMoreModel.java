package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.k.m;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int bzE;
    private final ArrayList<f> cAi;
    private final ArrayList<f> cAj;
    private final a cAk;
    private final com.baidu.tieba.frs.f cEq;
    private boolean cEr;
    private long cEs;
    private i crb;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPn;
    private int mSortType;

    public FrsLoadMoreModel(com.baidu.tieba.frs.f fVar, i iVar) {
        super(fVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.cEr = false;
        this.cEs = 0L;
        this.cAi = new ArrayList<>();
        this.cAj = new ArrayList<>();
        this.mPn = 1;
        this.bzE = -1;
        this.cAk = new a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.cEq != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.cEq.kw(FrsLoadMoreModel.this.cEq.getPageContext().getString(d.l.neterror));
                    } else if (responsedMessage.getError() == 0) {
                        com.baidu.tieba.tbadkCore.i ahf = FrsLoadMoreModel.this.cEq.ahf();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (ahf != null) {
                                ahf.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.cEq.G(loadMoreHttpResponseMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (ahf != null) {
                                ahf.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.cEq.G(loadMoreResponseSocketMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.cEq.getForumName()) && r.bfO().bfI() != null) {
                            r.bfO().bfI().g(FrsLoadMoreModel.this.cEq.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        FrsLoadMoreModel.this.cEq.kw(responsedMessage.getErrorString());
                    } else {
                        FrsLoadMoreModel.this.cEq.kw(FrsLoadMoreModel.this.cEq.getPageContext().getString(d.l.neterror));
                    }
                }
            }
        };
        this.cEq = fVar;
        setUniqueId(this.cEq.getUniqueId());
        this.crb = iVar;
        this.cAk.getHttpMessageListener().setSelfListener(true);
        this.cAk.getSocketMessageListener().setSelfListener(true);
        this.cEq.registerListener(this.cAk);
    }

    public int agQ() {
        return this.bzE;
    }

    public void setHasMore(int i) {
        this.bzE = i;
    }

    public int getPn() {
        return this.mPn;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    public void setSortType(int i) {
        this.mSortType = i;
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || v.u(list)) {
            this.loadingDone = true;
            return;
        }
        String aN = aN(list);
        if (!TextUtils.isEmpty(aN)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(aN);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(com.baidu.tbadk.util.r.GO(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.cEs = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.bfO().bfI() != null) {
            loadMoreRequestMessage.setLoadCount(r.bfO().bfI().V(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        m mVar;
        if (!this.cEr) {
            this.cEr = true;
            if (com.baidu.tbadk.k.r.FW().FX() && (mVar = new m(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cEs)) != null) {
                mVar.FR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        m mVar;
        if (!this.cEr) {
            this.cEr = true;
            if (com.baidu.tbadk.k.r.FW().FX() && (mVar = new m(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cEs)) != null) {
                mVar.FR();
            }
        }
    }

    private String aN(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.loadingDone = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.loadIndex != 0) {
            if (this.loadIndex != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.loadingDone = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.loadingDone = true;
            }
            Long l = list.get(i3);
            if (l != null) {
                if (i3 == i - 1) {
                    sb.append(l);
                } else {
                    sb.append(l).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
        }
        return sb.toString();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void resetData() {
        this.loadIndex = 0;
        this.loadingDone = false;
        this.cAi.clear();
        this.cAj.clear();
        this.bzE = -1;
        this.mPn = 1;
    }

    public boolean aO(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<f> a(boolean z, boolean z2, boolean z3, ArrayList<f> arrayList, e eVar) {
        if (z3) {
            this.cAi.clear();
            this.cAj.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<f> it = this.cAi.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (next instanceof bh) {
                bh bhVar = (bh) next;
                if (bhVar.getTid() != null) {
                    hashSet.add(bhVar.getTid());
                }
            }
        }
        ArrayList<f> arrayList2 = new ArrayList<>();
        if (!v.u(arrayList)) {
            Iterator<f> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                f next2 = it2.next();
                if (next2 instanceof bh) {
                    bh bhVar2 = (bh) next2;
                    bhVar2.cB(this.cEq.getForumName());
                    if (bhVar2.rL()) {
                        if (!hashSet.contains(bhVar2.getTid())) {
                            arrayList2.add(next2);
                        }
                    } else {
                        arrayList2.add(next2);
                    }
                } else {
                    arrayList2.add(next2);
                }
            }
        }
        if (this.crb != null) {
            this.crb.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int xO = TbadkCoreApplication.getInst().getListItemRule().xO() - this.cAi.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < xO) {
                this.cAi.add(arrayList2.get(i));
            } else {
                this.cAj.add(arrayList2.get(i));
            }
        }
        ArrayList<f> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.cAi);
        arrayList3.addAll(this.cAj);
        com.baidu.tieba.frs.g.a.a(this.cEq, this.cEq.agK(), arrayList2, getPn());
        com.baidu.tieba.frs.g.a.a(eVar, arrayList2, arrayList3);
        return arrayList3;
    }

    public ArrayList<f> ajU() {
        int i;
        int size = this.cAj.size() + 30;
        int xN = TbadkCoreApplication.getInst().getListItemRule().xN();
        if (size > xN && this.cAj.size() > (i = size - xN)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.cAj.remove(0);
            }
        }
        ArrayList<f> arrayList = new ArrayList<>();
        arrayList.addAll(this.cAi);
        arrayList.addAll(this.cAj);
        return arrayList;
    }
}
