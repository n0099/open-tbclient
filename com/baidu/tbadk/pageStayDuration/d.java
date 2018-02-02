package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean bxq = false;
    private List<String> bxr;
    private String bxs;
    private long bxt;
    public String bxu;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> Ni() {
        return this.bxr;
    }

    public void O(List<String> list) {
        this.bxr = list;
    }

    public String getCurrentPageKey() {
        return this.bxs;
    }

    public void gQ(String str) {
        this.bxs = str;
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

    public long Nj() {
        return this.bxt;
    }

    public void ac(long j) {
        this.bxt = j;
    }

    public boolean Nk() {
        return StringUtils.isNull(this.bxs);
    }
}
