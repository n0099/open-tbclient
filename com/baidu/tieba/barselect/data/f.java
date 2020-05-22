package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes8.dex */
public class f {
    private BdUniqueId afZ;
    private long fid;
    private e gxV;
    private d gxW;
    private List<d> gxX;
    private ManagerElection gxY;
    private boolean hasMore;

    public List<d> bKm() {
        return this.gxX;
    }

    public d bKn() {
        return this.gxW;
    }

    public e bKo() {
        return this.gxV;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.afZ;
    }

    public ManagerElection bKp() {
        return this.gxY;
    }

    public void ad(ArrayList<d> arrayList) {
        this.gxX = arrayList;
    }

    public void a(e eVar) {
        this.gxV = eVar;
    }

    public void a(d dVar) {
        this.gxW = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.afZ = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.gxY = managerElection;
    }
}
