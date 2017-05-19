package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aFv = false;
    private List<String> aFw;
    private String aFx;
    private long aFy;
    public String aFz;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> Fc() {
        return this.aFw;
    }

    public void A(List<String> list) {
        this.aFw = list;
    }

    public String getCurrentPageKey() {
        return this.aFx;
    }

    public void fU(String str) {
        this.aFx = str;
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

    public long Fd() {
        return this.aFy;
    }

    public void P(long j) {
        this.aFy = j;
    }

    public boolean Fe() {
        if (StringUtils.isNull(this.aFx)) {
            return true;
        }
        return !this.aFv && this.aFy <= 0;
    }
}
