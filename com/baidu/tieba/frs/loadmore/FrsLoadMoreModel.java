package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.j.aa;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.mc.x;
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
    private x bPO;
    private FrsActivity bQw;
    private final ArrayList<v> bYc;
    private final ArrayList<v> bYd;
    private final com.baidu.adp.framework.listener.a bYe;
    private boolean bZV;
    private long bZW;
    private int ble;
    private int bxh;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mSortType;

    public FrsLoadMoreModel(FrsActivity frsActivity, x xVar) {
        super(frsActivity.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.bZV = false;
        this.bZW = 0L;
        this.bYc = new ArrayList<>();
        this.bYd = new ArrayList<>();
        this.bxh = 1;
        this.ble = -1;
        this.bYe = new a(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.bQw = frsActivity;
        this.bPO = xVar;
        this.bYe.getHttpMessageListener().setSelfListener(true);
        this.bYe.getSocketMessageListener().setSelfListener(true);
        this.bQw.registerListener(this.bYe);
    }

    public int aac() {
        return this.ble;
    }

    public void setHasMore(int i) {
        this.ble = i;
    }

    public int getPn() {
        return this.bxh;
    }

    public void setPn(int i) {
        this.bxh = i;
    }

    public void setSortType(int i) {
        this.mSortType = i;
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || com.baidu.tbadk.core.util.x.q(list)) {
            this.loadingDone = true;
            return;
        }
        String at = at(list);
        if (!TextUtils.isEmpty(at)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(at);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(r.Hs(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.bZW = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.j.v vVar;
        if (!this.bZV) {
            this.bZV = true;
            if (aa.GG().GH() && (vVar = new com.baidu.tbadk.j.v(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bZW)) != null) {
                vVar.GB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.j.v vVar;
        if (!this.bZV) {
            this.bZV = true;
            if (aa.GG().GH() && (vVar = new com.baidu.tbadk.j.v(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bZW)) != null) {
                vVar.GB();
            }
        }
    }

    private String at(List<Long> list) {
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
        this.bYc.clear();
        this.bYd.clear();
        this.ble = -1;
        this.bxh = 1;
    }

    public boolean au(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<v> a(boolean z, boolean z2, boolean z3, ArrayList<v> arrayList, e eVar) {
        if (z3) {
            this.bYc.clear();
            this.bYd.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<v> it = this.bYc.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof bi) {
                bi biVar = (bi) next;
                if (biVar.getTid() != null) {
                    hashSet.add(biVar.getTid());
                }
            }
        }
        ArrayList<v> arrayList2 = new ArrayList<>();
        if (!com.baidu.tbadk.core.util.x.q(arrayList)) {
            Iterator<v> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                v next2 = it2.next();
                if (next2 instanceof bi) {
                    bi biVar2 = (bi) next2;
                    if (biVar2.sL()) {
                        if (!hashSet.contains(biVar2.getTid())) {
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
        if (this.bPO != null) {
            this.bPO.a(this.mSortType, z2, arrayList2.size(), z, arrayList2);
        }
        int yC = TbadkCoreApplication.m9getInst().getListItemRule().yC() - this.bYc.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < yC) {
                this.bYc.add(arrayList2.get(i));
            } else {
                this.bYd.add(arrayList2.get(i));
            }
        }
        ArrayList<v> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.bYc);
        arrayList3.addAll(this.bYd);
        com.baidu.tieba.frs.f.a.a(this.bQw.getPageContext(), this.bQw.ZU(), arrayList2, getPn());
        com.baidu.tieba.frs.f.a.a(eVar, arrayList2, arrayList3);
        return arrayList3;
    }

    public ArrayList<v> adr() {
        int i;
        int size = this.bYd.size() + 30;
        int yB = TbadkCoreApplication.m9getInst().getListItemRule().yB();
        if (size > yB && this.bYd.size() > (i = size - yB)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bYd.remove(0);
            }
        }
        ArrayList<v> arrayList = new ArrayList<>();
        arrayList.addAll(this.bYc);
        arrayList.addAll(this.bYd);
        return arrayList;
    }
}
