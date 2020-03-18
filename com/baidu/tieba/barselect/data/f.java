package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class f {
    private BdUniqueId MP;
    private e fEv;
    private d fEw;
    private List<d> fEx;
    private long fid;
    private boolean hasMore;

    public List<d> bum() {
        return this.fEx;
    }

    public d bun() {
        return this.fEw;
    }

    public e buo() {
        return this.fEv;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.MP;
    }

    public void ac(ArrayList<d> arrayList) {
        this.fEx = arrayList;
    }

    public void a(e eVar) {
        this.fEv = eVar;
    }

    public void a(d dVar) {
        this.fEw = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.MP = bdUniqueId;
    }
}
