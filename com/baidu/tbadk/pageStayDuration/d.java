package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private long bzA;
    public String bzB;
    public boolean bzx = false;
    private List<String> bzy;
    private String bzz;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> NO() {
        return this.bzy;
    }

    public void Q(List<String> list) {
        this.bzy = list;
    }

    public String getCurrentPageKey() {
        return this.bzz;
    }

    public void gZ(String str) {
        this.bzz = str;
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
        return this.bzA;
    }

    public void ac(long j) {
        this.bzA = j;
    }

    public boolean NQ() {
        return StringUtils.isNull(this.bzz);
    }
}
