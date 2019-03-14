package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean cpH = false;
    private List<String> cpI;
    private String cpJ;
    private long cpK;
    public String cpL;
    public String cpM;
    public String cpN;
    private long fid;
    public String objParam1;
    private long pid;
    public String task_id;
    private long tid;

    public List<String> aoM() {
        return this.cpI;
    }

    public void ah(List<String> list) {
        this.cpI = list;
    }

    public String getCurrentPageKey() {
        return this.cpJ;
    }

    public void pt(String str) {
        this.cpJ = str;
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

    public long aoN() {
        return this.cpK;
    }

    public void aS(long j) {
        this.cpK = j;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public boolean aoO() {
        return StringUtils.isNull(this.cpJ);
    }
}
