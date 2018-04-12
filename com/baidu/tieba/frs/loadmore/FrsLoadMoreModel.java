package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.k.p;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.recapp.r;
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
    private int bXj;
    private i cYm;
    private final com.baidu.tieba.frs.loadmore.a dmJ;
    private boolean dmK;
    private long dmL;
    private final ArrayList<h> dmM;
    private final ArrayList<h> dmN;
    private c.a dmO;
    private final com.baidu.adp.framework.listener.a dmP;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes2.dex */
    public interface a {
        void J(ArrayList<h> arrayList);

        void lx(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.dmK = false;
        this.dmL = 0L;
        this.dmM = new ArrayList<>();
        this.dmN = new ArrayList<>();
        this.mPn = 1;
        this.bXj = -1;
        this.mPageType = 1;
        this.dmP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.dmJ != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.dmJ.lx(FrsLoadMoreModel.this.dmJ.getPageContext().getString(d.k.neterror));
                    } else if (responsedMessage.getError() == 0) {
                        l apE = FrsLoadMoreModel.this.dmJ.apE();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (apE != null) {
                                apE.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dmJ.J(loadMoreHttpResponseMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (apE != null) {
                                apE.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dmJ.J(loadMoreResponseSocketMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.dmJ.getForumName()) && r.bjl().bjf() != null) {
                            r.bjl().bjf().f(FrsLoadMoreModel.this.dmJ.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        FrsLoadMoreModel.this.dmJ.lx(responsedMessage.getErrorString());
                    } else {
                        FrsLoadMoreModel.this.dmJ.lx(FrsLoadMoreModel.this.dmJ.getPageContext().getString(d.k.neterror));
                    }
                }
            }
        };
        this.dmJ = aVar;
        setUniqueId(this.dmJ.getUniqueId());
        this.cYm = iVar;
        this.dmP.getHttpMessageListener().setSelfListener(true);
        this.dmP.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dmP);
    }

    public int apo() {
        return this.bXj;
    }

    public void setHasMore(int i) {
        this.bXj = i;
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
        registerListener(this.dmP);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || v.w(list)) {
            this.loadingDone = true;
            return;
        }
        String bn = bn(list);
        if (!TextUtils.isEmpty(bn)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(bn);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(t.HP(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.dmL = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.bjl().bjf() != null) {
            loadMoreRequestMessage.setLoadCount(r.bjl().bjf().R(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.k.l lVar;
        if (!this.dmK) {
            this.dmK = true;
            if (p.Ha().Hb() && (lVar = new com.baidu.tbadk.k.l(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dmL)) != null) {
                lVar.GT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.k.l lVar;
        if (!this.dmK) {
            this.dmK = true;
            if (p.Ha().Hb() && (lVar = new com.baidu.tbadk.k.l(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dmL)) != null) {
                lVar.GT();
            }
        }
    }

    private String bn(List<Long> list) {
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
        this.dmM.clear();
        this.dmN.clear();
        this.bXj = -1;
        this.mPn = 1;
    }

    public boolean bo(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<h> a(boolean z, boolean z2, boolean z3, ArrayList<h> arrayList, e eVar) {
        if (z3) {
            this.dmM.clear();
            this.dmN.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<h> it = this.dmM.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next instanceof bd) {
                bd bdVar = (bd) next;
                if (bdVar.getTid() != null) {
                    hashSet.add(bdVar.getTid());
                }
            }
        }
        ArrayList<h> arrayList2 = new ArrayList<>();
        if (!v.w(arrayList)) {
            Iterator<h> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (next2 instanceof bd) {
                    bd bdVar2 = (bd) next2;
                    bdVar2.cN(this.dmJ.getForumName());
                    if (bdVar2.sm()) {
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
        if (this.cYm != null) {
            this.cYm.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int yG = TbadkCoreApplication.getInst().getListItemRule().yG() - this.dmM.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < yG) {
                this.dmM.add(arrayList2.get(i));
            } else {
                this.dmN.add(arrayList2.get(i));
            }
        }
        ArrayList<h> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.dmM);
        arrayList3.addAll(this.dmN);
        if (this.dmJ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.dmJ, this.dmJ.apE(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<h> atX() {
        int i;
        int size = this.dmN.size() + 30;
        int yF = TbadkCoreApplication.getInst().getListItemRule().yF();
        if (size > yF && this.dmN.size() > (i = size - yF)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dmN.remove(0);
            }
        }
        ArrayList<h> arrayList = new ArrayList<>();
        arrayList.addAll(this.dmM);
        arrayList.addAll(this.dmN);
        return arrayList;
    }

    public void a(c.a aVar) {
        this.dmO = aVar;
    }

    public void atY() {
        int i;
        int size = this.dmN.size() + 30;
        int yF = TbadkCoreApplication.getInst().getListItemRule().yF();
        int v = v.v(this.dmM);
        if (size > yF && this.dmN.size() > (i = size - yF)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dmN.remove(0);
                if (this.dmO != null) {
                    this.dmO.removeItem(v);
                }
            }
        }
    }
}
