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
    private int buG;
    private j ciL;
    private final ArrayList<f> cqn;
    private final ArrayList<f> cqo;
    private final a cqp;
    private final com.baidu.tieba.frs.f csY;
    private boolean csZ;
    private long cta;
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
        this.csZ = false;
        this.cta = 0L;
        this.cqn = new ArrayList<>();
        this.cqo = new ArrayList<>();
        this.mPn = 1;
        this.buG = -1;
        this.cqp = new a(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002) { // from class: com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (FrsLoadMoreModel.this.csY != null) {
                    FrsLoadMoreModel.this.isLoading = false;
                    if (responsedMessage == null) {
                        FrsLoadMoreModel.this.csY.kf(FrsLoadMoreModel.this.csY.getPageContext().getString(d.l.neterror));
                    } else if (responsedMessage.getError() == 0) {
                        i afm = FrsLoadMoreModel.this.csY.afm();
                        if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                            LoadMoreHttpResponseMessage loadMoreHttpResponseMessage = (LoadMoreHttpResponseMessage) responsedMessage;
                            if (afm != null) {
                                afm.a(loadMoreHttpResponseMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.csY.G(loadMoreHttpResponseMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreHttpResponseMessage) responsedMessage);
                        } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                            LoadMoreResponseSocketMessage loadMoreResponseSocketMessage = (LoadMoreResponseSocketMessage) responsedMessage;
                            if (afm != null) {
                                afm.a(loadMoreResponseSocketMessage.getBannerListData());
                            }
                            FrsLoadMoreModel.this.csY.G(loadMoreResponseSocketMessage.getThreadList());
                            FrsLoadMoreModel.this.a((LoadMoreResponseSocketMessage) responsedMessage);
                        }
                        if (!TextUtils.isEmpty(FrsLoadMoreModel.this.csY.getForumName()) && r.bhv().bhr() != null) {
                            r.bhv().bhr().g(FrsLoadMoreModel.this.csY.getForumName(), 2, false);
                        }
                        FrsLoadMoreModel.this.loadIndex++;
                    } else if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        FrsLoadMoreModel.this.csY.kf(responsedMessage.getErrorString());
                    } else {
                        FrsLoadMoreModel.this.csY.kf(FrsLoadMoreModel.this.csY.getPageContext().getString(d.l.neterror));
                    }
                }
            }
        };
        this.csY = fVar;
        setUniqueId(this.csY.getUniqueId());
        this.ciL = jVar;
        this.cqp.getHttpMessageListener().setSelfListener(true);
        this.cqp.getSocketMessageListener().setSelfListener(true);
        this.csY.registerListener(this.cqp);
    }

    public int aeV() {
        return this.buG;
    }

    public void setHasMore(int i) {
        this.buG = i;
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
            loadMoreRequestMessage.setLastClickTid(b.c(s.Hj(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.cta = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (r.bhv().bhr() != null) {
            loadMoreRequestMessage.setLoadCount(r.bhv().bhr().X(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        m mVar;
        if (!this.csZ) {
            this.csZ = true;
            if (com.baidu.tbadk.l.r.Gr().Gs() && (mVar = new m(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cta)) != null) {
                mVar.Gm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        m mVar;
        if (!this.csZ) {
            this.csZ = true;
            if (com.baidu.tbadk.l.r.Gr().Gs() && (mVar = new m(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cta)) != null) {
                mVar.Gm();
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
        this.cqn.clear();
        this.cqo.clear();
        this.buG = -1;
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
            this.cqn.clear();
            this.cqo.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<f> it = this.cqn.iterator();
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
                    blVar2.cD(this.csY.getForumName());
                    if (blVar2.rS()) {
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
        if (this.ciL != null) {
            this.ciL.a(this.mSortType, z2, arrayList2.size(), z, arrayList2);
        }
        int yl = TbadkCoreApplication.getInst().getListItemRule().yl() - this.cqn.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < yl) {
                this.cqn.add(arrayList2.get(i));
            } else {
                this.cqo.add(arrayList2.get(i));
            }
        }
        ArrayList<f> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.cqn);
        arrayList3.addAll(this.cqo);
        com.baidu.tieba.frs.g.a.a(this.csY, this.csY.aeP(), arrayList2, getPn());
        com.baidu.tieba.frs.g.a.a(eVar, arrayList2, arrayList3);
        return arrayList3;
    }

    public ArrayList<f> ahC() {
        int i;
        int size = this.cqo.size() + 30;
        int yk = TbadkCoreApplication.getInst().getListItemRule().yk();
        if (size > yk && this.cqo.size() > (i = size - yk)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.cqo.remove(0);
            }
        }
        ArrayList<f> arrayList = new ArrayList<>();
        arrayList.addAll(this.cqn);
        arrayList.addAll(this.cqo);
        return arrayList;
    }
}
