package com.baidu.tbadk.m;

import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private String cPS;
    private String currentPageKey;
    public String dDw;
    private String dDx;
    public String dDy;
    private long fid;
    public boolean isRouteStat = false;
    public String isVertical;
    public String objID;
    public String objParam1;
    private long pid;
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

    public String aRa() {
        return this.cPS;
    }

    public void vG(String str) {
        this.cPS = str;
    }

    public String aRb() {
        return this.dDx;
    }

    public void vH(String str) {
        this.dDx = str;
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.currentPageKey);
    }
}
