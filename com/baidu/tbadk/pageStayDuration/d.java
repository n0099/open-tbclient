package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aIV = false;
    private List<String> aIW;
    private String aIX;
    private long aIY;
    public String aIZ;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> FR() {
        return this.aIW;
    }

    public void G(List<String> list) {
        this.aIW = list;
    }

    public String getCurrentPageKey() {
        return this.aIX;
    }

    public void gC(String str) {
        this.aIX = str;
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

    public long FS() {
        return this.aIY;
    }

    public void R(long j) {
        this.aIY = j;
    }

    public boolean FT() {
        if (StringUtils.isNull(this.aIX)) {
            return true;
        }
        return !this.aIV && this.aIY <= 0;
    }
}
