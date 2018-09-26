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
/* loaded from: classes2.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int cpG;
    private final com.baidu.tieba.frs.loadmore.a dJS;
    private boolean dJT;
    private long dJU;
    private final ArrayList<h> dJV;
    private final ArrayList<h> dJW;
    private c.a dJX;
    private final com.baidu.adp.framework.listener.a dJY;
    private i dtv;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes2.dex */
    public interface a {
        void O(ArrayList<h> arrayList);

        void mF(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.dJT = false;
        this.dJU = 0L;
        this.dJV = new ArrayList<>();
        this.dJW = new ArrayList<>();
        this.mPn = 1;
        this.cpG = -1;
        this.mPageType = 1;
        this.dJY = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.dJS != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.dJS.mF(FrsLoadMoreModel.this.dJS.getPageContext().getString(e.j.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.dJS.mF(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.dJS.mF(FrsLoadMoreModel.this.dJS.getPageContext().getString(e.j.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        l awv = FrsLoadMoreModel.this.dJS.awv();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (awv != null) {
                                awv.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dJS.O(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dJS instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dJS).aXi = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (awv != null) {
                                awv.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dJS.O(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dJS instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dJS).aXi = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.dJS.getForumName()) && r.bpV().bpP() != null) {
                            r.bpV().bpP().f(FrsLoadMoreModel.this.dJS.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.dJS = aVar;
        setUniqueId(this.dJS.getUniqueId());
        this.dtv = iVar;
        this.dJY.getHttpMessageListener().setSelfListener(true);
        this.dJY.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dJY);
    }

    public int awf() {
        return this.cpG;
    }

    public void setHasMore(int i) {
        this.cpG = i;
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
        registerListener(this.dJY);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || v.z(list)) {
            this.loadingDone = true;
            return;
        }
        String bx = bx(list);
        if (!TextUtils.isEmpty(bx)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(bx);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.d(com.baidu.tbadk.util.v.MS(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.dJU = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.bpV().bpP() != null) {
            loadMoreRequestMessage.setLoadCount(r.bpV().bpP().S(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.l.i iVar;
        if (!this.dJT) {
            this.dJT = true;
            if (m.LZ().Ma() && (iVar = new com.baidu.tbadk.l.i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dJU)) != null) {
                iVar.LW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.l.i iVar;
        if (!this.dJT) {
            this.dJT = true;
            if (m.LZ().Ma() && (iVar = new com.baidu.tbadk.l.i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dJU)) != null) {
                iVar.LW();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.LZ().Ma() && (this.dJS instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.dJU;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.dJS).aXi, false, currentTimeMillis);
            if (iVar != null) {
                iVar.aXr = currentTimeMillis;
                iVar.ck(true);
            }
        }
    }

    private String bx(List<Long> list) {
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
        this.dJV.clear();
        this.dJW.clear();
        this.cpG = -1;
        this.mPn = 1;
    }

    public boolean by(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<h> a(boolean z, boolean z2, boolean z3, ArrayList<h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (z3) {
            this.dJV.clear();
            this.dJW.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<h> it = this.dJV.iterator();
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
        if (!v.z(arrayList)) {
            Iterator<h> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (next2 instanceof bb) {
                    bb bbVar2 = (bb) next2;
                    bbVar2.dE(this.dJS.getForumName());
                    if (bbVar2.wK()) {
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
        if (this.dtv != null) {
            this.dtv.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int Dz = TbadkCoreApplication.getInst().getListItemRule().Dz() - this.dJV.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < Dz) {
                this.dJV.add(arrayList2.get(i));
            } else {
                this.dJW.add(arrayList2.get(i));
            }
        }
        ArrayList<h> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.dJV);
        arrayList3.addAll(this.dJW);
        if (this.dJS instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.dJS, this.dJS.awv(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<h> aBB() {
        int i;
        int size = this.dJW.size() + 30;
        int Dy = TbadkCoreApplication.getInst().getListItemRule().Dy();
        if (size > Dy && this.dJW.size() > (i = size - Dy)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dJW.remove(0);
            }
        }
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.addAll(this.dJV);
        arrayList.addAll(this.dJW);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.dJX = aVar;
    }

    public void aBC() {
        int i;
        int size = this.dJW.size() + 30;
        int Dy = TbadkCoreApplication.getInst().getListItemRule().Dy();
        int y = v.y(this.dJV);
        if (size > Dy && this.dJW.size() > (i = size - Dy)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dJW.remove(0);
                if (this.dJX != null) {
                    this.dJX.removeItem(y);
                }
            }
        }
    }

    public void ab(bb bbVar) {
        if (bbVar != null) {
            if (this.dJV != null) {
                this.dJV.remove(bbVar);
            }
            if (this.dJW != null) {
                this.dJW.remove(bbVar);
            }
        }
    }
}
