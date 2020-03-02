package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class f {
    private BdUniqueId MO;
    private e fDA;
    private d fDB;
    private List<d> fDC;
    private long fid;
    private boolean hasMore;

    public List<d> bug() {
        return this.fDC;
    }

    public d buh() {
        return this.fDB;
    }

    public e bui() {
        return this.fDA;
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
        this.fDC = arrayList;
    }

    public void a(e eVar) {
        this.fDA = eVar;
    }

    public void a(d dVar) {
        this.fDB = dVar;
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
