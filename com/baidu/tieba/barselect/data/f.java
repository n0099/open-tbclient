package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes7.dex */
public class f {
    private BdUniqueId agN;
    private long fid;
    private boolean hasMore;
    private e ikT;
    private d ikU;
    private List<d> ikV;
    private ManagerElection ikW;

    public List<d> cqd() {
        return this.ikV;
    }

    public d cqe() {
        return this.ikU;
    }

    public e cqf() {
        return this.ikT;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.agN;
    }

    public ManagerElection cqg() {
        return this.ikW;
    }

    public void ak(ArrayList<d> arrayList) {
        this.ikV = arrayList;
    }

    public void a(e eVar) {
        this.ikT = eVar;
    }

    public void a(d dVar) {
        this.ikU = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.agN = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.ikW = managerElection;
    }
}
