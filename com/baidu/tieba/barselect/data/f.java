package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    private BdUniqueId Xk;
    private e erk;
    private d erl;
    private List<d> erm;
    private long fid;
    private boolean hasMore;

    public List<d> aWR() {
        return this.erm;
    }

    public d aWS() {
        return this.erl;
    }

    public e aWT() {
        return this.erk;
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
        this.erm = arrayList;
    }

    public void a(e eVar) {
        this.erk = eVar;
    }

    public void a(d dVar) {
        this.erl = dVar;
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
