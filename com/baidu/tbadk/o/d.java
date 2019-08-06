package com.baidu.tbadk.o;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean czn = false;
    private List<String> czo;
    private String czp;
    private long czq;
    public String czr;
    public String czs;
    public String czt;
    private String czu;
    private long fid;
    public String objParam1;
    private long pid;
    public String task_id;
    private long tid;

    public List<String> auX() {
        return this.czo;
    }

    public void ao(List<String> list) {
        this.czo = list;
    }

    public String getCurrentPageKey() {
        return this.czp;
    }

    public void qT(String str) {
        this.czp = str;
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

    public long auY() {
        return this.czq;
    }

    public void bi(long j) {
        this.czq = j;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public String auZ() {
        return this.czu;
    }

    public void qU(String str) {
        this.czu = str;
    }

    public boolean ava() {
        return StringUtils.isNull(this.czp);
    }
}
