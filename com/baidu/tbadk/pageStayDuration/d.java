package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean aIU = false;
    private List<String> aIV;
    private String aIW;
    private long aIX;
    public String aIY;
    private long fid;
    public String objParam1;
    private long pid;
    private long tid;

    public List<String> FR() {
        return this.aIV;
    }

    public void G(List<String> list) {
        this.aIV = list;
    }

    public String getCurrentPageKey() {
        return this.aIW;
    }

    public void gz(String str) {
        this.aIW = str;
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
        return this.aIX;
    }

    public void R(long j) {
        this.aIX = j;
    }

    public boolean FT() {
        if (StringUtils.isNull(this.aIW)) {
            return true;
        }
        return !this.aIU && this.aIX <= 0;
    }
}
