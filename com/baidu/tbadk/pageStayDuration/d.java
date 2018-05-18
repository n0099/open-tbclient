package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aJK = false;
    private List<String> aJL;
    private String aJM;
    private long aJN;
    public String aJO;
    public String aJP;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> Go() {
        return this.aJL;
    }

    public void I(List<String> list) {
        this.aJL = list;
    }

    public String getCurrentPageKey() {
        return this.aJM;
    }

    public void gO(String str) {
        this.aJM = str;
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

    public long Gp() {
        return this.aJN;
    }

    public void U(long j) {
        this.aJN = j;
    }

    public boolean Gq() {
        return StringUtils.isNull(this.aJM);
    }
}
