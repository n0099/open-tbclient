package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    private BdUniqueId XE;
    private e ewp;
    private d ewq;
    private List<d> ewr;
    private long fid;
    private boolean hasMore;

    public List<d> aYP() {
        return this.ewr;
    }

    public d aYQ() {
        return this.ewq;
    }

    public e aYR() {
        return this.ewp;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.XE;
    }

    public void L(ArrayList<d> arrayList) {
        this.ewr = arrayList;
    }

    public void a(e eVar) {
        this.ewp = eVar;
    }

    public void a(d dVar) {
        this.ewq = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.XE = bdUniqueId;
    }
}
