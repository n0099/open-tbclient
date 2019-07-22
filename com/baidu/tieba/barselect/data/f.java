package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    private BdUniqueId XE;
    private e ewi;
    private d ewj;
    private List<d> ewk;
    private long fid;
    private boolean hasMore;

    public List<d> aYN() {
        return this.ewk;
    }

    public d aYO() {
        return this.ewj;
    }

    public e aYP() {
        return this.ewi;
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
        this.ewk = arrayList;
    }

    public void a(e eVar) {
        this.ewi = eVar;
    }

    public void a(d dVar) {
        this.ewj = dVar;
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
