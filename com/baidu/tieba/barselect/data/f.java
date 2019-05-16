package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    private BdUniqueId Xk;
    private e erj;
    private d erk;
    private List<d> erl;
    private long fid;
    private boolean hasMore;

    public List<d> aWO() {
        return this.erl;
    }

    public d aWP() {
        return this.erk;
    }

    public e aWQ() {
        return this.erj;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.Xk;
    }

    public void L(ArrayList<d> arrayList) {
        this.erl = arrayList;
    }

    public void a(e eVar) {
        this.erj = eVar;
    }

    public void a(d dVar) {
        this.erk = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Xk = bdUniqueId;
    }
}
