package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes8.dex */
public class f {
    private BdUniqueId afZ;
    private long fid;
    private e gyg;
    private d gyh;
    private List<d> gyi;
    private ManagerElection gyj;
    private boolean hasMore;

    public List<d> bKo() {
        return this.gyi;
    }

    public d bKp() {
        return this.gyh;
    }

    public e bKq() {
        return this.gyg;
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

    public ManagerElection bKr() {
        return this.gyj;
    }

    public void ad(ArrayList<d> arrayList) {
        this.gyi = arrayList;
    }

    public void a(e eVar) {
        this.gyg = eVar;
    }

    public void a(d dVar) {
        this.gyh = dVar;
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
        this.gyj = managerElection;
    }
}
