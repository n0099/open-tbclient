package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes21.dex */
public class f {
    private BdUniqueId aiz;
    private long fid;
    private e hLL;
    private d hLM;
    private List<d> hLN;
    private ManagerElection hLO;
    private boolean hasMore;

    public List<d> ckJ() {
        return this.hLN;
    }

    public d ckK() {
        return this.hLM;
    }

    public e ckL() {
        return this.hLL;
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

    public ManagerElection ckM() {
        return this.hLO;
    }

    public void an(ArrayList<d> arrayList) {
        this.hLN = arrayList;
    }

    public void a(e eVar) {
        this.hLL = eVar;
    }

    public void a(d dVar) {
        this.hLM = dVar;
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
        this.hLO = managerElection;
    }
}
