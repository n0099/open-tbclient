package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes15.dex */
public class f {
    private BdUniqueId ahM;
    private long fid;
    private boolean hasMore;
    private e hds;
    private d hdt;
    private List<d> hdu;
    private ManagerElection hdv;

    public List<d> caR() {
        return this.hdu;
    }

    public d caS() {
        return this.hdt;
    }

    public e caT() {
        return this.hds;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.ahM;
    }

    public ManagerElection caU() {
        return this.hdv;
    }

    public void ak(ArrayList<d> arrayList) {
        this.hdu = arrayList;
    }

    public void a(e eVar) {
        this.hds = eVar;
    }

    public void a(d dVar) {
        this.hdt = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.ahM = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.hdv = managerElection;
    }
}
