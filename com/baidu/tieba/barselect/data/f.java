package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    private BdUniqueId XD;
    private e exZ;
    private d eya;
    private List<d> eyb;
    private long fid;
    private boolean hasMore;

    public List<d> aZt() {
        return this.eyb;
    }

    public d aZu() {
        return this.eya;
    }

    public e aZv() {
        return this.exZ;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getFid() {
        return this.fid;
    }

    public BdUniqueId getUniqueId() {
        return this.XD;
    }

    public void L(ArrayList<d> arrayList) {
        this.eyb = arrayList;
    }

    public void a(e eVar) {
        this.exZ = eVar;
    }

    public void a(d dVar) {
        this.eya = dVar;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.XD = bdUniqueId;
    }
}
