package com.baidu.tieba.barselect.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class f {
    private BdUniqueId MO;
    private e fDN;
    private d fDO;
    private List<d> fDP;
    private long fid;
    private boolean hasMore;

    public List<d> buh() {
        return this.fDP;
    }

    public d bui() {
        return this.fDO;
    }

    public e buj() {
        return this.fDN;
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
        this.fDP = arrayList;
    }

    public void a(e eVar) {
        this.fDN = eVar;
    }

    public void a(d dVar) {
        this.fDO = dVar;
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
