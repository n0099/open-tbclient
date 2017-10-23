package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aHK = false;
    private List<String> aHL;
    private String aHM;
    private long aHN;
    public String aHO;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> Fo() {
        return this.aHL;
    }

    public void F(List<String> list) {
        this.aHL = list;
    }

    public String getCurrentPageKey() {
        return this.aHM;
    }

    public void gu(String str) {
        this.aHM = str;
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

    public long Fp() {
        return this.aHN;
    }

    public void R(long j) {
        this.aHN = j;
    }

    public boolean Fq() {
        return StringUtils.isNull(this.aHM);
    }
}
