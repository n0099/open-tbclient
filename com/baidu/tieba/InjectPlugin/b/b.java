package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int aLF;
    private Object bvK;
    private List<h> bvL;
    private List<h> bvM;
    private List<Object> bvN;
    private boolean bvO;
    private boolean bvP;
    private boolean bvQ;
    private String bvR;
    private String bvS;
    private String bvT;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bvO = false;
        this.bvP = false;
        this.currentPage = 0;
        this.bvQ = false;
    }

    public Object TU() {
        return this.bvK;
    }

    public void setExtraData(Object obj) {
        this.bvK = obj;
    }

    public List<h> getThreadList() {
        return this.bvL;
    }

    public void aa(List<h> list) {
        this.bvL = list;
    }

    public List<Object> TV() {
        return this.bvN;
    }

    public void ab(List<Object> list) {
        this.bvN = list;
    }

    public List<h> TW() {
        return this.bvM;
    }

    public void ac(List<h> list) {
        this.bvM = list;
    }

    public boolean TX() {
        return this.bvO;
    }

    public void dh(boolean z) {
        this.bvO = z;
    }

    public boolean isRefresh() {
        return this.bvP;
    }

    public void di(boolean z) {
        this.bvP = z;
    }

    public int TY() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.aLF;
    }

    public void setSkinType(int i) {
        this.aLF = i;
    }

    public boolean TZ() {
        return this.bvQ;
    }

    public void dj(boolean z) {
        this.bvQ = z;
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

    public String Ua() {
        return this.bvR;
    }

    public void je(String str) {
        this.bvR = str;
    }

    public String Ub() {
        return this.bvS;
    }

    public void jf(String str) {
        this.bvS = str;
    }

    public String Uc() {
        return this.bvT;
    }

    public void jg(String str) {
        this.bvT = str;
    }
}
