package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aHE = false;
    private List<String> aHF;
    private String aHG;
    private long aHH;
    public String aHI;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> FJ() {
        return this.aHF;
    }

    public void G(List<String> list) {
        this.aHF = list;
    }

    public String getCurrentPageKey() {
        return this.aHG;
    }

    public void gu(String str) {
        this.aHG = str;
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

    public long FK() {
        return this.aHH;
    }

    public void R(long j) {
        this.aHH = j;
    }

    public boolean FL() {
        if (StringUtils.isNull(this.aHG)) {
            return true;
        }
        return !this.aHE && this.aHH <= 0;
    }
}
