package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean bzn = false;
    private List<String> bzo;
    private String bzp;
    private long bzq;
    public String bzr;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> NO() {
        return this.bzo;
    }

    public void Q(List<String> list) {
        this.bzo = list;
    }

    public String getCurrentPageKey() {
        return this.bzp;
    }

    public void gZ(String str) {
        this.bzp = str;
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

    public long NP() {
        return this.bzq;
    }

    public void ac(long j) {
        this.bzq = j;
    }

    public boolean NQ() {
        return StringUtils.isNull(this.bzp);
    }
}
