package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aIT = false;
    private List<String> aIU;
    private String aIV;
    private long aIW;
    public String aIX;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> FR() {
        return this.aIU;
    }

    public void G(List<String> list) {
        this.aIU = list;
    }

    public String getCurrentPageKey() {
        return this.aIV;
    }

    public void gz(String str) {
        this.aIV = str;
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
        return this.aIW;
    }

    public void R(long j) {
        this.aIW = j;
    }

    public boolean FT() {
        if (StringUtils.isNull(this.aIV)) {
            return true;
        }
        return !this.aIT && this.aIW <= 0;
    }
}
