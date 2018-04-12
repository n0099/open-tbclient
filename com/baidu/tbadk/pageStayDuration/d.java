package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aJJ = false;
    private List<String> aJK;
    private String aJL;
    private long aJM;
    public String aJN;
    public String aJO;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> Gq() {
        return this.aJK;
    }

    public void I(List<String> list) {
        this.aJK = list;
    }

    public String getCurrentPageKey() {
        return this.aJL;
    }

    public void gO(String str) {
        this.aJL = str;
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

    public long Gr() {
        return this.aJM;
    }

    public void U(long j) {
        this.aJM = j;
    }

    public boolean Gs() {
        return StringUtils.isNull(this.aJL);
    }
}
