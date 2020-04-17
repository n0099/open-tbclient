package com.baidu.tbadk.m;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private String currentPageKey;
    private String doY;
    public String edd;
    private String ede;
    public String edf;
    private long fid;
    public boolean isRouteStat = false;
    public String isVertical;
    public String objID;
    public String objParam1;
    private long pid;
    public String resourceId;
    private List<String> sorceKeyList;
    private long stayDurationTime;
    public String task_id;
    private long tid;

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

    public long getPid() {
        return this.pid;
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

    public String aZk() {
        return this.doY;
    }

    public void wV(String str) {
        this.doY = str;
    }

    public String aZl() {
        return this.ede;
    }

    public void wW(String str) {
        this.ede = str;
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.currentPageKey);
    }
}
