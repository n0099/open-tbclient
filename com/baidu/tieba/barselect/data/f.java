package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes7.dex */
public class f {
    private BdUniqueId ahU;
    private long fid;
    private boolean hasMore;
    private List<d> isA;
    private ManagerElection isB;
    private e isy;
    private d isz;

    public List<d> crA() {
        return this.isA;
    }

    public d crB() {
        return this.isz;
    }

    public e crC() {
        return this.isy;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.ahU;
    }

    public ManagerElection crD() {
        return this.isB;
    }

    public void aj(ArrayList<d> arrayList) {
        this.isA = arrayList;
    }

    public void a(e eVar) {
        this.isy = eVar;
    }

    public void a(d dVar) {
        this.isz = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.ahU = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.isB = managerElection;
    }
}
