package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes8.dex */
public class f {
    private BdUniqueId agK;
    private long fid;
    private e gKS;
    private d gKT;
    private List<d> gKU;
    private ManagerElection gKV;
    private boolean hasMore;

    public List<d> bNu() {
        return this.gKU;
    }

    public d bNv() {
        return this.gKT;
    }

    public e bNw() {
        return this.gKS;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.agK;
    }

    public ManagerElection bNx() {
        return this.gKV;
    }

    public void ad(ArrayList<d> arrayList) {
        this.gKU = arrayList;
    }

    public void a(e eVar) {
        this.gKS = eVar;
    }

    public void a(d dVar) {
        this.gKT = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.agK = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.gKV = managerElection;
    }
}
