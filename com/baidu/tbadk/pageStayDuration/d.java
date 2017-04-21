package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aFr = false;
    private List<String> aFs;
    private String aFt;
    private long aFu;
    public String aFv;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> FY() {
        return this.aFs;
    }

    public void z(List<String> list) {
        this.aFs = list;
    }

    public String getCurrentPageKey() {
        return this.aFt;
    }

    public void fX(String str) {
        this.aFt = str;
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
        return this.aFu;
    }

    public void O(long j) {
        this.aFu = j;
    }

    public boolean Ga() {
        if (StringUtils.isNull(this.aFt)) {
            return true;
        }
        return !this.aFr && this.aFu <= 0;
    }
}
