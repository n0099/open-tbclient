package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean bwY = false;
    private List<String> bwZ;
    private String bxa;
    private long bxb;
    public String bxc;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> Ns() {
        return this.bwZ;
    }

    public void Q(List<String> list) {
        this.bwZ = list;
    }

    public String getCurrentPageKey() {
        return this.bxa;
    }

    public void gH(String str) {
        this.bxa = str;
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

    public long Nt() {
        return this.bxb;
    }

    public void ac(long j) {
        this.bxb = j;
    }

    public boolean Nu() {
        return StringUtils.isNull(this.bxa);
    }
}
