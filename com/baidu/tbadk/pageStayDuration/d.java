package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aFi = false;
    private List<String> aFj;
    private String aFk;
    private long aFl;
    public String aFm;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> EW() {
        return this.aFj;
    }

    public void A(List<String> list) {
        this.aFj = list;
    }

    public String getCurrentPageKey() {
        return this.aFk;
    }

    public void fT(String str) {
        this.aFk = str;
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

    public long EX() {
        return this.aFl;
    }

    public void P(long j) {
        this.aFl = j;
    }

    public boolean EY() {
        if (StringUtils.isNull(this.aFk)) {
            return true;
        }
        return !this.aFi && this.aFl <= 0;
    }
}
