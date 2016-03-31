package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<String> aAn;
    private String aAo;
    private long aAp;
    private long fid;
    private long pid;
    private long tid;

    public List<String> Go() {
        return this.aAn;
    }

    public void A(List<String> list) {
        this.aAn = list;
    }

    public String getCurrentPageKey() {
        return this.aAo;
    }

    public void fZ(String str) {
        this.aAo = str;
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
        return this.aAp;
    }

    public void O(long j) {
        this.aAp = j;
    }

    public boolean Gq() {
        return StringUtils.isNull(this.aAo) || this.aAp <= 0;
    }
}
