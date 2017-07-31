package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.l.m;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.d;
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
    private int bvQ;
    private j cjR;
    private final ArrayList<f> crA;
    private final a crB;
    private final ArrayList<f> crz;
    private final com.baidu.tieba.frs.f cus;
    private boolean cut;
    private long cuu;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPn;
    private int mSortType;

    public FrsLoadMoreModel(com.baidu.tieba.frs.f fVar, j jVar) {
        super(fVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.cut = false;
        this.cuu = 0L;
        this.crz = new ArrayList<>();
        this.crA = new ArrayList<>();
        this.mPn = 1;
        this.bvQ = -1;
        this.crB = new a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.cus != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.cus.kj(FrsLoadMoreModel.this.cus.getPageContext().getString(d.l.neterror));
                    } else if (responsedMessage.getError() == 0) {
                        i afr = FrsLoadMoreModel.this.cus.afr();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (afr != null) {
                                afr.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.cus.G(loadMoreHttpResponseMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (afr != null) {
                                afr.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.cus.G(loadMoreResponseSocketMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.cus.getForumName()) && r.bhF().bhB() != null) {
                            r.bhF().bhB().g(FrsLoadMoreModel.this.cus.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        FrsLoadMoreModel.this.cus.kj(responsedMessage.getErrorString());
                    } else {
                        FrsLoadMoreModel.this.cus.kj(FrsLoadMoreModel.this.cus.getPageContext().getString(d.l.neterror));
                    }
                }
            }
        };
        this.cus = fVar;
        setUniqueId(this.cus.getUniqueId());
        this.cjR = jVar;
        this.crB.getHttpMessageListener().setSelfListener(true);
        this.crB.getSocketMessageListener().setSelfListener(true);
        this.cus.registerListener(this.crB);
    }

    public int afa() {
        return this.bvQ;
    }

    public void setHasMore(int i) {
        this.bvQ = i;
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
        if (j == 0 || u.v(list)) {
            this.loadingDone = true;
            return;
        }
        String aJ = aJ(list);
        if (!TextUtils.isEmpty(aJ)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(aJ);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.d(s.Hr(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.cuu = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.bhF().bhB() != null) {
            loadMoreRequestMessage.setLoadCount(r.bhF().bhB().W(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        m mVar;
        if (!this.cut) {
            this.cut = true;
            if (com.baidu.tbadk.l.r.Gz().GA() && (mVar = new m(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cuu)) != null) {
                mVar.Gu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        m mVar;
        if (!this.cut) {
            this.cut = true;
            if (com.baidu.tbadk.l.r.Gz().GA() && (mVar = new m(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cuu)) != null) {
                mVar.Gu();
            }
        }
    }

    private String aJ(List<Long> list) {
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
        this.crz.clear();
        this.crA.clear();
        this.bvQ = -1;
        this.mPn = 1;
    }

    public boolean aK(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<f> a(boolean z, boolean z2, boolean z3, ArrayList<f> arrayList, e eVar) {
        if (z3) {
            this.crz.clear();
            this.crA.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<f> it = this.crz.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (next instanceof bl) {
                bl blVar = (bl) next;
                if (blVar.getTid() != null) {
                    hashSet.add(blVar.getTid());
                }
            }
        }
        ArrayList<f> arrayList2 = new ArrayList<>();
        if (!u.v(arrayList)) {
            Iterator<f> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                f next2 = it2.next();
                if (next2 instanceof bl) {
                    bl blVar2 = (bl) next2;
                    blVar2.cJ(this.cus.getForumName());
                    if (blVar2.sc()) {
                        if (!hashSet.contains(blVar2.getTid())) {
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
        if (this.cjR != null) {
            this.cjR.a(this.mSortType, z2, arrayList2.size(), z, arrayList2);
        }
        int yt = TbadkCoreApplication.getInst().getListItemRule().yt() - this.crz.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < yt) {
                this.crz.add(arrayList2.get(i));
            } else {
                this.crA.add(arrayList2.get(i));
            }
        }
        ArrayList<f> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.crz);
        arrayList3.addAll(this.crA);
        com.baidu.tieba.frs.f.a.a(this.cus, this.cus.aeU(), arrayList2, getPn());
        com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        return arrayList3;
    }

    public ArrayList<f> ahJ() {
        int i;
        int size = this.crA.size() + 30;
        int ys = TbadkCoreApplication.getInst().getListItemRule().ys();
        if (size > ys && this.crA.size() > (i = size - ys)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.crA.remove(0);
            }
        }
        ArrayList<f> arrayList = new ArrayList<>();
        arrayList.addAll(this.crz);
        arrayList.addAll(this.crA);
        return arrayList;
    }
}
