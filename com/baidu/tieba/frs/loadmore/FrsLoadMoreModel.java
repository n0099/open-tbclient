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
import com.baidu.tbadk.k.m;
import com.baidu.tbadk.k.r;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.recapp.q;
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
    private int cDe;
    private i dCg;
    private final com.baidu.tieba.frs.loadmore.a dPa;
    private boolean dPb;
    private long dPc;
    private final ArrayList<com.baidu.adp.widget.ListView.i> dPd;
    private final ArrayList<com.baidu.adp.widget.ListView.i> dPe;
    private final com.baidu.adp.framework.listener.a dPf;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes2.dex */
    public interface a {
        void J(ArrayList<com.baidu.adp.widget.ListView.i> arrayList);

        void lf(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.dPb = false;
        this.dPc = 0L;
        this.dPd = new ArrayList<>();
        this.dPe = new ArrayList<>();
        this.mPn = 1;
        this.cDe = -1;
        this.mPageType = 1;
        this.dPf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.dPa != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.dPa.lf(FrsLoadMoreModel.this.dPa.getPageContext().getString(d.j.neterror));
                    } else if (responsedMessage.getError() == 0) {
                        l auq = FrsLoadMoreModel.this.dPa.auq();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (auq != null) {
                                auq.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dPa.J(loadMoreHttpResponseMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (auq != null) {
                                auq.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dPa.J(loadMoreResponseSocketMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.dPa.getForumName()) && q.bmR().bmL() != null) {
                            q.bmR().bmL().f(FrsLoadMoreModel.this.dPa.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        FrsLoadMoreModel.this.dPa.lf(responsedMessage.getErrorString());
                    } else {
                        FrsLoadMoreModel.this.dPa.lf(FrsLoadMoreModel.this.dPa.getPageContext().getString(d.j.neterror));
                    }
                }
            }
        };
        this.dPa = aVar;
        setUniqueId(this.dPa.getUniqueId());
        this.dCg = iVar;
        this.dPf.getHttpMessageListener().setSelfListener(true);
        this.dPf.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dPf);
    }

    public int atZ() {
        return this.cDe;
    }

    public void setHasMore(int i) {
        this.cDe = i;
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
        registerListener(this.dPf);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || v.E(list)) {
            this.loadingDone = true;
            return;
        }
        String bs = bs(list);
        if (!TextUtils.isEmpty(bs)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(bs);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(t.OG(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.dPc = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (q.bmR().bmL() != null) {
            loadMoreRequestMessage.setLoadCount(q.bmR().bmL().X(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        m mVar;
        if (!this.dPb) {
            this.dPb = true;
            if (r.NO().NP() && (mVar = new m(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dPc)) != null) {
                mVar.NJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        m mVar;
        if (!this.dPb) {
            this.dPb = true;
            if (r.NO().NP() && (mVar = new m(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dPc)) != null) {
                mVar.NJ();
            }
        }
    }

    private String bs(List<Long> list) {
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
        this.dPd.clear();
        this.dPe.clear();
        this.cDe = -1;
        this.mPn = 1;
    }

    public boolean bt(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, boolean z3, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, e eVar) {
        if (z3) {
            this.dPd.clear();
            this.dPe.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<com.baidu.adp.widget.ListView.i> it = this.dPd.iterator();
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
                    bdVar2.cO(this.dPa.getForumName());
                    if (bdVar2.zq()) {
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
        if (this.dCg != null) {
            this.dCg.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int Fv = TbadkCoreApplication.getInst().getListItemRule().Fv() - this.dPd.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < Fv) {
                this.dPd.add(arrayList2.get(i));
            } else {
                this.dPe.add(arrayList2.get(i));
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.i> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.dPd);
        arrayList3.addAll(this.dPe);
        if (this.dPa instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.e.a.a((com.baidu.tieba.InjectPlugin.a.b) this.dPa, this.dPa.auq(), arrayList2, getPn());
            com.baidu.tieba.frs.e.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> ayb() {
        int i;
        int size = this.dPe.size() + 30;
        int Fu = TbadkCoreApplication.getInst().getListItemRule().Fu();
        if (size > Fu && this.dPe.size() > (i = size - Fu)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dPe.remove(0);
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
        arrayList.addAll(this.dPd);
        arrayList.addAll(this.dPe);
        return arrayList;
    }
}
