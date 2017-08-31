package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private List<String> aIA;
    private String aIB;
    private long aIC;
    public String aID;
    public boolean aIz = false;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> FP() {
        return this.aIA;
    }

    public void G(List<String> list) {
        this.aIA = list;
    }

    public String getCurrentPageKey() {
        return this.aIB;
    }

    public void gy(String str) {
        this.aIB = str;
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

    public long FQ() {
        return this.aIC;
    }

    public void Q(long j) {
        this.aIC = j;
    }

    public boolean FR() {
        if (StringUtils.isNull(this.aIB)) {
            return true;
        }
        return !this.aIz && this.aIC <= 0;
    }
}
