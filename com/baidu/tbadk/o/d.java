package com.baidu.tbadk.o;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean cxR = false;
    private List<String> cxS;
    private String cxT;
    private long cxU;
    public String cxV;
    public String cxW;
    public String cxX;
    private long fid;
    public String objParam1;
    private long pid;
    public String task_id;
    private long tid;

    public List<String> atN() {
        return this.cxS;
    }

    public void ao(List<String> list) {
        this.cxS = list;
    }

    public String getCurrentPageKey() {
        return this.cxT;
    }

    public void qC(String str) {
        this.cxT = str;
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

    public long atO() {
        return this.cxU;
    }

    public void bh(long j) {
        this.cxU = j;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public boolean atP() {
        return StringUtils.isNull(this.cxT);
    }
}
