package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes20.dex */
public class f {
    private BdUniqueId aih;
    private long fid;
    private boolean hasMore;
    private e hku;
    private d hkv;
    private List<d> hkw;
    private ManagerElection hkx;

    public List<d> ceg() {
        return this.hkw;
    }

    public d ceh() {
        return this.hkv;
    }

    public e cei() {
        return this.hku;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.aih;
    }

    public ManagerElection cej() {
        return this.hkx;
    }

    public void am(ArrayList<d> arrayList) {
        this.hkw = arrayList;
    }

    public void a(e eVar) {
        this.hku = eVar;
    }

    public void a(d dVar) {
        this.hkv = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aih = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.hkx = managerElection;
    }
}
