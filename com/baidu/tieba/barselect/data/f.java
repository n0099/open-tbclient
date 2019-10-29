package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    private BdUniqueId Hx;
    private e eGI;
    private d eGJ;
    private List<d> eGK;
    private long fid;
    private boolean hasMore;

    public List<d> aZw() {
        return this.eGK;
    }

    public d aZx() {
        return this.eGJ;
    }

    public e aZy() {
        return this.eGI;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.Hx;
    }

    public void Q(ArrayList<d> arrayList) {
        this.eGK = arrayList;
    }

    public void a(e eVar) {
        this.eGI = eVar;
    }

    public void a(d dVar) {
        this.eGJ = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.Hx = bdUniqueId;
    }
}
