package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.j.aa;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.frs.mc.x;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.recapp.z;
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
    private x bUR;
    private int bmI;
    private final ArrayList<v> ccb;
    private final ArrayList<v> ccc;
    private final com.baidu.adp.framework.listener.a ccd;
    private final r cdV;
    private boolean cdW;
    private long cdX;
    public boolean isLoading;
    public int loadIndex;
    public boolean loadingDone;
    private int mPn;
    private int mSortType;

    public FrsLoadMoreModel(r rVar, x xVar) {
        super(rVar.getPageContext());
        this.isLoading = false;
        this.loadingDone = false;
        this.loadIndex = 0;
        this.cdW = false;
        this.cdX = 0L;
        this.ccb = new ArrayList<>();
        this.ccc = new ArrayList<>();
        this.mPn = 1;
        this.bmI = -1;
        this.ccd = new a(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.cdV = rVar;
        setUniqueId(this.cdV.getUniqueId());
        this.bUR = xVar;
        this.ccd.getHttpMessageListener().setSelfListener(true);
        this.ccd.getSocketMessageListener().setSelfListener(true);
        this.cdV.registerListener(this.ccd);
    }

    public int aae() {
        return this.bmI;
    }

    public void setHasMore(int i) {
        this.bmI = i;
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
            loadMoreRequestMessage.setLastClickTid(b.c(u.Gx(), 0L));
            loadMoreRequestMessage.setSortType(this.mSortType);
            loadMoreRequestMessage.setPageType(1);
            if (!TextUtils.isEmpty(str)) {
                a(str, loadMoreRequestMessage);
            }
            sendMessage(loadMoreRequestMessage);
            this.isLoading = true;
            this.cdX = System.currentTimeMillis();
        }
    }

    private void a(String str, LoadMoreRequestMessage loadMoreRequestMessage) {
        if (z.aZK().aZG() != null) {
            loadMoreRequestMessage.setLoadCount(z.aZK().aZG().P(str, false) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        com.baidu.tbadk.j.v vVar;
        if (!this.cdW) {
            this.cdW = true;
            if (aa.FE().FF() && (vVar = new com.baidu.tbadk.j.v(1000, false, loadMoreResponseSocketMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cdX)) != null) {
                vVar.Fz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        com.baidu.tbadk.j.v vVar;
        if (!this.cdW) {
            this.cdW = true;
            if (aa.FE().FF() && (vVar = new com.baidu.tbadk.j.v(1000, true, loadMoreHttpResponseMessage, 0L, 0L, 0L, true, System.currentTimeMillis() - this.cdX)) != null) {
                vVar.Fz();
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
        this.ccb.clear();
        this.ccc.clear();
        this.bmI = -1;
        this.mPn = 1;
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
            this.ccb.clear();
            this.ccc.clear();
        }
        HashSet hashSet = new HashSet();
        Iterator<v> it = this.ccb.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof bl) {
                bl blVar = (bl) next;
                if (blVar.getTid() != null) {
                    hashSet.add(blVar.getTid());
                }
            }
        }
        ArrayList<v> arrayList2 = new ArrayList<>();
        if (!com.baidu.tbadk.core.util.x.r(arrayList)) {
            Iterator<v> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                v next2 = it2.next();
                if (next2 instanceof bl) {
                    bl blVar2 = (bl) next2;
                    if (blVar2.rR()) {
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
        if (this.bUR != null) {
            this.bUR.a(this.mSortType, z2, arrayList2.size(), z, arrayList2);
        }
        int xJ = TbadkCoreApplication.m9getInst().getListItemRule().xJ() - this.ccb.size();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i < xJ) {
                this.ccb.add(arrayList2.get(i));
            } else {
                this.ccc.add(arrayList2.get(i));
            }
        }
        ArrayList<v> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.ccb);
        arrayList3.addAll(this.ccc);
        com.baidu.tieba.frs.e.a.a(this.cdV, this.cdV.ZY(), arrayList2, getPn());
        com.baidu.tieba.frs.e.a.a(eVar, arrayList2, arrayList3);
        return arrayList3;
    }

    public ArrayList<v> acB() {
        int i;
        int size = this.ccc.size() + 30;
        int xI = TbadkCoreApplication.m9getInst().getListItemRule().xI();
        if (size > xI && this.ccc.size() > (i = size - xI)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.ccc.remove(0);
            }
        }
        ArrayList<v> arrayList = new ArrayList<>();
        arrayList.addAll(this.ccb);
        arrayList.addAll(this.ccc);
        return arrayList;
    }
}
