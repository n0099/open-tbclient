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
    private int czs;
    private i dCN;
    private final com.baidu.tieba.frs.loadmore.a dSV;
    private boolean dSW;
    private long dSX;
    private final ArrayList<h> dSY;
    private final ArrayList<h> dSZ;
    private c.a dTa;
    private final com.baidu.adp.framework.listener.a dTb;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes6.dex */
    public interface a {
        void O(ArrayList<h> arrayList);

        void ni(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.dSW = false;
        this.dSX = 0L;
        this.dSY = new ArrayList<>();
        this.dSZ = new ArrayList<>();
        this.mPn = 1;
        this.czs = -1;
        this.mPageType = 1;
        this.dTb = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.dSV != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.dSV.ni(FrsLoadMoreModel.this.dSV.getPageContext().getString(e.j.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.dSV.ni(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.dSV.ni(FrsLoadMoreModel.this.dSV.getPageContext().getString(e.j.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        l azp = FrsLoadMoreModel.this.dSV.azp();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (azp != null) {
                                azp.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dSV.O(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dSV instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dSV).bcv = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (azp != null) {
                                azp.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dSV.O(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dSV instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dSV).bcv = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.dSV.getForumName()) && r.bsG().bsA() != null) {
                            r.bsG().bsA().f(FrsLoadMoreModel.this.dSV.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.dSV = aVar;
        setUniqueId(this.dSV.getUniqueId());
        this.dCN = iVar;
        this.dTb.getHttpMessageListener().setSelfListener(true);
        this.dTb.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dTb);
    }

    public int ayZ() {
        return this.czs;
    }

    public void setHasMore(int i) {
        this.czs = i;
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
        registerListener(this.dTb);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.I(list)) {
            this.loadingDone = true;
            return;
        }
        String bL = bL(list);
        if (!TextUtils.isEmpty(bL)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(bL);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.d(com.baidu.tbadk.util.v.OZ(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.dSX = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.bsG().bsA() != null) {
            loadMoreRequestMessage.setLoadCount(r.bsG().bsA().Z(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.l.i iVar;
        if (!this.dSW) {
            this.dSW = true;
            if (m.Og().Oh() && (iVar = new com.baidu.tbadk.l.i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dSX)) != null) {
                iVar.Od();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.l.i iVar;
        if (!this.dSW) {
            this.dSW = true;
            if (m.Og().Oh() && (iVar = new com.baidu.tbadk.l.i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dSX)) != null) {
                iVar.Od();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.Og().Oh() && (this.dSV instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.dSX;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.dSV).bcv, false, currentTimeMillis);
            if (iVar != null) {
                iVar.bcE = currentTimeMillis;
                iVar.cK(true);
            }
        }
    }

    private String bL(List<Long> list) {
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
        this.dSY.clear();
        this.dSZ.clear();
        this.czs = -1;
        this.mPn = 1;
    }

    public boolean bM(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<h> a(boolean z, boolean z2, boolean z3, ArrayList<h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (z3) {
            this.dSY.clear();
            this.dSZ.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<h> it = this.dSY.iterator();
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
                    bbVar2.dU(this.dSV.getForumName());
                    if (bbVar2.za()) {
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
        if (this.dCN != null) {
            this.dCN.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int FM = TbadkCoreApplication.getInst().getListItemRule().FM() - this.dSY.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < FM) {
                this.dSY.add(arrayList2.get(i));
            } else {
                this.dSZ.add(arrayList2.get(i));
            }
        }
        ArrayList<h> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.dSY);
        arrayList3.addAll(this.dSZ);
        if (this.dSV instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.dSV, this.dSV.azp(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<h> aEq() {
        int i;
        int size = this.dSZ.size() + 30;
        int FL = TbadkCoreApplication.getInst().getListItemRule().FL();
        if (size > FL && this.dSZ.size() > (i = size - FL)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dSZ.remove(0);
            }
        }
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.addAll(this.dSY);
        arrayList.addAll(this.dSZ);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.dTa = aVar;
    }

    public void aEr() {
        int i;
        int size = this.dSZ.size() + 30;
        int FL = TbadkCoreApplication.getInst().getListItemRule().FL();
        int H = v.H(this.dSY);
        if (size > FL && this.dSZ.size() > (i = size - FL)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dSZ.remove(0);
                if (this.dTa != null) {
                    this.dTa.removeItem(H);
                }
            }
        }
    }

    public void ab(bb bbVar) {
        if (bbVar != null) {
            if (this.dSY != null) {
                this.dSY.remove(bbVar);
            }
            if (this.dSZ != null) {
                this.dSZ.remove(bbVar);
            }
        }
    }
}
