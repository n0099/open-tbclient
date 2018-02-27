package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.k.p;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.tbadkCore.l;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int cGY;
    private i dFn;
    private final com.baidu.tieba.frs.loadmore.a dSu;
    private boolean dSv;
    private long dSw;
    private final ArrayList<com.baidu.adp.widget.ListView.i> dSx;
    private final ArrayList<com.baidu.adp.widget.ListView.i> dSy;
    private final com.baidu.adp.framework.listener.a dSz;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes2.dex */
    public interface a {
        void J(ArrayList<com.baidu.adp.widget.ListView.i> arrayList);

        void lu(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.dSv = false;
        this.dSw = 0L;
        this.dSx = new ArrayList<>();
        this.dSy = new ArrayList<>();
        this.mPn = 1;
        this.cGY = -1;
        this.mPageType = 1;
        this.dSz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.dSu != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.dSu.lu(FrsLoadMoreModel.this.dSu.getPageContext().getString(d.j.neterror));
                    } else if (responsedMessage.getError() == 0) {
                        l avk = FrsLoadMoreModel.this.dSu.avk();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (avk != null) {
                                avk.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dSu.J(loadMoreHttpResponseMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (avk != null) {
                                avk.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dSu.J(loadMoreResponseSocketMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.dSu.getForumName()) && r.boe().bnY() != null) {
                            r.boe().bnY().f(FrsLoadMoreModel.this.dSu.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        FrsLoadMoreModel.this.dSu.lu(responsedMessage.getErrorString());
                    } else {
                        FrsLoadMoreModel.this.dSu.lu(FrsLoadMoreModel.this.dSu.getPageContext().getString(d.j.neterror));
                    }
                }
            }
        };
        this.dSu = aVar;
        setUniqueId(this.dSu.getUniqueId());
        this.dFn = iVar;
        this.dSz.getHttpMessageListener().setSelfListener(true);
        this.dSz.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dSz);
    }

    public int auT() {
        return this.cGY;
    }

    public void setHasMore(int i) {
        this.cGY = i;
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
        registerListener(this.dSz);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || v.E(list)) {
            this.loadingDone = true;
            return;
        }
        String bu = bu(list);
        if (!TextUtils.isEmpty(bu)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(bu);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(t.Pm(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.dSw = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.boe().bnY() != null) {
            loadMoreRequestMessage.setLoadCount(r.boe().bnY().V(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.k.l lVar;
        if (!this.dSv) {
            this.dSv = true;
            if (p.Ov().Ow() && (lVar = new com.baidu.tbadk.k.l(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dSw)) != null) {
                lVar.Oq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.k.l lVar;
        if (!this.dSv) {
            this.dSv = true;
            if (p.Ov().Ow() && (lVar = new com.baidu.tbadk.k.l(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dSw)) != null) {
                lVar.Oq();
            }
        }
    }

    private String bu(List<Long> list) {
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
        this.dSx.clear();
        this.dSy.clear();
        this.cGY = -1;
        this.mPn = 1;
    }

    public boolean bv(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, boolean z3, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, e eVar) {
        if (z3) {
            this.dSx.clear();
            this.dSy.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<com.baidu.adp.widget.ListView.i> it = this.dSx.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.i next = it.next();
            if (next instanceof bd) {
                bd bdVar = (bd) next;
                if (bdVar.getTid() != null) {
                    hashSet.add(bdVar.getTid());
                }
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.i> arrayList2 = new ArrayList<>();
        if (!v.E(arrayList)) {
            Iterator<com.baidu.adp.widget.ListView.i> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.baidu.adp.widget.ListView.i next2 = it2.next();
                if (next2 instanceof bd) {
                    bd bdVar2 = (bd) next2;
                    bdVar2.cZ(this.dSu.getForumName());
                    if (bdVar2.zL()) {
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
        if (this.dFn != null) {
            this.dFn.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int FS = TbadkCoreApplication.getInst().getListItemRule().FS() - this.dSx.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < FS) {
                this.dSx.add(arrayList2.get(i));
            } else {
                this.dSy.add(arrayList2.get(i));
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.i> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.dSx);
        arrayList3.addAll(this.dSy);
        if (this.dSu instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.dSu, this.dSu.avk(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> azh() {
        int i;
        int size = this.dSy.size() + 30;
        int FR = TbadkCoreApplication.getInst().getListItemRule().FR();
        if (size > FR && this.dSy.size() > (i = size - FR)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dSy.remove(0);
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
        arrayList.addAll(this.dSx);
        arrayList.addAll(this.dSy);
        return arrayList;
    }
}
