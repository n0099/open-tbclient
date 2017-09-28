package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.k.m;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.data.e;
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
    private int bzQ;
    private final ArrayList<f> cAu;
    private final ArrayList<f> cAv;
    private final a cAw;
    private final com.baidu.tieba.frs.f cEC;
    private boolean cED;
    private long cEE;
    private i cro;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPn;
    private int mSortType;

    public FrsLoadMoreModel(com.baidu.tieba.frs.f fVar, i iVar) {
        super(fVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.cED = false;
        this.cEE = 0L;
        this.cAu = new ArrayList<>();
        this.cAv = new ArrayList<>();
        this.mPn = 1;
        this.bzQ = -1;
        this.cAw = new a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.cEC != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.cEC.ky(FrsLoadMoreModel.this.cEC.getPageContext().getString(d.l.neterror));
                    } else if (responsedMessage.getError() == 0) {
                        com.baidu.tieba.tbadkCore.i ahk = FrsLoadMoreModel.this.cEC.ahk();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (ahk != null) {
                                ahk.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.cEC.G(loadMoreHttpResponseMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (ahk != null) {
                                ahk.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.cEC.G(loadMoreResponseSocketMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.cEC.getForumName()) && r.bfU().bfO() != null) {
                            r.bfU().bfO().g(FrsLoadMoreModel.this.cEC.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        FrsLoadMoreModel.this.cEC.ky(responsedMessage.getErrorString());
                    } else {
                        FrsLoadMoreModel.this.cEC.ky(FrsLoadMoreModel.this.cEC.getPageContext().getString(d.l.neterror));
                    }
                }
            }
        };
        this.cEC = fVar;
        setUniqueId(this.cEC.getUniqueId());
        this.cro = iVar;
        this.cAw.getHttpMessageListener().setSelfListener(true);
        this.cAw.getSocketMessageListener().setSelfListener(true);
        this.cEC.registerListener(this.cAw);
    }

    public int agV() {
        return this.bzQ;
    }

    public void setHasMore(int i) {
        this.bzQ = i;
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
        if (j == 0 || v.u(list)) {
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
            loadMoreRequestMessage.setLastClickTid(b.c(com.baidu.tbadk.util.r.GU(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.cEE = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.bfU().bfO() != null) {
            loadMoreRequestMessage.setLoadCount(r.bfU().bfO().V(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        m mVar;
        if (!this.cED) {
            this.cED = true;
            if (com.baidu.tbadk.k.r.Gc().Gd() && (mVar = new m(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cEE)) != null) {
                mVar.FX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        m mVar;
        if (!this.cED) {
            this.cED = true;
            if (com.baidu.tbadk.k.r.Gc().Gd() && (mVar = new m(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cEE)) != null) {
                mVar.FX();
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
        this.cAu.clear();
        this.cAv.clear();
        this.bzQ = -1;
        this.mPn = 1;
    }

    public boolean aO(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<f> a(boolean z, boolean z2, boolean z3, ArrayList<f> arrayList, e eVar) {
        if (z3) {
            this.cAu.clear();
            this.cAv.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<f> it = this.cAu.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (next instanceof bh) {
                bh bhVar = (bh) next;
                if (bhVar.getTid() != null) {
                    hashSet.add(bhVar.getTid());
                }
            }
        }
        ArrayList<f> arrayList2 = new ArrayList<>();
        if (!v.u(arrayList)) {
            Iterator<f> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                f next2 = it2.next();
                if (next2 instanceof bh) {
                    bh bhVar2 = (bh) next2;
                    bhVar2.cC(this.cEC.getForumName());
                    if (bhVar2.rS()) {
                        if (!hashSet.contains(bhVar2.getTid())) {
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
        if (this.cro != null) {
            this.cro.a(this.mSortType, z2, arrayList2.size(), z, arrayList2, false);
        }
        int xV = TbadkCoreApplication.getInst().getListItemRule().xV() - this.cAu.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < xV) {
                this.cAu.add(arrayList2.get(i));
            } else {
                this.cAv.add(arrayList2.get(i));
            }
        }
        ArrayList<f> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.cAu);
        arrayList3.addAll(this.cAv);
        com.baidu.tieba.frs.g.a.a(this.cEC, this.cEC.agP(), arrayList2, getPn());
        com.baidu.tieba.frs.g.a.a(eVar, arrayList2, arrayList3);
        return arrayList3;
    }

    public ArrayList<f> ajZ() {
        int i;
        int size = this.cAv.size() + 30;
        int xU = TbadkCoreApplication.getInst().getListItemRule().xU();
        if (size > xU && this.cAv.size() > (i = size - xU)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.cAv.remove(0);
            }
        }
        ArrayList<f> arrayList = new ArrayList<>();
        arrayList.addAll(this.cAu);
        arrayList.addAll(this.cAv);
        return arrayList;
    }
}
