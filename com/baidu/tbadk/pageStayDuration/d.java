package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aBv = false;
    private List<String> aBw;
    private String aBx;
    private long aBy;
    public String aBz;
    private long fid;
    private long pid;
    private long tid;

    public List<String> FM() {
        return this.aBw;
    }

    public void D(List<String> list) {
        this.aBw = list;
    }

    public String getCurrentPageKey() {
        return this.aBx;
    }

    public void gk(String str) {
        this.aBx = str;
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

    public long FN() {
        return this.aBy;
    }

    public void Q(long j) {
        this.aBy = j;
    }

    public boolean FO() {
        if (StringUtils.isNull(this.aBx)) {
            return true;
        }
        return !this.aBv && this.aBy <= 0;
    }
}
