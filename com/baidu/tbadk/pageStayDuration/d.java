package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean bzk = false;
    private List<String> bzl;
    private String bzm;
    private long bzn;
    public String bzo;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> NN() {
        return this.bzl;
    }

    public void Q(List<String> list) {
        this.bzl = list;
    }

    public String getCurrentPageKey() {
        return this.bzm;
    }

    public void gZ(String str) {
        this.bzm = str;
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

    public long NO() {
        return this.bzn;
    }

    public void ac(long j) {
        this.bzn = j;
    }

    public boolean NP() {
        return StringUtils.isNull(this.bzm);
    }
}
