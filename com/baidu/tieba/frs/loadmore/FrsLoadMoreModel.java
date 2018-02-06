package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.k.p;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
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
    private int cHk;
    private i dFz;
    private final com.baidu.tieba.frs.loadmore.a dSG;
    private boolean dSH;
    private long dSI;
    private final ArrayList<com.baidu.adp.widget.ListView.i> dSJ;
    private final ArrayList<com.baidu.adp.widget.ListView.i> dSK;
    private final com.baidu.adp.framework.listener.a dSL;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPageType;
    private int mPn;
    private int mSortType;

    /* loaded from: classes2.dex */
    public interface a {
        void J(ArrayList<com.baidu.adp.widget.ListView.i> arrayList);

        void lu(String str);
    }

    public FrsLoadMoreModel(com.baidu.tieba.frs.loadmore.a aVar, i iVar) {
        super(aVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.dSH = false;
        this.dSI = 0L;
        this.dSJ = new ArrayList<>();
        this.dSK = new ArrayList<>();
        this.mPn = 1;
        this.cHk = -1;
        this.mPageType = 1;
        this.dSL = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.dSG != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.dSG.lu(FrsLoadMoreModel.this.dSG.getPageContext().getString(d.j.neterror));
                    } else if (responsedMessage.getError() == 0) {
                        l avl = FrsLoadMoreModel.this.dSG.avl();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (avl != null) {
                                avl.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dSG.J(loadMoreHttpResponseMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (avl != null) {
                                avl.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.dSG.J(loadMoreResponseSocketMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.dSG.getForumName()) && r.bof().bnZ() != null) {
                            r.bof().bnZ().f(FrsLoadMoreModel.this.dSG.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        FrsLoadMoreModel.this.dSG.lu(responsedMessage.getErrorString());
                    } else {
                        FrsLoadMoreModel.this.dSG.lu(FrsLoadMoreModel.this.dSG.getPageContext().getString(d.j.neterror));
                    }
                }
            }
        };
        this.dSG = aVar;
        setUniqueId(this.dSG.getUniqueId());
        this.dFz = iVar;
        this.dSL.getHttpMessageListener().setSelfListener(true);
        this.dSL.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dSL);
    }

    public int auU() {
        return this.cHk;
    }

    public void setHasMore(int i) {
        this.cHk = i;
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
        registerListener(this.dSL);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || v.E(list)) {
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
            loadMoreRequestMessage.setLastClickTid(b.c(t.Pn(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(this.mPageType);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.dSI = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.bof().bnZ() != null) {
            loadMoreRequestMessage.setLoadCount(r.bof().bnZ().W(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.k.l lVar;
        if (!this.dSH) {
            this.dSH = true;
            if (p.Ow().Ox() && (lVar = new com.baidu.tbadk.k.l(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dSI)) != null) {
                lVar.Or();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.k.l lVar;
        if (!this.dSH) {
            this.dSH = true;
            if (p.Ow().Ox() && (lVar = new com.baidu.tbadk.k.l(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.dSI)) != null) {
                lVar.Or();
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
        this.dSJ.clear();
        this.dSK.clear();
        this.cHk = -1;
        this.mPn = 1;
    }

    public boolean bv(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, boolean z3, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, e eVar) {
        if (z3) {
            this.dSJ.clear();
            this.dSK.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<com.baidu.adp.widget.ListView.i> it = this.dSJ.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.i next = it.next();
            if (next instanceof bd) {
                bd bdVar = (bd) next;
                if (bdVar.getTid() != null) {
                    hashSet.add(bdVar.getTid());
                }
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.i> arrayList2 = new ArrayList<>();
        if (!v.E(arrayList)) {
            Iterator<com.baidu.adp.widget.ListView.i> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.baidu.adp.widget.ListView.i next2 = it2.next();
                if (next2 instanceof bd) {
                    bd bdVar2 = (bd) next2;
                    bdVar2.cZ(this.dSG.getForumName());
                    if (bdVar2.zL()) {
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
        if (this.dFz != null) {
            this.dFz.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int FT = TbadkCoreApplication.getInst().getListItemRule().FT() - this.dSJ.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < FT) {
                this.dSJ.add(arrayList2.get(i));
            } else {
                this.dSK.add(arrayList2.get(i));
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.i> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.dSJ);
        arrayList3.addAll(this.dSK);
        if (this.dSG instanceof com.baidu.tieba.InjectPlugin.a.b) {
            com.baidu.tieba.frs.f.a.a((com.baidu.tieba.InjectPlugin.a.b) this.dSG, this.dSG.avl(), arrayList2, getPn());
            com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        }
        return arrayList3;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> azi() {
        int i;
        int size = this.dSK.size() + 30;
        int FS = TbadkCoreApplication.getInst().getListItemRule().FS();
        if (size > FS && this.dSK.size() > (i = size - FS)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.dSK.remove(0);
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
        arrayList.addAll(this.dSJ);
        arrayList.addAll(this.dSK);
        return arrayList;
    }
}
