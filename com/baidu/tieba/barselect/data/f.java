package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class f {
    private BdUniqueId MO;
    private List<d> fDA;
    private e fDy;
    private d fDz;
    private long fid;
    private boolean hasMore;

    public List<d> bue() {
        return this.fDA;
    }

    public d buf() {
        return this.fDz;
    }

    public e bug() {
        return this.fDy;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.MO;
    }

    public void ac(ArrayList<d> arrayList) {
        this.fDA = arrayList;
    }

    public void a(e eVar) {
        this.fDy = eVar;
    }

    public void a(d dVar) {
        this.fDz = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.MO = bdUniqueId;
    }
}
