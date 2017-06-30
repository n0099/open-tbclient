package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public String aGA;
    public boolean aGw = false;
    private List<String> aGx;
    private String aGy;
    private long aGz;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> Ft() {
        return this.aGx;
    }

    public void C(List<String> list) {
        this.aGx = list;
    }

    public String getCurrentPageKey() {
        return this.aGy;
    }

    public void go(String str) {
        this.aGy = str;
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

    public long Fu() {
        return this.aGz;
    }

    public void Q(long j) {
        this.aGz = j;
    }

    public boolean Fv() {
        if (StringUtils.isNull(this.aGy)) {
            return true;
        }
        return !this.aGw && this.aGz <= 0;
    }
}
