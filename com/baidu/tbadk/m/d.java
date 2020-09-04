package com.baidu.tbadk.m;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private String abTag;
    private String currentPageKey;
    public String eRm;
    private String eRn;
    public String eRo;
    private long fid;
    public boolean isRouteStat = false;
    public String isVertical;
    private com.baidu.tbadk.l.b mTbPageExtra;
    private String nid;
    public String objID;
    public String objParam1;
    private long pid;
    public String resourceId;
    private List<String> sorceKeyList;
    private long stayDurationTime;
    public String task_id;
    private long tid;

    public com.baidu.tbadk.l.b getTbPageExtra() {
        return this.mTbPageExtra;
    }

    public void b(com.baidu.tbadk.l.b bVar) {
        this.mTbPageExtra = bVar;
    }

    public List<String> getSorceKeyList() {
        return this.sorceKeyList;
    }

    public void setSorceKeyList(List<String> list) {
        this.sorceKeyList = list;
    }

    public String getCurrentPageKey() {
        return this.currentPageKey;
    }

    public void setCurrentPageKey(String str) {
        this.currentPageKey = str;
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

    public String getNid() {
        return this.nid;
    }

    public void setNid(String str) {
        this.nid = str;
    }

    public long getPid() {
        return this.pid;
    }

    public void setPid(long j) {
        this.pid = j;
    }

    public long getStayDurationTime() {
        return this.stayDurationTime;
    }

    public void setStayDurationTime(long j) {
        this.stayDurationTime = j;
    }

    public void setTaskId(String str) {
        this.task_id = str;
    }

    public String getTaskId() {
        return this.task_id;
    }

    public String btY() {
        return this.abTag;
    }

    public void Cv(String str) {
        this.abTag = str;
    }

    public String btZ() {
        return this.eRn;
    }

    public void Cw(String str) {
        this.eRn = str;
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.currentPageKey);
    }
}
