package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aFp = false;
    private List<String> aFq;
    private String aFr;
    private long aFs;
    public String aFt;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> FY() {
        return this.aFq;
    }

    public void z(List<String> list) {
        this.aFq = list;
    }

    public String getCurrentPageKey() {
        return this.aFr;
    }

    public void fX(String str) {
        this.aFr = str;
    }

    public long getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getTid() {
        return this.tid;
    }

    public void setTid(long j) {
        this.tid = j;
    }

    public long getPid() {
        return this.pid;
    }

    public long FZ() {
        return this.aFs;
    }

    public void O(long j) {
        this.aFs = j;
    }

    public boolean Ga() {
        if (StringUtils.isNull(this.aFr)) {
            return true;
        }
        return !this.aFp && this.aFs <= 0;
    }
}
