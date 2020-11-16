package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes20.dex */
public class f {
    private BdUniqueId aiE;
    private long fid;
    private e hSi;
    private d hSj;
    private List<d> hSk;
    private ManagerElection hSl;
    private boolean hasMore;

    public List<d> cmN() {
        return this.hSk;
    }

    public d cmO() {
        return this.hSj;
    }

    public e cmP() {
        return this.hSi;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.aiE;
    }

    public ManagerElection cmQ() {
        return this.hSl;
    }

    public void ao(ArrayList<d> arrayList) {
        this.hSk = arrayList;
    }

    public void a(e eVar) {
        this.hSi = eVar;
    }

    public void a(d dVar) {
        this.hSj = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aiE = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.hSl = managerElection;
    }
}
