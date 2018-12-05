package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.l.m;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int cDk;
    private i dJm;
    private long dZA;
    private final ArrayList<h> dZB;
    private final ArrayList<h> dZC;
    private c.a dZD;
    private final com.baidu.adp.framework.listener.a dZE;
    private final com.baidu.tieba.frs.loadmore.a dZy;
    private boolean dZz;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes6.dex */
    public interface a {
        void O(ArrayList<h> arrayList);

        void nH(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.dZz = false;
        this.dZA = 0L;
        this.dZB = new ArrayList<>();
        this.dZC = new ArrayList<>();
        this.mPn = 1;
        this.cDk = -1;
        this.mPageType = 1;
        this.dZE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.dZy != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.dZy.nH(FrsLoadMoreModel.this.dZy.getPageContext().getString(e.j.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.dZy.nH(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.dZy.nH(FrsLoadMoreModel.this.dZy.getPageContext().getString(e.j.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        l aAZ = FrsLoadMoreModel.this.dZy.aAZ();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (aAZ != null) {
                                aAZ.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dZy.O(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dZy instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dZy).bfV = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (aAZ != null) {
                                aAZ.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dZy.O(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dZy instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dZy).bfV = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.dZy.getForumName()) && r.buz().but() != null) {
                            r.buz().but().f(FrsLoadMoreModel.this.dZy.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.dZy = aVar;
        setUniqueId(this.dZy.getUniqueId());
        this.dJm = iVar;
        this.dZE.getHttpMessageListener().setSelfListener(true);
        this.dZE.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dZE);
    }

    public int aAJ() {
        return this.cDk;
    }

    public void setHasMore(int i) {
        this.cDk = i;
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
        registerListener(this.dZE);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.I(list)) {
            this.loadingDone = true;
            return;
        }
        String bN = bN(list);
        if (!TextUtils.isEmpty(bN)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(bN);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.d(com.baidu.tbadk.util.v.Qf(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.dZA = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.buz().but() != null) {
            loadMoreRequestMessage.setLoadCount(r.buz().but().ab(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.l.i iVar;
        if (!this.dZz) {
            this.dZz = true;
            if (m.Pk().Pl() && (iVar = new com.baidu.tbadk.l.i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dZA)) != null) {
                iVar.Ph();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.l.i iVar;
        if (!this.dZz) {
            this.dZz = true;
            if (m.Pk().Pl() && (iVar = new com.baidu.tbadk.l.i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dZA)) != null) {
                iVar.Ph();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.Pk().Pl() && (this.dZy instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.dZA;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.dZy).bfV, false, currentTimeMillis);
            if (iVar != null) {
                iVar.bge = currentTimeMillis;
                iVar.cL(true);
            }
        }
    }

    private String bN(List<Long> list) {
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
        this.dZB.clear();
        this.dZC.clear();
        this.cDk = -1;
        this.mPn = 1;
    }

    public boolean bO(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<h> a(boolean z, boolean z2, boolean z3, ArrayList<h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (z3) {
            this.dZB.clear();
            this.dZC.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<h> it = this.dZB.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next instanceof bb) {
                bb bbVar = (bb) next;
                if (bbVar.getTid() != null) {
                    hashSet.add(bbVar.getTid());
                }
            }
        }
        ArrayList<h> arrayList2 = new ArrayList<>();
        if (!v.I(arrayList)) {
            Iterator<h> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (next2 instanceof bb) {
                    bb bbVar2 = (bb) next2;
                    bbVar2.em(this.dZy.getForumName());
                    if (bbVar2.Ae()) {
                        if (!hashSet.contains(bbVar2.getTid())) {
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
        if (this.dJm != null) {
            this.dJm.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int GQ = TbadkCoreApplication.getInst().getListItemRule().GQ() - this.dZB.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < GQ) {
                this.dZB.add(arrayList2.get(i));
            } else {
                this.dZC.add(arrayList2.get(i));
            }
        }
        ArrayList<h> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.dZB);
        arrayList3.addAll(this.dZC);
        if (this.dZy instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.dZy, this.dZy.aAZ(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<h> aGc() {
        int i;
        int size = this.dZC.size() + 30;
        int GP = TbadkCoreApplication.getInst().getListItemRule().GP();
        if (size > GP && this.dZC.size() > (i = size - GP)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dZC.remove(0);
            }
        }
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.addAll(this.dZB);
        arrayList.addAll(this.dZC);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.dZD = aVar;
    }

    public void aGd() {
        int i;
        int size = this.dZC.size() + 30;
        int GP = TbadkCoreApplication.getInst().getListItemRule().GP();
        int H = v.H(this.dZB);
        if (size > GP && this.dZC.size() > (i = size - GP)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dZC.remove(0);
                if (this.dZD != null) {
                    this.dZD.removeItem(H);
                }
            }
        }
    }

    public void ab(bb bbVar) {
        if (bbVar != null) {
            if (this.dZB != null) {
                this.dZB.remove(bbVar);
            }
            if (this.dZC != null) {
                this.dZC.remove(bbVar);
            }
        }
    }
}
