package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object XJ;
    private List<m> cRA;
    private List<Object> cRB;
    private boolean cRC;
    private boolean cRD;
    private boolean cRE;
    private String cRF;
    private String cRG;
    private String cRH;
    private List<m> cRz;
    private int cdS;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.cRC = false;
        this.cRD = false;
        this.currentPage = 0;
        this.cRE = false;
    }

    public Object qV() {
        return this.XJ;
    }

    public void setExtraData(Object obj) {
        this.XJ = obj;
    }

    public List<m> getThreadList() {
        return this.cRz;
    }

    public void av(List<m> list) {
        this.cRz = list;
    }

    public List<Object> aAK() {
        return this.cRB;
    }

    public void aw(List<Object> list) {
        this.cRB = list;
    }

    public List<m> aAL() {
        return this.cRA;
    }

    public void ax(List<m> list) {
        this.cRA = list;
    }

    public boolean aAM() {
        return this.cRC;
    }

    public void gb(boolean z) {
        this.cRC = z;
    }

    public boolean isRefresh() {
        return this.cRD;
    }

    public void gc(boolean z) {
        this.cRD = z;
    }

    public int aAN() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.cdS;
    }

    public void setSkinType(int i) {
        this.cdS = i;
    }

    public boolean aAO() {
        return this.cRE;
    }

    public void gd(boolean z) {
        this.cRE = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String aAP() {
        return this.cRF;
    }

    public void rG(String str) {
        this.cRF = str;
    }

    public String aAQ() {
        return this.cRG;
    }

    public void rH(String str) {
        this.cRG = str;
    }

    public String aAR() {
        return this.cRH;
    }

    public void rI(String str) {
        this.cRH = str;
    }
}
