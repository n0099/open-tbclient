package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object XJ;
    private String cRA;
    private List<m> cRs;
    private List<m> cRt;
    private List<Object> cRu;
    private boolean cRv;
    private boolean cRw;
    private boolean cRx;
    private String cRy;
    private String cRz;
    private int cdL;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.cRv = false;
        this.cRw = false;
        this.currentPage = 0;
        this.cRx = false;
    }

    public Object qV() {
        return this.XJ;
    }

    public void setExtraData(Object obj) {
        this.XJ = obj;
    }

    public List<m> getThreadList() {
        return this.cRs;
    }

    public void av(List<m> list) {
        this.cRs = list;
    }

    public List<Object> aAI() {
        return this.cRu;
    }

    public void aw(List<Object> list) {
        this.cRu = list;
    }

    public List<m> aAJ() {
        return this.cRt;
    }

    public void ax(List<m> list) {
        this.cRt = list;
    }

    public boolean aAK() {
        return this.cRv;
    }

    public void gb(boolean z) {
        this.cRv = z;
    }

    public boolean isRefresh() {
        return this.cRw;
    }

    public void gc(boolean z) {
        this.cRw = z;
    }

    public int aAL() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.cdL;
    }

    public void setSkinType(int i) {
        this.cdL = i;
    }

    public boolean aAM() {
        return this.cRx;
    }

    public void gd(boolean z) {
        this.cRx = z;
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

    public String aAN() {
        return this.cRy;
    }

    public void rG(String str) {
        this.cRy = str;
    }

    public String aAO() {
        return this.cRz;
    }

    public void rH(String str) {
        this.cRz = str;
    }

    public String aAP() {
        return this.cRA;
    }

    public void rI(String str) {
        this.cRA = str;
    }
}
