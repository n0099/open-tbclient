package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes21.dex */
public class f {
    private BdUniqueId aiy;
    private long fid;
    private boolean hasMore;
    private e hzp;
    private d hzq;
    private List<d> hzr;
    private ManagerElection hzs;

    public List<d> chC() {
        return this.hzr;
    }

    public d chD() {
        return this.hzq;
    }

    public e chE() {
        return this.hzp;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.aiy;
    }

    public ManagerElection chF() {
        return this.hzs;
    }

    public void am(ArrayList<d> arrayList) {
        this.hzr = arrayList;
    }

    public void a(e eVar) {
        this.hzp = eVar;
    }

    public void a(d dVar) {
        this.hzq = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aiy = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.hzs = managerElection;
    }
}
