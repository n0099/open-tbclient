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
    private e idb;
    private d idc;
    private List<d> idd;
    private ManagerElection ide;

    public List<d> cra() {
        return this.idd;
    }

    public d crb() {
        return this.idc;
    }

    public e crc() {
        return this.idb;
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

    public ManagerElection crd() {
        return this.ide;
    }

    public void ap(ArrayList<d> arrayList) {
        this.idd = arrayList;
    }

    public void a(e eVar) {
        this.idb = eVar;
    }

    public void a(d dVar) {
        this.idc = dVar;
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
        this.ide = managerElection;
    }
}
