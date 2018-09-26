package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public String aWA;
    public String aWB;
    public boolean aWw = false;
    private List<String> aWx;
    private String aWy;
    private long aWz;
    private long fid;
    public String objParam1;
    private long pid;
    public String task_id;
    private long tid;

    public List<String> LD() {
        return this.aWx;
    }

    public void M(List<String> list) {
        this.aWx = list;
    }

    public String getCurrentPageKey() {
        return this.aWy;
    }

    public void hJ(String str) {
        this.aWy = str;
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

    public long LE() {
        return this.aWz;
    }

    public void ae(long j) {
        this.aWz = j;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public boolean LF() {
        return StringUtils.isNull(this.aWy);
    }
}
