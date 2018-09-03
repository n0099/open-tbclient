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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.l.m;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.f;
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
    private int cjO;
    private final com.baidu.tieba.frs.loadmore.a dDc;
    private boolean dDd;
    private long dDe;
    private final ArrayList<h> dDf;
    private final ArrayList<h> dDg;
    private c.a dDh;
    private final com.baidu.adp.framework.listener.a dDi;
    private i dnx;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes2.dex */
    public interface a {
        void O(ArrayList<h> arrayList);

        void md(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.dDd = false;
        this.dDe = 0L;
        this.dDf = new ArrayList<>();
        this.dDg = new ArrayList<>();
        this.mPn = 1;
        this.cjO = -1;
        this.mPageType = 1;
        this.dDi = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.dDc != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.dDc.md(FrsLoadMoreModel.this.dDc.getPageContext().getString(f.j.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.dDc.md(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.dDc.md(FrsLoadMoreModel.this.dDc.getPageContext().getString(f.j.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        l auC = FrsLoadMoreModel.this.dDc.auC();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (auC != null) {
                                auC.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dDc.O(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dDc instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dDc).aTT = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (auC != null) {
                                auC.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dDc.O(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dDc instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dDc).aTT = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.dDc.getForumName()) && r.bno().bni() != null) {
                            r.bno().bni().f(FrsLoadMoreModel.this.dDc.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.dDc = aVar;
        setUniqueId(this.dDc.getUniqueId());
        this.dnx = iVar;
        this.dDi.getHttpMessageListener().setSelfListener(true);
        this.dDi.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dDi);
    }

    public int aum() {
        return this.cjO;
    }

    public void setHasMore(int i) {
        this.cjO = i;
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
        registerListener(this.dDi);
    }

    public void a(long j, List<Long> list, String str, int i, boolean z) {
        if (j == 0 || w.z(list)) {
            this.loadingDone = true;
            return;
        }
        String bw = bw(list);
        if (!TextUtils.isEmpty(bw)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(bw);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(t.LA(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.dDe = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.bno().bni() != null) {
            loadMoreRequestMessage.setLoadCount(r.bno().bni().R(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.l.i iVar;
        if (!this.dDd) {
            this.dDd = true;
            if (m.KJ().KK() && (iVar = new com.baidu.tbadk.l.i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dDe)) != null) {
                iVar.KG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.l.i iVar;
        if (!this.dDd) {
            this.dDd = true;
            if (m.KJ().KK() && (iVar = new com.baidu.tbadk.l.i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dDe)) != null) {
                iVar.KG();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.KJ().KK() && (this.dDc instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.dDe;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.dDc).aTT, false, currentTimeMillis);
            if (iVar != null) {
                iVar.aUc = currentTimeMillis;
                iVar.bY(true);
            }
        }
    }

    private String bw(List<Long> list) {
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
        this.dDf.clear();
        this.dDg.clear();
        this.cjO = -1;
        this.mPn = 1;
    }

    public boolean bx(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<h> a(boolean z, boolean z2, boolean z3, ArrayList<h> arrayList, e eVar) {
        if (z3) {
            this.dDf.clear();
            this.dDg.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<h> it = this.dDf.iterator();
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
        if (!w.z(arrayList)) {
            Iterator<h> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (next2 instanceof bb) {
                    bb bbVar2 = (bb) next2;
                    bbVar2.dm(this.dDc.getForumName());
                    if (bbVar2.vG()) {
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
        if (this.dnx != null) {
            this.dnx.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int Cm = TbadkCoreApplication.getInst().getListItemRule().Cm() - this.dDf.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < Cm) {
                this.dDf.add(arrayList2.get(i));
            } else {
                this.dDg.add(arrayList2.get(i));
            }
        }
        ArrayList<h> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.dDf);
        arrayList3.addAll(this.dDg);
        if (this.dDc instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.dDc, this.dDc.auC(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<h> azt() {
        int i;
        int size = this.dDg.size() + 30;
        int Cl = TbadkCoreApplication.getInst().getListItemRule().Cl();
        if (size > Cl && this.dDg.size() > (i = size - Cl)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dDg.remove(0);
            }
        }
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.addAll(this.dDf);
        arrayList.addAll(this.dDg);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.dDh = aVar;
    }

    public void azu() {
        int i;
        int size = this.dDg.size() + 30;
        int Cl = TbadkCoreApplication.getInst().getListItemRule().Cl();
        int y = w.y(this.dDf);
        if (size > Cl && this.dDg.size() > (i = size - Cl)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dDg.remove(0);
                if (this.dDh != null) {
                    this.dDh.removeItem(y);
                }
            }
        }
    }

    public void aa(bb bbVar) {
        if (bbVar != null) {
            if (this.dDf != null) {
                this.dDf.remove(bbVar);
            }
            if (this.dDg != null) {
                this.dDg.remove(bbVar);
            }
        }
    }
}
