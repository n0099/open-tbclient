package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aIu = false;
    private List<String> aIv;
    private String aIw;
    private long aIx;
    public String aIy;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> FA() {
        return this.aIv;
    }

    public void G(List<String> list) {
        this.aIv = list;
    }

    public String getCurrentPageKey() {
        return this.aIw;
    }

    public void gB(String str) {
        this.aIw = str;
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

    public long FB() {
        return this.aIx;
    }

    public void R(long j) {
        this.aIx = j;
    }

    public boolean FC() {
        return StringUtils.isNull(this.aIw);
    }
}
