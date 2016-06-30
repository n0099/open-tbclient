package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<String> axg;
    private String axh;
    private long axi;
    private long fid;
    private long pid;
    private long tid;

    public List<String> Eq() {
        return this.axg;
    }

    public void D(List<String> list) {
        this.axg = list;
    }

    public String getCurrentPageKey() {
        return this.axh;
    }

    public void gc(String str) {
        this.axh = str;
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

    public long Er() {
        return this.axi;
    }

    public void S(long j) {
        this.axi = j;
    }

    public boolean Es() {
        return StringUtils.isNull(this.axh) || this.axi <= 0;
    }
}
