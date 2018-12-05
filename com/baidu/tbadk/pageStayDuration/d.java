package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean bfj = false;
    private List<String> bfk;
    private String bfl;
    private long bfm;
    public String bfn;
    public String bfo;
    private long fid;
    public String objParam1;
    private long pid;
    public String task_id;
    private long tid;

    public List<String> OO() {
        return this.bfk;
    }

    public void U(List<String> list) {
        this.bfk = list;
    }

    public String getCurrentPageKey() {
        return this.bfl;
    }

    public void iq(String str) {
        this.bfl = str;
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

    public long OP() {
        return this.bfm;
    }

    public void ap(long j) {
        this.bfm = j;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public boolean OQ() {
        return StringUtils.isNull(this.bfl);
    }
}
