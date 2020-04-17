package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes8.dex */
public class f {
    private BdUniqueId afA;
    private long fid;
    private e giZ;
    private d gja;
    private List<d> gjb;
    private ManagerElection gjc;
    private boolean hasMore;

    public List<d> bDW() {
        return this.gjb;
    }

    public d bDX() {
        return this.gja;
    }

    public e bDY() {
        return this.giZ;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.afA;
    }

    public ManagerElection bDZ() {
        return this.gjc;
    }

    public void ad(ArrayList<d> arrayList) {
        this.gjb = arrayList;
    }

    public void a(e eVar) {
        this.giZ = eVar;
    }

    public void a(d dVar) {
        this.gja = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.afA = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.gjc = managerElection;
    }
}
