package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.performanceLog.v;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.data.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> {
    public boolean azx;
    private FrsActivity blH;
    public boolean bsm;
    public int bsn;
    private ArrayList<u> bso;
    private ArrayList<u> bsp;
    private final com.baidu.adp.framework.listener.a bsq;
    private boolean btj;
    private long btk;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.azx = false;
        this.bsm = false;
        this.bsn = 0;
        this.btj = false;
        this.btk = 0L;
        this.bso = new ArrayList<>();
        this.bsp = new ArrayList<>();
        this.bsq = new b(this, CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
        this.blH = frsActivity;
    }

    public void registerListener() {
        registerListener(this.bsq);
    }

    public void a(long j, List<Long> list, String str, int i) {
        if (j == 0 || list == null || list.size() == 0) {
            this.bsm = true;
            return;
        }
        String aj = aj(list);
        if (!TextUtils.isEmpty(aj)) {
            LoadMoreRequestMessage loadMoreRequestMessage = new LoadMoreRequestMessage();
            loadMoreRequestMessage.setForumId(j);
            loadMoreRequestMessage.setThreadIds(aj);
            loadMoreRequestMessage.setNeedAbstract(0);
            loadMoreRequestMessage.setForumName(str);
            loadMoreRequestMessage.setPageNumber(i);
            sendMessage(loadMoreRequestMessage);
            this.azx = true;
            this.btk = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreResponseSocketMessage loadMoreResponseSocketMessage) {
        if (!this.btj) {
            this.btj = true;
            v vVar = new v();
            vVar.fh(1000);
            vVar.aBK = true;
            vVar.aBH = false;
            vVar.isSuccess = loadMoreResponseSocketMessage.hasError() ? false : true;
            vVar.aBv = loadMoreResponseSocketMessage.performanceData.qH;
            vVar.aBw = loadMoreResponseSocketMessage.performanceData.qI;
            vVar.aBx = loadMoreResponseSocketMessage.performanceData.qJ;
            vVar.oL = loadMoreResponseSocketMessage.performanceData.qK;
            vVar.oM = loadMoreResponseSocketMessage.performanceData.qL;
            vVar.aBy = loadMoreResponseSocketMessage.performanceData.qM;
            vVar.aBz = loadMoreResponseSocketMessage.performanceData.qN;
            vVar.aBA = loadMoreResponseSocketMessage.performanceData.qO;
            vVar.aBA += loadMoreResponseSocketMessage.getProcessTime() - loadMoreResponseSocketMessage.getStartTime();
            vVar.aBF = loadMoreResponseSocketMessage.getDownSize();
            vVar.errCode = loadMoreResponseSocketMessage.getError();
            vVar.aBG = 0L;
            vVar.aBC = System.currentTimeMillis() - this.btk;
            vVar.sequenceID = loadMoreResponseSocketMessage.sequenceID;
            vVar.GP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadMoreHttpResponseMessage loadMoreHttpResponseMessage) {
        if (!this.btj) {
            this.btj = true;
            v vVar = new v();
            vVar.fh(1000);
            vVar.aBK = true;
            vVar.aBH = true;
            vVar.isSuccess = loadMoreHttpResponseMessage.hasError() ? false : true;
            vVar.aBv = loadMoreHttpResponseMessage.performanceData.qH;
            vVar.aBw = loadMoreHttpResponseMessage.performanceData.qI;
            vVar.aBx = loadMoreHttpResponseMessage.performanceData.qJ;
            vVar.oL = loadMoreHttpResponseMessage.performanceData.qK;
            vVar.oM = loadMoreHttpResponseMessage.performanceData.qL;
            vVar.aBy = loadMoreHttpResponseMessage.performanceData.qM;
            vVar.aBz = loadMoreHttpResponseMessage.performanceData.qN;
            vVar.aBA = loadMoreHttpResponseMessage.performanceData.qO;
            vVar.aBA += loadMoreHttpResponseMessage.getProcessTime() - loadMoreHttpResponseMessage.getStartTime();
            vVar.aBI = loadMoreHttpResponseMessage.performanceData.qR;
            vVar.aBJ = loadMoreHttpResponseMessage.performanceData.qS;
            vVar.aBF = 0L;
            vVar.errCode = loadMoreHttpResponseMessage.getError();
            vVar.aBG = loadMoreHttpResponseMessage.getDownSize();
            vVar.aBC = System.currentTimeMillis() - this.btk;
            vVar.aBL = loadMoreHttpResponseMessage.getOrginalMessage().getClientLogID();
            vVar.GP();
        }
    }

    private String aj(List<Long> list) {
        int i = 30;
        if (list == null || list.size() == 0) {
            this.bsm = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i2 = 0;
        if (this.bsn != 0) {
            if (this.bsn != 1) {
                return "";
            }
            i2 = 30;
            i = size;
        }
        if (i > list.size()) {
            i = list.size();
        }
        if (i2 >= list.size()) {
            this.bsm = true;
            return "";
        }
        for (int i3 = i2; i3 < i; i3++) {
            if (i3 == list.size() - 1) {
                this.bsm = true;
            }
            Long l = list.get(i3);
            if (l != null) {
                if (i3 == i - 1) {
                    sb.append(l);
                } else {
                    sb.append(l + ",");
                }
            }
        }
        return sb.toString();
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void resetData() {
        this.bsn = 0;
        this.bsm = false;
        this.bso.clear();
        this.bsp.clear();
    }

    public boolean ak(List<Long> list) {
        if (list != null && list.size() != 0) {
            return (this.bsn == 2 || this.bsm) ? false : true;
        }
        this.bsm = true;
        return false;
    }

    public ArrayList<u> a(boolean z, ArrayList<u> arrayList) {
        return a(z, arrayList, (f) null);
    }

    public ArrayList<u> a(boolean z, ArrayList<u> arrayList, f fVar) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        if (z) {
            this.bso.clear();
            this.bsp.clear();
        }
        int yI = TbadkCoreApplication.m411getInst().getListItemRule().yI() - this.bso.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i < yI) {
                this.bso.add(arrayList.get(i));
            } else {
                this.bsp.add(arrayList.get(i));
            }
        }
        ArrayList<u> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.bso);
        arrayList2.addAll(this.bsp);
        a(fVar, arrayList, arrayList2);
        return arrayList2;
    }

    private void a(f fVar, List<u> list, List<u> list2) {
        int[] iArr;
        int indexOf;
        if (fVar != null && y.p(list) > 0 && y.p(list2) > 0) {
            for (int i : f.eph) {
                u uVar = (u) y.b(list, i);
                if (uVar != null && (indexOf = list2.indexOf(uVar)) >= 0) {
                    fVar.aY(i, indexOf);
                }
            }
        }
    }

    public ArrayList<u> SK() {
        int i;
        int size = this.bsp.size() + 30;
        int yH = TbadkCoreApplication.m411getInst().getListItemRule().yH();
        if (size > yH && this.bsp.size() > (i = size - yH)) {
            for (int i2 = 0; i2 < i; i2++) {
                this.bsp.remove(0);
            }
        }
        ArrayList<u> arrayList = new ArrayList<>();
        arrayList.addAll(this.bso);
        arrayList.addAll(this.bsp);
        return arrayList;
    }
}
