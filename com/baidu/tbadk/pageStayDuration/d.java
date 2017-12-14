package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aJh = false;
    private List<String> aJi;
    private String aJj;
    private long aJk;
    public String aJl;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> FT() {
        return this.aJi;
    }

    public void H(List<String> list) {
        this.aJi = list;
    }

    public String getCurrentPageKey() {
        return this.aJj;
    }

    public void gE(String str) {
        this.aJj = str;
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
        return this.aJk;
    }

    public void U(long j) {
        this.aJk = j;
    }

    public boolean FV() {
        return StringUtils.isNull(this.aJj);
    }
}
