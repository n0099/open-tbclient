package com.baidu.tbadk.o;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public boolean czg = false;
    private List<String> czh;
    private String czi;
    private long czj;
    public String czk;
    public String czl;
    public String czm;
    private String czn;
    private long fid;
    public String objParam1;
    private long pid;
    public String task_id;
    private long tid;

    public List<String> auV() {
        return this.czh;
    }

    public void ao(List<String> list) {
        this.czh = list;
    }

    public String getCurrentPageKey() {
        return this.czi;
    }

    public void qT(String str) {
        this.czi = str;
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

    public long auW() {
        return this.czj;
    }

    public void bi(long j) {
        this.czj = j;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public String auX() {
        return this.czn;
    }

    public void qU(String str) {
        this.czn = str;
    }

    public boolean auY() {
        return StringUtils.isNull(this.czi);
    }
}
