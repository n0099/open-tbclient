package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aSl = false;
    private List<String> aSm;
    private String aSn;
    private long aSo;
    public String aSp;
    public String aSq;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> JW() {
        return this.aSm;
    }

    public void L(List<String> list) {
        this.aSm = list;
    }

    public String getCurrentPageKey() {
        return this.aSn;
    }

    public void hm(String str) {
        this.aSn = str;
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

    public long JX() {
        return this.aSo;
    }

    public void X(long j) {
        this.aSo = j;
    }

    public boolean JY() {
        return StringUtils.isNull(this.aSn);
    }
}
