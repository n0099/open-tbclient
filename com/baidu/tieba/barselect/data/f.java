package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes8.dex */
public class f {
    private BdUniqueId agC;
    private long fid;
    private boolean hasMore;
    private e iqB;
    private d iqC;
    private List<d> iqD;
    private ManagerElection iqE;

    public List<d> crn() {
        return this.iqD;
    }

    public d cro() {
        return this.iqC;
    }

    public e crp() {
        return this.iqB;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.agC;
    }

    public ManagerElection crq() {
        return this.iqE;
    }

    public void aj(ArrayList<d> arrayList) {
        this.iqD = arrayList;
    }

    public void a(e eVar) {
        this.iqB = eVar;
    }

    public void a(d dVar) {
        this.iqC = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.agC = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.iqE = managerElection;
    }
}
