package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes15.dex */
public class f {
    private BdUniqueId ahK;
    private long fid;
    private boolean hasMore;
    private e hdo;
    private d hdp;
    private List<d> hdq;
    private ManagerElection hdr;

    public List<d> caQ() {
        return this.hdq;
    }

    public d caR() {
        return this.hdp;
    }

    public e caS() {
        return this.hdo;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.ahK;
    }

    public ManagerElection caT() {
        return this.hdr;
    }

    public void ak(ArrayList<d> arrayList) {
        this.hdq = arrayList;
    }

    public void a(e eVar) {
        this.hdo = eVar;
    }

    public void a(d dVar) {
        this.hdp = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.ahK = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.hdr = managerElection;
    }
}
