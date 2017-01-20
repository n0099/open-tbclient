package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean azH = false;
    private List<String> azI;
    private String azJ;
    private long azK;
    public String azL;
    private long fid;
    private long pid;
    private long tid;

    public List<String> Fg() {
        return this.azI;
    }

    public void B(List<String> list) {
        this.azI = list;
    }

    public String getCurrentPageKey() {
        return this.azJ;
    }

    public void gc(String str) {
        this.azJ = str;
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

    public long Fh() {
        return this.azK;
    }

    public void O(long j) {
        this.azK = j;
    }

    public boolean Fi() {
        if (StringUtils.isNull(this.azJ)) {
            return true;
        }
        return !this.azH && this.azK <= 0;
    }
}
