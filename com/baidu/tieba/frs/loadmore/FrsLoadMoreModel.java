package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.frs.mc.aa;
import com.baidu.tieba.frs.r;
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
    private int bqy;
    private aa cda;
    private final ArrayList<v> ckn;
    private final ArrayList<v> cko;
    private final com.baidu.adp.framework.listener.a ckp;
    private final r cmi;
    private boolean cmj;
    private long cmk;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPn;
    private int mSortType;

    public FrsLoadMoreModel(r rVar, aa aaVar) {
        super(rVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.cmj = false;
        this.cmk = 0L;
        this.ckn = new ArrayList<>();
        this.cko = new ArrayList<>();
        this.mPn = 1;
        this.bqy = -1;
        this.ckp = new a(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.cmi = rVar;
        setUniqueId(this.cmi.getUniqueId());
        this.cda = aaVar;
        this.ckp.getHttpMessageListener().setSelfListener(true);
        this.ckp.getSocketMessageListener().setSelfListener(true);
        this.cmi.registerListener(this.ckp);
    }

    public int adV() {
        return this.bqy;
    }

    public void setHasMore(int i) {
        this.bqy = i;
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
        if (j == 0 || z.t(list)) {
            this.loadingDone = true;
            return;
        }
        String ay = ay(list);
        if (!TextUtils.isEmpty(ay)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(ay);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            loadMoreRequestMessage.setLastClickTid(b.c(com.baidu.tbadk.util.v.GU(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.cmk = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (com.baidu.tieba.recapp.aa.bdU().bdQ() != null) {
            loadMoreRequestMessage.setLoadCount(com.baidu.tieba.recapp.aa.bdU().bdQ().U(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.j.v vVar;
        if (!this.cmj) {
            this.cmj = true;
            if (com.baidu.tbadk.j.aa.Gb().Gc() && (vVar = new com.baidu.tbadk.j.v(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cmk)) != null) {
                vVar.FW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.j.v vVar;
        if (!this.cmj) {
            this.cmj = true;
            if (com.baidu.tbadk.j.aa.Gb().Gc() && (vVar = new com.baidu.tbadk.j.v(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cmk)) != null) {
                vVar.FW();
            }
        }
    }

    private String ay(List<Long> list) {
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
        this.ckn.clear();
        this.cko.clear();
        this.bqy = -1;
        this.mPn = 1;
    }

    public boolean az(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.loadIndex == 2 || this.loadingDone) ? false : true;
        }
        this.loadingDone = true;
        return false;
    }

    public ArrayList<v> a(boolean z, boolean z2, boolean z3, ArrayList<v> arrayList, e eVar) {
        if (z3) {
            this.ckn.clear();
            this.cko.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<v> it = this.ckn.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof bm) {
                bm bmVar = (bm) next;
                if (bmVar.getTid() != null) {
                    hashSet.add(bmVar.getTid());
                }
            }
        }
        ArrayList<v> arrayList2 = new ArrayList<>();
        if (!z.t(arrayList)) {
            Iterator<v> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                v next2 = it2.next();
                if (next2 instanceof bm) {
                    bm bmVar2 = (bm) next2;
                    bmVar2.cy(this.cmi.getForumName());
                    if (bmVar2.rO()) {
                        if (!hashSet.contains(bmVar2.getTid())) {
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
        if (this.cda != null) {
            this.cda.a(this.mSortType, z2, arrayList2.size(), z, arrayList2);
        }
        int ya = TbadkCoreApplication.m9getInst().getListItemRule().ya() - this.ckn.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < ya) {
                this.ckn.add(arrayList2.get(i));
            } else {
                this.cko.add(arrayList2.get(i));
            }
        }
        ArrayList<v> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.ckn);
        arrayList3.addAll(this.cko);
        com.baidu.tieba.frs.e.a.a(this.cmi, this.cmi.adP(), arrayList2, getPn());
        com.baidu.tieba.frs.e.a.a(eVar, arrayList2, arrayList3);
        return arrayList3;
    }

    public ArrayList<v> agt() {
        int i;
        int size = this.cko.size() + 30;
        int xZ = TbadkCoreApplication.m9getInst().getListItemRule().xZ();
        if (size > xZ && this.cko.size() > (i = size - xZ)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.cko.remove(0);
            }
        }
        ArrayList<v> arrayList = new ArrayList<>();
        arrayList.addAll(this.ckn);
        arrayList.addAll(this.cko);
        return arrayList;
    }
}
