package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.j.aa;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.frs.mc.x;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.data.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LOAD_MORE_COUNT = 30;
    public static final String LOAD_MORE_URL = "c/f/frs/threadlist";
    public static final int LOAD_THREAD_LIST = 30;
    private x bPd;
    private final ArrayList<v> bWc;
    private final ArrayList<v> bWd;
    private final com.baidu.adp.framework.listener.a bWe;
    private final r bXK;
    private boolean bXL;
    private long bXM;
    private int blB;
    private int bxg;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mSortType;

    public FrsLoadMoreModel(r rVar, x xVar) {
        super(rVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.bXL = false;
        this.bXM = 0L;
        this.bWc = new ArrayList<>();
        this.bWd = new ArrayList<>();
        this.bxg = 1;
        this.blB = -1;
        this.bWe = new a(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.bXK = rVar;
        setUniqueId(this.bXK.getUniqueId());
        this.bPd = xVar;
        this.bWe.getHttpMessageListener().setSelfListener(true);
        this.bWe.getSocketMessageListener().setSelfListener(true);
        this.bXK.registerListener(this.bWe);
    }

    public int Za() {
        return this.blB;
    }

    public void setHasMore(int i) {
        this.blB = i;
    }

    public int getPn() {
        return this.bxg;
    }

    public void setPn(int i) {
        this.bxg = i;
    }

    public void setSortType(int i) {
        this.mSortType = i;
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || com.baidu.tbadk.core.util.x.r(list)) {
            this.loadingDone = true;
            return;
        }
        String ap = ap(list);
        if (!TextUtils.isEmpty(ap)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(ap);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(u.GD(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.bXM = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.j.v vVar;
        if (!this.bXL) {
            this.bXL = true;
            if (aa.FK().FL() && (vVar = new com.baidu.tbadk.j.v(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bXM)) != null) {
                vVar.FF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.j.v vVar;
        if (!this.bXL) {
            this.bXL = true;
            if (aa.FK().FL() && (vVar = new com.baidu.tbadk.j.v(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.bXM)) != null) {
                vVar.FF();
            }
        }
    }

    private String ap(List<Long> list) {
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
        this.bWc.clear();
        this.bWd.clear();
        this.blB = -1;
        this.bxg = 1;
    }

    public boolean aq(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<v> a(boolean z, boolean z2, boolean z3, ArrayList<v> arrayList, e eVar) {
        if (z3) {
            this.bWc.clear();
            this.bWd.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<v> it = this.bWc.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof bk) {
                bk bkVar = (bk) next;
                if (bkVar.getTid() != null) {
                    hashSet.add(bkVar.getTid());
                }
            }
        }
        ArrayList<v> arrayList2 = new ArrayList<>();
        if (!com.baidu.tbadk.core.util.x.r(arrayList)) {
            Iterator<v> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                v next2 = it2.next();
                if (next2 instanceof bk) {
                    bk bkVar2 = (bk) next2;
                    if (bkVar2.rV()) {
                        if (!hashSet.contains(bkVar2.getTid())) {
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
        if (this.bPd != null) {
            this.bPd.a(this.mSortType, z2, arrayList2.size(), z, arrayList2);
        }
        int xQ = TbadkCoreApplication.m9getInst().getListItemRule().xQ() - this.bWc.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < xQ) {
                this.bWc.add(arrayList2.get(i));
            } else {
                this.bWd.add(arrayList2.get(i));
            }
        }
        ArrayList<v> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.bWc);
        arrayList3.addAll(this.bWd);
        com.baidu.tieba.frs.d.a.a(this.bXK.getPageContext(), this.bXK.YU(), arrayList2, getPn());
        com.baidu.tieba.frs.d.a.a(eVar, arrayList2, arrayList3);
        return arrayList3;
    }

    public ArrayList<v> abx() {
        int i;
        int size = this.bWd.size() + 30;
        int xP = TbadkCoreApplication.m9getInst().getListItemRule().xP();
        if (size > xP && this.bWd.size() > (i = size - xP)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bWd.remove(0);
            }
        }
        ArrayList<v> arrayList = new ArrayList<>();
        arrayList.addAll(this.bWc);
        arrayList.addAll(this.bWd);
        return arrayList;
    }
}
