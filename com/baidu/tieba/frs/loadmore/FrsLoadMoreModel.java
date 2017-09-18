package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.l.m;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.mc.j;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.tbadkCore.i;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private int byh;
    private final f cDJ;
    private boolean cDK;
    private long cDL;
    private j cqQ;
    private final ArrayList<com.baidu.adp.widget.ListView.f> czB;
    private final ArrayList<com.baidu.adp.widget.ListView.f> czC;
    private final a czD;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPn;
    private int mSortType;

    public FrsLoadMoreModel(f fVar, j jVar) {
        super(fVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.cDK = false;
        this.cDL = 0L;
        this.czB = new ArrayList<>();
        this.czC = new ArrayList<>();
        this.mPn = 1;
        this.byh = -1;
        this.czD = new a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.cDJ != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.cDJ.kC(FrsLoadMoreModel.this.cDJ.getPageContext().getString(d.l.neterror));
                    } else if (responsedMessage.getError() == 0) {
                        i ahq = FrsLoadMoreModel.this.cDJ.ahq();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (ahq != null) {
                                ahq.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.cDJ.G(loadMoreHttpResponseMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (ahq != null) {
                                ahq.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.cDJ.G(loadMoreResponseSocketMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.cDJ.getForumName()) && r.bho().bhi() != null) {
                            r.bho().bhi().g(FrsLoadMoreModel.this.cDJ.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        FrsLoadMoreModel.this.cDJ.kC(responsedMessage.getErrorString());
                    } else {
                        FrsLoadMoreModel.this.cDJ.kC(FrsLoadMoreModel.this.cDJ.getPageContext().getString(d.l.neterror));
                    }
                }
            }
        };
        this.cDJ = fVar;
        setUniqueId(this.cDJ.getUniqueId());
        this.cqQ = jVar;
        this.czD.getHttpMessageListener().setSelfListener(true);
        this.czD.getSocketMessageListener().setSelfListener(true);
        this.cDJ.registerListener(this.czD);
    }

    public int agZ() {
        return this.byh;
    }

    public void setHasMore(int i) {
        this.byh = i;
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

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || v.v(list)) {
            this.loadingDone = true;
            return;
        }
        String aN = aN(list);
        if (!TextUtils.isEmpty(aN)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(aN);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(s.Hq(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.cDL = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.bho().bhi() != null) {
            loadMoreRequestMessage.setLoadCount(r.bho().bhi().Y(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        m mVar;
        if (!this.cDK) {
            this.cDK = true;
            if (com.baidu.tbadk.l.r.Gx().Gy() && (mVar = new m(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cDL)) != null) {
                mVar.Gs();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        m mVar;
        if (!this.cDK) {
            this.cDK = true;
            if (com.baidu.tbadk.l.r.Gx().Gy() && (mVar = new m(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cDL)) != null) {
                mVar.Gs();
            }
        }
    }

    private String aN(List<Long> list) {
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
        this.czB.clear();
        this.czC.clear();
        this.byh = -1;
        this.mPn = 1;
    }

    public boolean aO(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, boolean z3, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, e eVar) {
        if (z3) {
            this.czB.clear();
            this.czC.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<com.baidu.adp.widget.ListView.f> it = this.czB.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if (next instanceof bj) {
                bj bjVar = (bj) next;
                if (bjVar.getTid() != null) {
                    hashSet.add(bjVar.getTid());
                }
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
        if (!v.v(arrayList)) {
            Iterator<com.baidu.adp.widget.ListView.f> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.baidu.adp.widget.ListView.f next2 = it2.next();
                if (next2 instanceof bj) {
                    bj bjVar2 = (bj) next2;
                    bjVar2.cC(this.cDJ.getForumName());
                    if (bjVar2.rY()) {
                        if (!hashSet.contains(bjVar2.getTid())) {
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
        if (this.cqQ != null) {
            this.cqQ.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int yw = TbadkCoreApplication.getInst().getListItemRule().yw() - this.czB.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < yw) {
                this.czB.add(arrayList2.get(i));
            } else {
                this.czC.add(arrayList2.get(i));
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.f> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.czB);
        arrayList3.addAll(this.czC);
        com.baidu.tieba.frs.g.a.a(this.cDJ, this.cDJ.agT(), arrayList2, getPn());
        com.baidu.tieba.frs.g.a.a(eVar, arrayList2, arrayList3);
        return arrayList3;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> ajV() {
        int i;
        int size = this.czC.size() + 30;
        int yv = TbadkCoreApplication.getInst().getListItemRule().yv();
        if (size > yv && this.czC.size() > (i = size - yv)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.czC.remove(0);
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
        arrayList.addAll(this.czB);
        arrayList.addAll(this.czC);
        return arrayList;
    }
}
