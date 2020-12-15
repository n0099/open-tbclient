package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes21.dex */
public class f {
    private BdUniqueId ajD;
    private long fid;
    private boolean hasMore;
    private e idd;
    private d ide;
    private List<d> idf;
    private ManagerElection idg;

    public List<d> crb() {
        return this.idf;
    }

    public d crc() {
        return this.ide;
    }

    public e crd() {
        return this.idd;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.ajD;
    }

    public ManagerElection cre() {
        return this.idg;
    }

    public void ap(ArrayList<d> arrayList) {
        this.idf = arrayList;
    }

    public void a(e eVar) {
        this.idd = eVar;
    }

    public void a(d dVar) {
        this.ide = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.ajD = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.idg = managerElection;
    }
}
