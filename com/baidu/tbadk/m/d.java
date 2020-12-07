package com.baidu.tbadk.m;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private String abTag;
    private String currentPageKey;
    public String fBB;
    private String fBC;
    public String fBD;
    private long fid;
    public boolean isRouteStat = false;
    public String isVertical;
    private com.baidu.tbadk.pageExtra.c mTbPageExtra;
    private String nid;
    public String objID;
    public String objParam1;
    private long pid;
    public String resourceId;
    private List<String> sorceKeyList;
    private long stayDurationTime;
    public String task_id;
    private long tid;

    public com.baidu.tbadk.pageExtra.c getTbPageExtra() {
        return this.mTbPageExtra;
    }

    public void b(com.baidu.tbadk.pageExtra.c cVar) {
        this.mTbPageExtra = cVar;
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

    public String bEX() {
        return this.abTag;
    }

    public void Eu(String str) {
        this.abTag = str;
    }

    public String bEY() {
        return this.fBC;
    }

    public void Ev(String str) {
        this.fBC = str;
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.currentPageKey);
    }
}
