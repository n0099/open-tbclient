package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean bbJ = false;
    private List<String> bbK;
    private String bbL;
    private long bbM;
    public String bbN;
    public String bbO;
    private long fid;
    public String objParam1;
    private long pid;
    public String task_id;
    private long tid;

    public List<String> NK() {
        return this.bbK;
    }

    public void U(List<String> list) {
        this.bbK = list;
    }

    public String getCurrentPageKey() {
        return this.bbL;
    }

    public void hY(String str) {
        this.bbL = str;
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

    public long NL() {
        return this.bbM;
    }

    public void ai(long j) {
        this.bbM = j;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public boolean NM() {
        return StringUtils.isNull(this.bbL);
    }
}
