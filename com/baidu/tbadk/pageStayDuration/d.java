package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public String aIA;
    public boolean aIw = false;
    private List<String> aIx;
    private String aIy;
    private long aIz;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> FP() {
        return this.aIx;
    }

    public void G(List<String> list) {
        this.aIx = list;
    }

    public String getCurrentPageKey() {
        return this.aIy;
    }

    public void gy(String str) {
        this.aIy = str;
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

    public long FQ() {
        return this.aIz;
    }

    public void Q(long j) {
        this.aIz = j;
    }

    public boolean FR() {
        if (StringUtils.isNull(this.aIy)) {
            return true;
        }
        return !this.aIw && this.aIz <= 0;
    }
}
