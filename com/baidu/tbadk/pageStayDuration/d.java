package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aHX = false;
    private List<String> aHY;
    private String aHZ;
    private long aIa;
    public String aIb;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> Fu() {
        return this.aHY;
    }

    public void F(List<String> list) {
        this.aHY = list;
    }

    public String getCurrentPageKey() {
        return this.aHZ;
    }

    public void gv(String str) {
        this.aHZ = str;
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

    public long Fv() {
        return this.aIa;
    }

    public void Q(long j) {
        this.aIa = j;
    }

    public boolean Fw() {
        return StringUtils.isNull(this.aHZ) || !this.aHX;
    }
}
