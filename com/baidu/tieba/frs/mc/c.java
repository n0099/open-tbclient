package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    private final q hSV;
    private final FrsModelController hTo;
    private final FrsFragment ios;
    private final FrsLoadMoreModel iot;
    private final FrsSmartLoadMoreModel iou;
    private final a iov = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.hSV != null && c.this.hSV.getListView() != null) {
                List<com.baidu.adp.widget.ListView.q> data = c.this.hSV.getListView().getData();
                if (!y.isEmpty(data) && c.this.hSV.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.q) y.remove(data, i)) != null) {
                    c.this.hSV.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.ios = frsFragment;
        this.iot = new FrsLoadMoreModel(frsFragment, kVar);
        this.iou = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.iou.a(this.iov);
        this.iot.a(this.iov);
        this.hSV = frsFragment.clT();
        this.hTo = frsFragment.clO();
        this.iou.setSortType(this.hTo.getSortType());
        this.iot.setSortType(this.hTo.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.hTo != null) {
            boolean csb = this.ios.clO().csb();
            if (this.hTo.csc()) {
                return this.iou.a(z, csb, arrayList, z3, z4);
            }
            return this.iot.a(z, csb, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.hTo != null) {
            if (this.hTo.csc()) {
                this.iou.resetData();
            } else {
                this.iot.resetData();
            }
        }
    }

    public boolean cO(List<Long> list) {
        if (this.hTo == null || this.hTo.csc()) {
            return false;
        }
        return this.iot.cO(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.hTo != null && this.hSV != null && frsViewData != null) {
            this.ios.hTb = System.currentTimeMillis();
            if (this.hTo.csc()) {
                if (this.iou.clU() == 1 && !this.hTo.isLoading()) {
                    this.iou.setSortType(this.hTo.getSortType());
                    this.iou.crH();
                    int pn = this.iou.getPn();
                    this.iou.setPn(pn);
                    this.hTo.yk(pn + 1);
                }
            } else if (this.hTo.crS() == 1) {
                if (!this.iot.isLoading && !this.hTo.isLoading()) {
                    int pn2 = this.iot.getPn();
                    if (this.iot.cO(frsViewData.getThreadListIds())) {
                        this.iot.crH();
                        this.iot.setSortType(this.hTo.getSortType());
                        this.iot.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.iot.clU() == 1) {
                        this.iot.crH();
                        this.iot.setPn(pn2);
                        this.hTo.yk(pn2 + 1);
                        this.iot.loadingDone = false;
                        this.iot.loadIndex = 0;
                    }
                }
            } else if (!this.hTo.crU()) {
                this.hTo.ccJ();
            }
        }
    }

    public int clU() {
        if (this.hTo == null) {
            return -1;
        }
        if (this.hTo.csc()) {
            return this.iou.clU();
        }
        return this.iot.clU();
    }

    public void setHasMore(int i) {
        if (this.hTo != null) {
            if (this.hTo.csc()) {
                this.iou.setHasMore(i);
            } else {
                this.iot.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.hTo == null) {
            return 1;
        }
        if (this.hTo.csc()) {
            return this.iou.getPn();
        }
        return this.iot.getPn();
    }

    public void setPn(int i) {
        if (this.hTo != null) {
            if (this.hTo.csc()) {
                this.iou.setPn(i);
            } else {
                this.iot.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.hTo.csc() ? this.iou.getDataList() : this.hTo.crW();
    }

    public FrsSmartLoadMoreModel crK() {
        return this.iou;
    }

    public void d(com.baidu.adp.widget.ListView.q qVar) {
        if (qVar != null) {
            if (this.hTo.csc()) {
                this.iou.d(qVar);
            } else {
                this.iot.d(qVar);
            }
        }
    }
}
