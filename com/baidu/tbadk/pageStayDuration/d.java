package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aEZ = false;
    private List<String> aFa;
    private String aFb;
    private long aFc;
    public String aFd;
    private long fid;
    private long pid;
    private long tid;

    public List<String> FA() {
        return this.aFa;
    }

    public void z(List<String> list) {
        this.aFa = list;
    }

    public String getCurrentPageKey() {
        return this.aFb;
    }

    public void fR(String str) {
        this.aFb = str;
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

    public long FB() {
        return this.aFc;
    }

    public void O(long j) {
        this.aFc = j;
    }

    public boolean FC() {
        if (StringUtils.isNull(this.aFb)) {
            return true;
        }
        return !this.aEZ && this.aFc <= 0;
    }
}
