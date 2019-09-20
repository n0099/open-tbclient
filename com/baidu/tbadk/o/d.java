package com.baidu.tbadk.o;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean cAj = false;
    private List<String> cAk;
    private String cAl;
    private long cAm;
    public String cAn;
    public String cAo;
    public String cAp;
    private String cAq;
    private long fid;
    public String objParam1;
    private long pid;
    public String task_id;
    private long tid;

    public List<String> avj() {
        return this.cAk;
    }

    public void ao(List<String> list) {
        this.cAk = list;
    }

    public String getCurrentPageKey() {
        return this.cAl;
    }

    public void re(String str) {
        this.cAl = str;
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

    public long avk() {
        return this.cAm;
    }

    public void bl(long j) {
        this.cAm = j;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public String avl() {
        return this.cAq;
    }

    public void rf(String str) {
        this.cAq = str;
    }

    public boolean avm() {
        return StringUtils.isNull(this.cAl);
    }
}
