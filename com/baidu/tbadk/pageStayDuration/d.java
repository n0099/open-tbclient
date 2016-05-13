package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<String> awq;
    private String awr;
    private long aws;
    private long fid;
    private long pid;
    private long tid;

    public List<String> Eh() {
        return this.awq;
    }

    public void C(List<String> list) {
        this.awq = list;
    }

    public String getCurrentPageKey() {
        return this.awr;
    }

    public void fW(String str) {
        this.awr = str;
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

    public long Ei() {
        return this.aws;
    }

    public void P(long j) {
        this.aws = j;
    }

    public boolean Ej() {
        return StringUtils.isNull(this.awr) || this.aws <= 0;
    }
}
