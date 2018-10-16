package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean baW = false;
    private List<String> baX;
    private String baY;
    private long baZ;
    public String bba;
    public String bbb;
    private long fid;
    public String objParam1;
    private long pid;
    public String task_id;
    private long tid;

    public List<String> NB() {
        return this.baX;
    }

    public void V(List<String> list) {
        this.baX = list;
    }

    public String getCurrentPageKey() {
        return this.baY;
    }

    public void hX(String str) {
        this.baY = str;
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

    public long NC() {
        return this.baZ;
    }

    public void ag(long j) {
        this.baZ = j;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public boolean ND() {
        return StringUtils.isNull(this.baY);
    }
}
