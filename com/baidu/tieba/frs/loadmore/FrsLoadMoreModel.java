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
import com.baidu.tbadk.util.w;
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
    private int cEV;
    private i dMJ;
    private final com.baidu.tieba.frs.loadmore.a ecV;
    private boolean ecW;
    private long ecX;
    private final ArrayList<h> ecY;
    private final ArrayList<h> ecZ;
    private c.a eda;
    private final com.baidu.adp.framework.listener.a edb;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes6.dex */
    public interface a {
        void O(ArrayList<h> arrayList);

        void oa(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.ecW = false;
        this.ecX = 0L;
        this.ecY = new ArrayList<>();
        this.ecZ = new ArrayList<>();
        this.mPn = 1;
        this.cEV = -1;
        this.mPageType = 1;
        this.edb = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.ecV != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.ecV.oa(FrsLoadMoreModel.this.ecV.getPageContext().getString(e.j.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.ecV.oa(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.ecV.oa(FrsLoadMoreModel.this.ecV.getPageContext().getString(e.j.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        l aCl = FrsLoadMoreModel.this.ecV.aCl();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (aCl != null) {
                                aCl.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.ecV.O(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.ecV instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.ecV).bgJ = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (aCl != null) {
                                aCl.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.ecV.O(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.ecV instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.ecV).bgJ = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.ecV.getForumName()) && r.bvT().bvN() != null) {
                            r.bvT().bvN().f(FrsLoadMoreModel.this.ecV.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.ecV = aVar;
        setUniqueId(this.ecV.getUniqueId());
        this.dMJ = iVar;
        this.edb.getHttpMessageListener().setSelfListener(true);
        this.edb.getSocketMessageListener().setSelfListener(true);
        registerListener(this.edb);
    }

    public int aBV() {
        return this.cEV;
    }

    public void setHasMore(int i) {
        this.cEV = i;
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
        registerListener(this.edb);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.I(list)) {
            this.loadingDone = true;
            return;
        }
        String bP = bP(list);
        if (!TextUtils.isEmpty(bP)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(bP);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.d(w.QC(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.ecX = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.bvT().bvN() != null) {
            loadMoreRequestMessage.setLoadCount(r.bvT().bvN().aa(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.l.i iVar;
        if (!this.ecW) {
            this.ecW = true;
            if (m.PD().PE() && (iVar = new com.baidu.tbadk.l.i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.ecX)) != null) {
                iVar.PA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.l.i iVar;
        if (!this.ecW) {
            this.ecW = true;
            if (m.PD().PE() && (iVar = new com.baidu.tbadk.l.i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.ecX)) != null) {
                iVar.PA();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.PD().PE() && (this.ecV instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.ecX;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.ecV).bgJ, false, currentTimeMillis);
            if (iVar != null) {
                iVar.bgS = currentTimeMillis;
                iVar.cO(true);
            }
        }
    }

    private String bP(List<Long> list) {
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
        this.ecY.clear();
        this.ecZ.clear();
        this.cEV = -1;
        this.mPn = 1;
    }

    public boolean bQ(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<h> a(boolean z, boolean z2, boolean z3, ArrayList<h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (z3) {
            this.ecY.clear();
            this.ecZ.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<h> it = this.ecY.iterator();
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
                    bbVar2.ev(this.ecV.getForumName());
                    if (bbVar2.Ar()) {
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
        if (this.dMJ != null) {
            this.dMJ.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int He = TbadkCoreApplication.getInst().getListItemRule().He() - this.ecY.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < He) {
                this.ecY.add(arrayList2.get(i));
            } else {
                this.ecZ.add(arrayList2.get(i));
            }
        }
        ArrayList<h> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.ecY);
        arrayList3.addAll(this.ecZ);
        if (this.ecV instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.ecV, this.ecV.aCl(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<h> aHo() {
        int i;
        int size = this.ecZ.size() + 30;
        int Hd = TbadkCoreApplication.getInst().getListItemRule().Hd();
        if (size > Hd && this.ecZ.size() > (i = size - Hd)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.ecZ.remove(0);
            }
        }
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.addAll(this.ecY);
        arrayList.addAll(this.ecZ);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.eda = aVar;
    }

    public void aHp() {
        int i;
        int size = this.ecZ.size() + 30;
        int Hd = TbadkCoreApplication.getInst().getListItemRule().Hd();
        int H = v.H(this.ecY);
        if (size > Hd && this.ecZ.size() > (i = size - Hd)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.ecZ.remove(0);
                if (this.eda != null) {
                    this.eda.removeItem(H);
                }
            }
        }
    }

    public void ab(bb bbVar) {
        if (bbVar != null) {
            if (this.ecY != null) {
                this.ecY.remove(bbVar);
            }
            if (this.ecZ != null) {
                this.ecZ.remove(bbVar);
            }
        }
    }
}
