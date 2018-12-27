package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean bfm = false;
    private List<String> bfn;
    private String bfo;
    private long bfp;
    public String bfq;
    public String bfr;
    private long fid;
    public String objParam1;
    private long pid;
    public String task_id;
    private long tid;

    public List<String> OP() {
        return this.bfn;
    }

    public void U(List<String> list) {
        this.bfn = list;
    }

    public String getCurrentPageKey() {
        return this.bfo;
    }

    public void ir(String str) {
        this.bfo = str;
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

    public long OQ() {
        return this.bfp;
    }

    public void aq(long j) {
        this.bfp = j;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public boolean OR() {
        return StringUtils.isNull(this.bfo);
    }
}
