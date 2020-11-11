package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes21.dex */
public class f {
    private BdUniqueId aiz;
    private long fid;
    private e hRI;
    private d hRJ;
    private List<d> hRK;
    private ManagerElection hRL;
    private boolean hasMore;

    public List<d> cnl() {
        return this.hRK;
    }

    public d cnm() {
        return this.hRJ;
    }

    public e cnn() {
        return this.hRI;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.aiz;
    }

    public ManagerElection cno() {
        return this.hRL;
    }

    public void an(ArrayList<d> arrayList) {
        this.hRK = arrayList;
    }

    public void a(e eVar) {
        this.hRI = eVar;
    }

    public void a(d dVar) {
        this.hRJ = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aiz = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.hRL = managerElection;
    }
}
