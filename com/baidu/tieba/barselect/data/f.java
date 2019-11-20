package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    private BdUniqueId GX;
    private e eFR;
    private d eFS;
    private List<d> eFT;
    private long fid;
    private boolean hasMore;

    public List<d> aZu() {
        return this.eFT;
    }

    public d aZv() {
        return this.eFS;
    }

    public e aZw() {
        return this.eFR;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.GX;
    }

    public void Q(ArrayList<d> arrayList) {
        this.eFT = arrayList;
    }

    public void a(e eVar) {
        this.eFR = eVar;
    }

    public void a(d dVar) {
        this.eFS = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.GX = bdUniqueId;
    }
}
