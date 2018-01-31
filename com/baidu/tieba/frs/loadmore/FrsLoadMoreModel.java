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
    private int cDr;
    private i dCB;
    private final com.baidu.adp.framework.listener.a dPA;
    private final com.baidu.tieba.frs.loadmore.a dPv;
    private boolean dPw;
    private long dPx;
    private final ArrayList<com.baidu.adp.widget.ListView.i> dPy;
    private final ArrayList<com.baidu.adp.widget.ListView.i> dPz;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes2.dex */
    public interface a {
        void J(ArrayList<com.baidu.adp.widget.ListView.i> arrayList);

        void lm(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.dPw = false;
        this.dPx = 0L;
        this.dPy = new ArrayList<>();
        this.dPz = new ArrayList<>();
        this.mPn = 1;
        this.cDr = -1;
        this.mPageType = 1;
        this.dPA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.dPv != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.dPv.lm(FrsLoadMoreModel.this.dPv.getPageContext().getString(d.j.neterror));
                    } else if (responsedMessage.getError() == 0) {
                        l auv = FrsLoadMoreModel.this.dPv.auv();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (auv != null) {
                                auv.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dPv.J(loadMoreHttpResponseMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (auv != null) {
                                auv.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dPv.J(loadMoreResponseSocketMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.dPv.getForumName()) && q.bmS().bmM() != null) {
                            q.bmS().bmM().f(FrsLoadMoreModel.this.dPv.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        FrsLoadMoreModel.this.dPv.lm(responsedMessage.getErrorString());
                    } else {
                        FrsLoadMoreModel.this.dPv.lm(FrsLoadMoreModel.this.dPv.getPageContext().getString(d.j.neterror));
                    }
                }
            }
        };
        this.dPv = aVar;
        setUniqueId(this.dPv.getUniqueId());
        this.dCB = iVar;
        this.dPA.getHttpMessageListener().setSelfListener(true);
        this.dPA.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dPA);
    }

    public int aue() {
        return this.cDr;
    }

    public void setHasMore(int i) {
        this.cDr = i;
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
        registerListener(this.dPA);
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
            loadMoreRequestMessage.setLastClickTid(b.c(t.OI(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.dPx = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (q.bmS().bmM() != null) {
            loadMoreRequestMessage.setLoadCount(q.bmS().bmM().X(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        m mVar;
        if (!this.dPw) {
            this.dPw = true;
            if (r.NQ().NR() && (mVar = new m(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dPx)) != null) {
                mVar.NL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        m mVar;
        if (!this.dPw) {
            this.dPw = true;
            if (r.NQ().NR() && (mVar = new m(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dPx)) != null) {
                mVar.NL();
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
        this.dPy.clear();
        this.dPz.clear();
        this.cDr = -1;
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
            this.dPy.clear();
            this.dPz.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<com.baidu.adp.widget.ListView.i> it = this.dPy.iterator();
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
                    bdVar2.cO(this.dPv.getForumName());
                    if (bdVar2.zr()) {
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
        if (this.dCB != null) {
            this.dCB.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int Fx = TbadkCoreApplication.getInst().getListItemRule().Fx() - this.dPy.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < Fx) {
                this.dPy.add(arrayList2.get(i));
            } else {
                this.dPz.add(arrayList2.get(i));
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.i> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.dPy);
        arrayList3.addAll(this.dPz);
        if (this.dPv instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.e.a.a((com.baidu.tieba.InjectPlugin.a.b) this.dPv, this.dPv.auv(), arrayList2, getPn());
            com.baidu.tieba.frs.e.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> ayg() {
        int i;
        int size = this.dPz.size() + 30;
        int Fw = TbadkCoreApplication.getInst().getListItemRule().Fw();
        if (size > Fw && this.dPz.size() > (i = size - Fw)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dPz.remove(0);
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
        arrayList.addAll(this.dPy);
        arrayList.addAll(this.dPz);
        return arrayList;
    }
}
