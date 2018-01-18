package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean bxh = false;
    private List<String> bxi;
    private String bxj;
    private long bxk;
    public String bxl;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> Ng() {
        return this.bxi;
    }

    public void O(List<String> list) {
        this.bxi = list;
    }

    public String getCurrentPageKey() {
        return this.bxj;
    }

    public void gI(String str) {
        this.bxj = str;
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

    public long Nh() {
        return this.bxk;
    }

    public void ac(long j) {
        this.bxk = j;
    }

    public boolean Ni() {
        return StringUtils.isNull(this.bxj);
    }
}
