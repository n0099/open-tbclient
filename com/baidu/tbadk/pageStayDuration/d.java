package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean bfX = false;
    private List<String> bfY;
    private String bfZ;
    private long bga;
    public String bgb;
    public String bgc;
    private long fid;
    public String objParam1;
    private long pid;
    public String task_id;
    private long tid;

    public List<String> Ph() {
        return this.bfY;
    }

    public void V(List<String> list) {
        this.bfY = list;
    }

    public String getCurrentPageKey() {
        return this.bfZ;
    }

    public void iF(String str) {
        this.bfZ = str;
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
        return this.bga;
    }

    public void aq(long j) {
        this.bga = j;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public boolean Pj() {
        return StringUtils.isNull(this.bfZ);
    }
}
