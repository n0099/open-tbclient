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
    private int cyj;
    private i dBw;
    private final com.baidu.tieba.frs.loadmore.a dRO;
    private boolean dRP;
    private long dRQ;
    private final ArrayList<h> dRR;
    private final ArrayList<h> dRS;
    private c.a dRT;
    private final com.baidu.adp.framework.listener.a dRU;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes6.dex */
    public interface a {
        void O(ArrayList<h> arrayList);

        void nh(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.dRP = false;
        this.dRQ = 0L;
        this.dRR = new ArrayList<>();
        this.dRS = new ArrayList<>();
        this.mPn = 1;
        this.cyj = -1;
        this.mPageType = 1;
        this.dRU = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.dRO != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.dRO.nh(FrsLoadMoreModel.this.dRO.getPageContext().getString(e.j.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.dRO.nh(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.dRO.nh(FrsLoadMoreModel.this.dRO.getPageContext().getString(e.j.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        l azR = FrsLoadMoreModel.this.dRO.azR();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (azR != null) {
                                azR.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dRO.O(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dRO instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dRO).bbI = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (azR != null) {
                                azR.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dRO.O(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dRO instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dRO).bbI = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.dRO.getForumName()) && r.btk().bte() != null) {
                            r.btk().bte().f(FrsLoadMoreModel.this.dRO.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.dRO = aVar;
        setUniqueId(this.dRO.getUniqueId());
        this.dBw = iVar;
        this.dRU.getHttpMessageListener().setSelfListener(true);
        this.dRU.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dRU);
    }

    public int azB() {
        return this.cyj;
    }

    public void setHasMore(int i) {
        this.cyj = i;
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
        registerListener(this.dRU);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.J(list)) {
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
            loadMoreRequestMessage.setLastClickTid(b.d(com.baidu.tbadk.util.v.OQ(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.dRQ = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.btk().bte() != null) {
            loadMoreRequestMessage.setLoadCount(r.btk().bte().Z(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.l.i iVar;
        if (!this.dRP) {
            this.dRP = true;
            if (m.NX().NY() && (iVar = new com.baidu.tbadk.l.i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dRQ)) != null) {
                iVar.NU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.l.i iVar;
        if (!this.dRP) {
            this.dRP = true;
            if (m.NX().NY() && (iVar = new com.baidu.tbadk.l.i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dRQ)) != null) {
                iVar.NU();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.NX().NY() && (this.dRO instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.dRQ;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.dRO).bbI, false, currentTimeMillis);
            if (iVar != null) {
                iVar.bbR = currentTimeMillis;
                iVar.ct(true);
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
        this.dRR.clear();
        this.dRS.clear();
        this.cyj = -1;
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
            this.dRR.clear();
            this.dRS.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<h> it = this.dRR.iterator();
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
        if (!v.J(arrayList)) {
            Iterator<h> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (next2 instanceof bb) {
                    bb bbVar2 = (bb) next2;
                    bbVar2.dU(this.dRO.getForumName());
                    if (bbVar2.yT()) {
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
        if (this.dBw != null) {
            this.dBw.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int FA = TbadkCoreApplication.getInst().getListItemRule().FA() - this.dRR.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < FA) {
                this.dRR.add(arrayList2.get(i));
            } else {
                this.dRS.add(arrayList2.get(i));
            }
        }
        ArrayList<h> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.dRR);
        arrayList3.addAll(this.dRS);
        if (this.dRO instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.dRO, this.dRO.azR(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<h> aEU() {
        int i;
        int size = this.dRS.size() + 30;
        int Fz = TbadkCoreApplication.getInst().getListItemRule().Fz();
        if (size > Fz && this.dRS.size() > (i = size - Fz)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dRS.remove(0);
            }
        }
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.addAll(this.dRR);
        arrayList.addAll(this.dRS);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.dRT = aVar;
    }

    public void aEV() {
        int i;
        int size = this.dRS.size() + 30;
        int Fz = TbadkCoreApplication.getInst().getListItemRule().Fz();
        int I = v.I(this.dRR);
        if (size > Fz && this.dRS.size() > (i = size - Fz)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dRS.remove(0);
                if (this.dRT != null) {
                    this.dRT.removeItem(I);
                }
            }
        }
    }

    public void ab(bb bbVar) {
        if (bbVar != null) {
            if (this.dRR != null) {
                this.dRR.remove(bbVar);
            }
            if (this.dRS != null) {
                this.dRS.remove(bbVar);
            }
        }
    }
}
