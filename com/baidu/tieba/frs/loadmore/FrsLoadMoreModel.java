package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.k.m;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int cfZ;
    private i diI;
    private final com.baidu.tieba.frs.loadmore.a dxf;
    private boolean dxg;
    private long dxh;
    private final ArrayList<h> dxi;
    private final ArrayList<h> dxj;
    private c.a dxk;
    private final com.baidu.adp.framework.listener.a dxl;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes2.dex */
    public interface a {
        void I(ArrayList<h> arrayList);

        void mg(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.dxg = false;
        this.dxh = 0L;
        this.dxi = new ArrayList<>();
        this.dxj = new ArrayList<>();
        this.mPn = 1;
        this.cfZ = -1;
        this.mPageType = 1;
        this.dxl = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.dxf != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.dxf.mg(FrsLoadMoreModel.this.dxf.getPageContext().getString(d.k.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.dxf.mg(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.dxf.mg(FrsLoadMoreModel.this.dxf.getPageContext().getString(d.k.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        l atI = FrsLoadMoreModel.this.dxf.atI();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (atI != null) {
                                atI.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dxf.I(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dxf instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dxf).aSW = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (atI != null) {
                                atI.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dxf.I(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dxf instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dxf).aSW = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.dxf.getForumName()) && r.boj().bod() != null) {
                            r.boj().bod().f(FrsLoadMoreModel.this.dxf.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.dxf = aVar;
        setUniqueId(this.dxf.getUniqueId());
        this.diI = iVar;
        this.dxl.getHttpMessageListener().setSelfListener(true);
        this.dxl.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dxl);
    }

    public int ats() {
        return this.cfZ;
    }

    public void setHasMore(int i) {
        this.cfZ = i;
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

    public void setPageType(int i) {
        this.mPageType = i;
    }

    public void registerListener() {
        registerListener(this.dxl);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || w.z(list)) {
            this.loadingDone = true;
            return;
        }
        String bt = bt(list);
        if (!TextUtils.isEmpty(bt)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(bt);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(u.Lj(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.dxh = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.boj().bod() != null) {
            loadMoreRequestMessage.setLoadCount(r.boj().bod().R(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.k.i iVar;
        if (!this.dxg) {
            this.dxg = true;
            if (m.Ks().Kt() && (iVar = new com.baidu.tbadk.k.i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dxh)) != null) {
                iVar.Kp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.k.i iVar;
        if (!this.dxg) {
            this.dxg = true;
            if (m.Ks().Kt() && (iVar = new com.baidu.tbadk.k.i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dxh)) != null) {
                iVar.Kp();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.Ks().Kt() && (this.dxf instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.dxh;
            com.baidu.tbadk.k.i iVar = new com.baidu.tbadk.k.i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.dxf).aSW, false, currentTimeMillis);
            if (iVar != null) {
                iVar.aTf = currentTimeMillis;
                iVar.bW(true);
            }
        }
    }

    private String bt(List<Long> list) {
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
                    sb.append(l).append(",");
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
        this.dxi.clear();
        this.dxj.clear();
        this.cfZ = -1;
        this.mPn = 1;
    }

    public boolean bu(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<h> a(boolean z, boolean z2, boolean z3, ArrayList<h> arrayList, e eVar) {
        if (z3) {
            this.dxi.clear();
            this.dxj.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<h> it = this.dxi.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next instanceof bd) {
                bd bdVar = (bd) next;
                if (bdVar.getTid() != null) {
                    hashSet.add(bdVar.getTid());
                }
            }
        }
        ArrayList<h> arrayList2 = new ArrayList<>();
        if (!w.z(arrayList)) {
            Iterator<h> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (next2 instanceof bd) {
                    bd bdVar2 = (bd) next2;
                    bdVar2.dm(this.dxf.getForumName());
                    if (bdVar2.vI()) {
                        if (!hashSet.contains(bdVar2.getTid())) {
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
        if (this.diI != null) {
            this.diI.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int Cf = TbadkCoreApplication.getInst().getListItemRule().Cf() - this.dxi.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < Cf) {
                this.dxi.add(arrayList2.get(i));
            } else {
                this.dxj.add(arrayList2.get(i));
            }
        }
        ArrayList<h> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.dxi);
        arrayList3.addAll(this.dxj);
        if (this.dxf instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.dxf, this.dxf.atI(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<h> ayj() {
        int i;
        int size = this.dxj.size() + 30;
        int Ce = TbadkCoreApplication.getInst().getListItemRule().Ce();
        if (size > Ce && this.dxj.size() > (i = size - Ce)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dxj.remove(0);
            }
        }
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.addAll(this.dxi);
        arrayList.addAll(this.dxj);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.dxk = aVar;
    }

    public void ayk() {
        int i;
        int size = this.dxj.size() + 30;
        int Ce = TbadkCoreApplication.getInst().getListItemRule().Ce();
        int y = w.y(this.dxi);
        if (size > Ce && this.dxj.size() > (i = size - Ce)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dxj.remove(0);
                if (this.dxk != null) {
                    this.dxk.removeItem(y);
                }
            }
        }
    }
}
