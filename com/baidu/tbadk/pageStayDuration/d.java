package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aIC = false;
    private List<String> aID;
    private String aIE;
    private long aIF;
    public String aIG;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> FL() {
        return this.aID;
    }

    public void G(List<String> list) {
        this.aID = list;
    }

    public String getCurrentPageKey() {
        return this.aIE;
    }

    public void gC(String str) {
        this.aIE = str;
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

    public long FM() {
        return this.aIF;
    }

    public void R(long j) {
        this.aIF = j;
    }

    public boolean FN() {
        return StringUtils.isNull(this.aIE);
    }
}
