package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class f {
    private BdUniqueId Mh;
    private long fid;
    private e fxP;
    private d fxQ;
    private List<d> fxR;
    private boolean hasMore;

    public List<d> bry() {
        return this.fxR;
    }

    public d brz() {
        return this.fxQ;
    }

    public e brA() {
        return this.fxP;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.Mh;
    }

    public void ab(ArrayList<d> arrayList) {
        this.fxR = arrayList;
    }

    public void a(e eVar) {
        this.fxP = eVar;
    }

    public void a(d dVar) {
        this.fxQ = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Mh = bdUniqueId;
    }
}
