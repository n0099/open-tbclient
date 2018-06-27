package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bc;
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
    private int cik;
    private final com.baidu.tieba.frs.loadmore.a dAt;
    private boolean dAu;
    private long dAv;
    private final ArrayList<h> dAw;
    private final ArrayList<h> dAx;
    private c.a dAy;
    private final com.baidu.adp.framework.listener.a dAz;
    private i dkJ;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes2.dex */
    public interface a {
        void O(ArrayList<h> arrayList);

        void mc(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.dAu = false;
        this.dAv = 0L;
        this.dAw = new ArrayList<>();
        this.dAx = new ArrayList<>();
        this.mPn = 1;
        this.cik = -1;
        this.mPageType = 1;
        this.dAz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.dAt != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.dAt.mc(FrsLoadMoreModel.this.dAt.getPageContext().getString(d.k.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.dAt.mc(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.dAt.mc(FrsLoadMoreModel.this.dAt.getPageContext().getString(d.k.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        l atZ = FrsLoadMoreModel.this.dAt.atZ();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (atZ != null) {
                                atZ.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dAt.O(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dAt instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dAt).aTS = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (atZ != null) {
                                atZ.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dAt.O(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dAt instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dAt).aTS = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.dAt.getForumName()) && r.boJ().boD() != null) {
                            r.boJ().boD().f(FrsLoadMoreModel.this.dAt.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.dAt = aVar;
        setUniqueId(this.dAt.getUniqueId());
        this.dkJ = iVar;
        this.dAz.getHttpMessageListener().setSelfListener(true);
        this.dAz.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dAz);
    }

    public int atJ() {
        return this.cik;
    }

    public void setHasMore(int i) {
        this.cik = i;
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
        registerListener(this.dAz);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || w.A(list)) {
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
            loadMoreRequestMessage.setLastClickTid(b.c(u.LB(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.dAv = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.boJ().boD() != null) {
            loadMoreRequestMessage.setLoadCount(r.boJ().boD().S(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.k.i iVar;
        if (!this.dAu) {
            this.dAu = true;
            if (m.KK().KL() && (iVar = new com.baidu.tbadk.k.i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dAv)) != null) {
                iVar.KH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.k.i iVar;
        if (!this.dAu) {
            this.dAu = true;
            if (m.KK().KL() && (iVar = new com.baidu.tbadk.k.i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dAv)) != null) {
                iVar.KH();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.KK().KL() && (this.dAt instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.dAv;
            com.baidu.tbadk.k.i iVar = new com.baidu.tbadk.k.i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.dAt).aTS, false, currentTimeMillis);
            if (iVar != null) {
                iVar.aUb = currentTimeMillis;
                iVar.bZ(true);
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
        this.dAw.clear();
        this.dAx.clear();
        this.cik = -1;
        this.mPn = 1;
    }

    public boolean by(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<h> a(boolean z, boolean z2, boolean z3, ArrayList<h> arrayList, e eVar) {
        if (z3) {
            this.dAw.clear();
            this.dAx.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<h> it = this.dAw.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next instanceof bc) {
                bc bcVar = (bc) next;
                if (bcVar.getTid() != null) {
                    hashSet.add(bcVar.getTid());
                }
            }
        }
        ArrayList<h> arrayList2 = new ArrayList<>();
        if (!w.A(arrayList)) {
            Iterator<h> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (next2 instanceof bc) {
                    bc bcVar2 = (bc) next2;
                    bcVar2.dp(this.dAt.getForumName());
                    if (bcVar2.vS()) {
                        if (!hashSet.contains(bcVar2.getTid())) {
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
        if (this.dkJ != null) {
            this.dkJ.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int Cx = TbadkCoreApplication.getInst().getListItemRule().Cx() - this.dAw.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < Cx) {
                this.dAw.add(arrayList2.get(i));
            } else {
                this.dAx.add(arrayList2.get(i));
            }
        }
        ArrayList<h> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.dAw);
        arrayList3.addAll(this.dAx);
        if (this.dAt instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.dAt, this.dAt.atZ(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<h> ayP() {
        int i;
        int size = this.dAx.size() + 30;
        int Cw = TbadkCoreApplication.getInst().getListItemRule().Cw();
        if (size > Cw && this.dAx.size() > (i = size - Cw)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dAx.remove(0);
            }
        }
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.addAll(this.dAw);
        arrayList.addAll(this.dAx);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.dAy = aVar;
    }

    public void ayQ() {
        int i;
        int size = this.dAx.size() + 30;
        int Cw = TbadkCoreApplication.getInst().getListItemRule().Cw();
        int z = w.z(this.dAw);
        if (size > Cw && this.dAx.size() > (i = size - Cw)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dAx.remove(0);
                if (this.dAy != null) {
                    this.dAy.removeItem(z);
                }
            }
        }
    }

    public void Y(bc bcVar) {
        if (bcVar != null) {
            if (this.dAw != null) {
                this.dAw.remove(bcVar);
            }
            if (this.dAx != null) {
                this.dAx.remove(bcVar);
            }
        }
    }
}
