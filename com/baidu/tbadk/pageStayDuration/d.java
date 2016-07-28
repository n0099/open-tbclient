package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean axU = false;
    private List<String> axV;
    private String axW;
    private long axX;
    public String axY;
    private long fid;
    private long pid;
    private long tid;

    public List<String> Ep() {
        return this.axV;
    }

    public void D(List<String> list) {
        this.axV = list;
    }

    public String getCurrentPageKey() {
        return this.axW;
    }

    public void ga(String str) {
        this.axW = str;
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

    public long Eq() {
        return this.axX;
    }

    public void N(long j) {
        this.axX = j;
    }

    public boolean Er() {
        if (StringUtils.isNull(this.axW)) {
            return true;
        }
        return !this.axU && this.axX <= 0;
    }
}
