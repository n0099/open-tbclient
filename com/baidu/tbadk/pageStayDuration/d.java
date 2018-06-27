package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aTh = false;
    private List<String> aTi;
    private String aTj;
    private long aTk;
    public String aTl;
    public String aTm;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> Ko() {
        return this.aTi;
    }

    public void M(List<String> list) {
        this.aTi = list;
    }

    public String getCurrentPageKey() {
        return this.aTj;
    }

    public void hq(String str) {
        this.aTj = str;
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

    public long Kp() {
        return this.aTk;
    }

    public void Y(long j) {
        this.aTk = j;
    }

    public boolean Kq() {
        return StringUtils.isNull(this.aTj);
    }
}
