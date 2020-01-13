package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f {
    private BdUniqueId Mm;
    private e fBa;
    private d fBb;
    private List<d> fBc;
    private long fid;
    private boolean hasMore;

    public List<d> bsA() {
        return this.fBc;
    }

    public d bsB() {
        return this.fBb;
    }

    public e bsC() {
        return this.fBa;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.Mm;
    }

    public void ab(ArrayList<d> arrayList) {
        this.fBc = arrayList;
    }

    public void a(e eVar) {
        this.fBa = eVar;
    }

    public void a(d dVar) {
        this.fBb = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Mm = bdUniqueId;
    }
}
