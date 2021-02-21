package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes8.dex */
public class f {
    private BdUniqueId agC;
    private long fid;
    private boolean hasMore;
    private e iqP;
    private d iqQ;
    private List<d> iqR;
    private ManagerElection iqS;

    public List<d> cru() {
        return this.iqR;
    }

    public d crv() {
        return this.iqQ;
    }

    public e crw() {
        return this.iqP;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.agC;
    }

    public ManagerElection crx() {
        return this.iqS;
    }

    public void aj(ArrayList<d> arrayList) {
        this.iqR = arrayList;
    }

    public void a(e eVar) {
        this.iqP = eVar;
    }

    public void a(d dVar) {
        this.iqQ = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.agC = bdUniqueId;
    }

    public void a(ManagerElection managerElection) {
        this.iqS = managerElection;
    }
}
