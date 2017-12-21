package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aJk = false;
    private List<String> aJl;
    private String aJm;
    private long aJn;
    public String aJo;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> FT() {
        return this.aJl;
    }

    public void H(List<String> list) {
        this.aJl = list;
    }

    public String getCurrentPageKey() {
        return this.aJm;
    }

    public void gE(String str) {
        this.aJm = str;
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

    public long FU() {
        return this.aJn;
    }

    public void U(long j) {
        this.aJn = j;
    }

    public boolean FV() {
        return StringUtils.isNull(this.aJm);
    }
}
