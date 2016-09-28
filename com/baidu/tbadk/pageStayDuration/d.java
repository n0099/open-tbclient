package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aAE = false;
    private List<String> aAF;
    private String aAG;
    private long aAH;
    public String aAI;
    private long fid;
    private long pid;
    private long tid;

    public List<String> FI() {
        return this.aAF;
    }

    public void D(List<String> list) {
        this.aAF = list;
    }

    public String getCurrentPageKey() {
        return this.aAG;
    }

    public void gh(String str) {
        this.aAG = str;
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

    public long FJ() {
        return this.aAH;
    }

    public void S(long j) {
        this.aAH = j;
    }

    public boolean FK() {
        if (StringUtils.isNull(this.aAG)) {
            return true;
        }
        return !this.aAE && this.aAH <= 0;
    }
}
