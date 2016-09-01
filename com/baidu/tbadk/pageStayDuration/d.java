package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aBb = false;
    private List<String> aBc;
    private String aBd;
    private long aBe;
    public String aBf;
    private long fid;
    private long pid;
    private long tid;

    public List<String> FJ() {
        return this.aBc;
    }

    public void D(List<String> list) {
        this.aBc = list;
    }

    public String getCurrentPageKey() {
        return this.aBd;
    }

    public void gd(String str) {
        this.aBd = str;
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

    public long FK() {
        return this.aBe;
    }

    public void R(long j) {
        this.aBe = j;
    }

    public boolean FL() {
        if (StringUtils.isNull(this.aBd)) {
            return true;
        }
        return !this.aBb && this.aBe <= 0;
    }
}
