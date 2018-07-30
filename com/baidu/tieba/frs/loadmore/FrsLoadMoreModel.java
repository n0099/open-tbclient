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
    private int cjR;
    private final com.baidu.tieba.frs.loadmore.a dDf;
    private boolean dDg;
    private long dDh;
    private final ArrayList<h> dDi;
    private final ArrayList<h> dDj;
    private c.a dDk;
    private final com.baidu.adp.framework.listener.a dDl;
    private i dnz;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes2.dex */
    public interface a {
        void O(ArrayList<h> arrayList);

        void mb(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.dDg = false;
        this.dDh = 0L;
        this.dDi = new ArrayList<>();
        this.dDj = new ArrayList<>();
        this.mPn = 1;
        this.cjR = -1;
        this.mPageType = 1;
        this.dDl = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.dDf != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.dDf.mb(FrsLoadMoreModel.this.dDf.getPageContext().getString(d.j.neterror));
                    } else if (responsedMessage.getError() != 0) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            FrsLoadMoreModel.this.dDf.mb(responsedMessage.getErrorString());
                        } else {
                            FrsLoadMoreModel.this.dDf.mb(FrsLoadMoreModel.this.dDf.getPageContext().getString(d.j.neterror));
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        l auD = FrsLoadMoreModel.this.dDf.auD();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (auD != null) {
                                auD.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dDf.O(loadMoreHttpResponseMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dDf instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dDf).aTT = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(true, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (auD != null) {
                                auD.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dDf.O(loadMoreResponseSocketMessage.getThreadList());
                            if (FrsLoadMoreModel.this.dDf instanceof FrsFragment) {
                                ((FrsFragment) FrsLoadMoreModel.this.dDf).aTT = System.currentTimeMillis() - currentTimeMillis;
                                FrsLoadMoreModel.this.a(false, responsedMessage);
                            }
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.dDf.getForumName()) && r.bnn().bnh() != null) {
                            r.bnn().bnh().f(FrsLoadMoreModel.this.dDf.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    }
                }
            }
        };
        this.dDf = aVar;
        setUniqueId(this.dDf.getUniqueId());
        this.dnz = iVar;
        this.dDl.getHttpMessageListener().setSelfListener(true);
        this.dDl.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dDl);
    }

    public int aun() {
        return this.cjR;
    }

    public void setHasMore(int i) {
        this.cjR = i;
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
        registerListener(this.dDl);
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
            loadMoreRequestMessage.setLastClickTid(b.c(t.Lw(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            loadMoreRequestMessage.setBrandForum(z);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.dDh = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.bnn().bnh() != null) {
            loadMoreRequestMessage.setLoadCount(r.bnn().bnh().R(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.l.i iVar;
        if (!this.dDg) {
            this.dDg = true;
            if (m.KF().KG() && (iVar = new com.baidu.tbadk.l.i(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dDh)) != null) {
                iVar.KC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.l.i iVar;
        if (!this.dDg) {
            this.dDg = true;
            if (m.KF().KG() && (iVar = new com.baidu.tbadk.l.i(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dDh)) != null) {
                iVar.KC();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.KF().KG() && (this.dDf instanceof FrsFragment)) {
            long currentTimeMillis = System.currentTimeMillis() - this.dDh;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, 0L, 0L, ((FrsFragment) this.dDf).aTT, false, currentTimeMillis);
            if (iVar != null) {
                iVar.aUc = currentTimeMillis;
                iVar.bX(true);
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
        this.dDi.clear();
        this.dDj.clear();
        this.cjR = -1;
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
            this.dDi.clear();
            this.dDj.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<h> it = this.dDi.iterator();
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
                    bbVar2.dm(this.dDf.getForumName());
                    if (bbVar2.vH()) {
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
        if (this.dnz != null) {
            this.dnz.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int Cp = TbadkCoreApplication.getInst().getListItemRule().Cp() - this.dDi.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < Cp) {
                this.dDi.add(arrayList2.get(i));
            } else {
                this.dDj.add(arrayList2.get(i));
            }
        }
        ArrayList<h> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.dDi);
        arrayList3.addAll(this.dDj);
        if (this.dDf instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.dDf, this.dDf.auD(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<h> azv() {
        int i;
        int size = this.dDj.size() + 30;
        int Co = TbadkCoreApplication.getInst().getListItemRule().Co();
        if (size > Co && this.dDj.size() > (i = size - Co)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dDj.remove(0);
            }
        }
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.addAll(this.dDi);
        arrayList.addAll(this.dDj);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.dDk = aVar;
    }

    public void azw() {
        int i;
        int size = this.dDj.size() + 30;
        int Co = TbadkCoreApplication.getInst().getListItemRule().Co();
        int y = w.y(this.dDi);
        if (size > Co && this.dDj.size() > (i = size - Co)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dDj.remove(0);
                if (this.dDk != null) {
                    this.dDk.removeItem(y);
                }
            }
        }
    }

    public void aa(bb bbVar) {
        if (bbVar != null) {
            if (this.dDi != null) {
                this.dDi.remove(bbVar);
            }
            if (this.dDj != null) {
                this.dDj.remove(bbVar);
            }
        }
    }
}
