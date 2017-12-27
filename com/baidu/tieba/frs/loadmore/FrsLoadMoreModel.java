package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.k.m;
import com.baidu.tbadk.k.r;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
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
    private int cCU;
    private long dKA;
    private final ArrayList<i> dKB;
    private final ArrayList<i> dKC;
    private final com.baidu.adp.framework.listener.a dKD;
    private final com.baidu.tieba.frs.loadmore.a dKy;
    private boolean dKz;
    private com.baidu.tieba.frs.mc.i dxF;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes2.dex */
    public interface a {
        void J(ArrayList<i> arrayList);

        void kX(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, com.baidu.tieba.frs.mc.i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.dKz = false;
        this.dKA = 0L;
        this.dKB = new ArrayList<>();
        this.dKC = new ArrayList<>();
        this.mPn = 1;
        this.cCU = -1;
        this.mPageType = 1;
        this.dKD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.dKy != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.dKy.kX(FrsLoadMoreModel.this.dKy.getPageContext().getString(d.j.neterror));
                    } else if (responsedMessage.getError() == 0) {
                        l atn = FrsLoadMoreModel.this.dKy.atn();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (atn != null) {
                                atn.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dKy.J(loadMoreHttpResponseMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (atn != null) {
                                atn.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dKy.J(loadMoreResponseSocketMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.dKy.getForumName()) && q.bty().bts() != null) {
                            q.bty().bts().f(FrsLoadMoreModel.this.dKy.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        FrsLoadMoreModel.this.dKy.kX(responsedMessage.getErrorString());
                    } else {
                        FrsLoadMoreModel.this.dKy.kX(FrsLoadMoreModel.this.dKy.getPageContext().getString(d.j.neterror));
                    }
                }
            }
        };
        this.dKy = aVar;
        setUniqueId(this.dKy.getUniqueId());
        this.dxF = iVar;
        this.dKD.getHttpMessageListener().setSelfListener(true);
        this.dKD.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dKD);
    }

    public int asW() {
        return this.cCU;
    }

    public void setHasMore(int i) {
        this.cCU = i;
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
        registerListener(this.dKD);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || v.G(list)) {
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
            loadMoreRequestMessage.setLastClickTid(b.c(t.OS(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.dKA = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (q.bty().bts() != null) {
            loadMoreRequestMessage.setLoadCount(q.bty().bts().X(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        m mVar;
        if (!this.dKz) {
            this.dKz = true;
            if (r.Oa().Ob() && (mVar = new m(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dKA)) != null) {
                mVar.NV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        m mVar;
        if (!this.dKz) {
            this.dKz = true;
            if (r.Oa().Ob() && (mVar = new m(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dKA)) != null) {
                mVar.NV();
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
        this.dKB.clear();
        this.dKC.clear();
        this.cCU = -1;
        this.mPn = 1;
    }

    public boolean bv(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<i> a(boolean z, boolean z2, boolean z3, ArrayList<i> arrayList, e eVar) {
        if (z3) {
            this.dKB.clear();
            this.dKC.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<i> it = this.dKB.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (next instanceof be) {
                be beVar = (be) next;
                if (beVar.getTid() != null) {
                    hashSet.add(beVar.getTid());
                }
            }
        }
        ArrayList<i> arrayList2 = new ArrayList<>();
        if (!v.G(arrayList)) {
            Iterator<i> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                i next2 = it2.next();
                if (next2 instanceof be) {
                    be beVar2 = (be) next2;
                    beVar2.cO(this.dKy.getForumName());
                    if (beVar2.zv()) {
                        if (!hashSet.contains(beVar2.getTid())) {
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
        if (this.dxF != null) {
            this.dxF.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int FE = TbadkCoreApplication.getInst().getListItemRule().FE() - this.dKB.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < FE) {
                this.dKB.add(arrayList2.get(i));
            } else {
                this.dKC.add(arrayList2.get(i));
            }
        }
        ArrayList<i> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.dKB);
        arrayList3.addAll(this.dKC);
        if (this.dKy instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.e.a.a((com.baidu.tieba.InjectPlugin.a.b) this.dKy, this.dKy.atn(), arrayList2, getPn());
            com.baidu.tieba.frs.e.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<i> awY() {
        int i;
        int size = this.dKC.size() + 30;
        int FD = TbadkCoreApplication.getInst().getListItemRule().FD();
        if (size > FD && this.dKC.size() > (i = size - FD)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dKC.remove(0);
            }
        }
        ArrayList<i> arrayList = new ArrayList<>();
        arrayList.addAll(this.dKB);
        arrayList.addAll(this.dKC);
        return arrayList;
    }
}
