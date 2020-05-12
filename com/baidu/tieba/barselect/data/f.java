package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes8.dex */
public class f {
    private BdUniqueId afD;
    private long fid;
    private e gjf;
    private d gjg;
    private List<d> gjh;
    private ManagerElection gji;
    private boolean hasMore;

    public List<d> bDV() {
        return this.gjh;
    }

    public d bDW() {
        return this.gjg;
    }

    public e bDX() {
        return this.gjf;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.afD;
    }

    public ManagerElection bDY() {
        return this.gji;
    }

    public void ad(ArrayList<d> arrayList) {
        this.gjh = arrayList;
    }

    public void a(e eVar) {
        this.gjf = eVar;
    }

    public void a(d dVar) {
        this.gjg = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.afD = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.gji = managerElection;
    }
}
