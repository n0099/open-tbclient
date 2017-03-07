package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.performanceLog.aa;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.mc.v;
import com.baidu.tieba.tbadkCore.data.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsLoadMoreModel extends BdBaseModel<FrsActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private v bNI;
    private FrsActivity bOq;
    private final ArrayList<com.baidu.adp.widget.ListView.v> bVX;
    private final ArrayList<com.baidu.adp.widget.ListView.v> bVY;
    private final com.baidu.adp.framework.listener.a bVZ;
    private boolean bZf;
    private long bZg;
    private int bjb;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPn;
    private int mSortType;

    public FrsLoadMoreModel(FrsActivity frsActivity, v vVar) {
        super(frsActivity.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.bZf = false;
        this.bZg = 0L;
        this.bVX = new ArrayList<>();
        this.bVY = new ArrayList<>();
        this.mPn = 1;
        this.bjb = -1;
        this.bVZ = new a(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.bOq = frsActivity;
        this.bNI = vVar;
        this.bVZ.getHttpMessageListener().setSelfListener(true);
        this.bVZ.getSocketMessageListener().setSelfListener(true);
        this.bOq.registerListener(this.bVZ);
    }

    public int YF() {
        return this.bjb;
    }

    public void setHasMore(int i) {
        this.bjb = i;
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
        if (j == 0 || x.q(list)) {
            this.loadingDone = true;
            return;
        }
        String as = as(list);
        if (!TextUtils.isEmpty(as)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(as);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(r.GT(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.bZg = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.performanceLog.v vVar;
        if (!this.bZf) {
            this.bZf = true;
            if (aa.Gi().Gj() && (vVar = new com.baidu.tbadk.performanceLog.v(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bZg)) != null) {
                vVar.Gd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.performanceLog.v vVar;
        if (!this.bZf) {
            this.bZf = true;
            if (aa.Gi().Gj() && (vVar = new com.baidu.tbadk.performanceLog.v(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bZg)) != null) {
                vVar.Gd();
            }
        }
    }

    private String as(List<Long> list) {
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
        this.bVX.clear();
        this.bVY.clear();
        this.bjb = -1;
        this.mPn = 1;
    }

    public boolean at(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> a(boolean z, boolean z2, boolean z3, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, e eVar) {
        if (z3) {
            this.bVX.clear();
            this.bVY.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<com.baidu.adp.widget.ListView.v> it = this.bVX.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bj) {
                bj bjVar = (bj) next;
                if (bjVar.getTid() != null) {
                    hashSet.add(bjVar.getTid());
                }
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.v> arrayList2 = new ArrayList<>();
        if (!x.q(arrayList)) {
            Iterator<com.baidu.adp.widget.ListView.v> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.baidu.adp.widget.ListView.v next2 = it2.next();
                if (next2 instanceof bj) {
                    bj bjVar2 = (bj) next2;
                    if (bjVar2.sn()) {
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
        if (this.bNI != null) {
            this.bNI.a(this.mSortType, z2, arrayList2.size(), z, arrayList2);
        }
        int ye = TbadkCoreApplication.m9getInst().getListItemRule().ye() - this.bVX.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < ye) {
                this.bVX.add(arrayList2.get(i));
            } else {
                this.bVY.add(arrayList2.get(i));
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.v> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.bVX);
        arrayList3.addAll(this.bVY);
        com.baidu.tieba.frs.utils.a.a(this.bOq.getPageContext(), this.bOq.Yx(), arrayList2, getPn());
        com.baidu.tieba.frs.utils.a.a(eVar, arrayList2, arrayList3);
        return arrayList3;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> abU() {
        int i;
        int size = this.bVY.size() + 30;
        int yd = TbadkCoreApplication.m9getInst().getListItemRule().yd();
        if (size > yd && this.bVY.size() > (i = size - yd)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bVY.remove(0);
            }
        }
        ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
        arrayList.addAll(this.bVX);
        arrayList.addAll(this.bVY);
        return arrayList;
    }
}
