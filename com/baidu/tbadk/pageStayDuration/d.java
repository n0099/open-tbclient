package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aAP = false;
    private List<String> aAQ;
    private String aAR;
    private long aAS;
    public String aAT;
    private long fid;
    private long pid;
    private long tid;

    public List<String> Fm() {
        return this.aAQ;
    }

    public void D(List<String> list) {
        this.aAQ = list;
    }

    public String getCurrentPageKey() {
        return this.aAR;
    }

    public void gf(String str) {
        this.aAR = str;
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

    public long Fn() {
        return this.aAS;
    }

    public void P(long j) {
        this.aAS = j;
    }

    public boolean Fo() {
        if (StringUtils.isNull(this.aAR)) {
            return true;
        }
        return !this.aAP && this.aAS <= 0;
    }
}
