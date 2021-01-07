package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes8.dex */
public class f {
    private BdUniqueId ahE;
    private long fid;
    private boolean hasMore;
    private e ipC;
    private d ipD;
    private List<d> ipE;
    private ManagerElection ipF;

    public List<d> ctV() {
        return this.ipE;
    }

    public d ctW() {
        return this.ipD;
    }

    public e ctX() {
        return this.ipC;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.ahE;
    }

    public ManagerElection ctY() {
        return this.ipF;
    }

    public void ap(ArrayList<d> arrayList) {
        this.ipE = arrayList;
    }

    public void a(e eVar) {
        this.ipC = eVar;
    }

    public void a(d dVar) {
        this.ipD = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.ahE = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.ipF = managerElection;
    }
}
