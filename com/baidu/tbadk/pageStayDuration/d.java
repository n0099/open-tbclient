package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aJd = false;
    private List<String> aJe;
    private String aJf;
    private long aJg;
    public String aJh;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> FS() {
        return this.aJe;
    }

    public void H(List<String> list) {
        this.aJe = list;
    }

    public String getCurrentPageKey() {
        return this.aJf;
    }

    public void gF(String str) {
        this.aJf = str;
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

    public long FT() {
        return this.aJg;
    }

    public void U(long j) {
        this.aJg = j;
    }

    public boolean FU() {
        return StringUtils.isNull(this.aJf);
    }
}
