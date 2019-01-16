package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean bfW = false;
    private List<String> bfX;
    private String bfY;
    private long bfZ;
    public String bga;
    public String bgb;
    private long fid;
    public String objParam1;
    private long pid;
    public String task_id;
    private long tid;

    public List<String> Ph() {
        return this.bfX;
    }

    public void V(List<String> list) {
        this.bfX = list;
    }

    public String getCurrentPageKey() {
        return this.bfY;
    }

    public void iF(String str) {
        this.bfY = str;
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

    public long Pi() {
        return this.bfZ;
    }

    public void aq(long j) {
        this.bfZ = j;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public boolean Pj() {
        return StringUtils.isNull(this.bfY);
    }
}
