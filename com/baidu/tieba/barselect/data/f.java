package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes15.dex */
public class f {
    private BdUniqueId agB;
    private long fid;
    private List<d> gQA;
    private ManagerElection gQB;
    private e gQy;
    private d gQz;
    private boolean hasMore;

    public List<d> bQF() {
        return this.gQA;
    }

    public d bQG() {
        return this.gQz;
    }

    public e bQH() {
        return this.gQy;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.agB;
    }

    public ManagerElection bQI() {
        return this.gQB;
    }

    public void ae(ArrayList<d> arrayList) {
        this.gQA = arrayList;
    }

    public void a(e eVar) {
        this.gQy = eVar;
    }

    public void a(d dVar) {
        this.gQz = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.agB = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.gQB = managerElection;
    }
}
