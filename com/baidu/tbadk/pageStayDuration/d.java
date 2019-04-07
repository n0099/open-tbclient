package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean cpJ = false;
    private List<String> cpK;
    private String cpL;
    private long cpM;
    public String cpN;
    public String cpO;
    public String cpP;
    private long fid;
    public String objParam1;
    private long pid;
    public String task_id;
    private long tid;

    public List<String> aoJ() {
        return this.cpK;
    }

    public void ah(List<String> list) {
        this.cpK = list;
    }

    public String getCurrentPageKey() {
        return this.cpL;
    }

    public void pu(String str) {
        this.cpL = str;
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

    public long aoK() {
        return this.cpM;
    }

    public void aS(long j) {
        this.cpM = j;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public boolean aoL() {
        return StringUtils.isNull(this.cpL);
    }
}
