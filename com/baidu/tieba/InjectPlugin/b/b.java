package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int aMk;
    private Object bwC;
    private List<h> bwD;
    private List<h> bwE;
    private List<Object> bwF;
    private boolean bwG;
    private boolean bwH;
    private boolean bwI;
    private String bwJ;
    private String bwK;
    private String bwL;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bwG = false;
        this.bwH = false;
        this.currentPage = 0;
        this.bwI = false;
    }

    public Object Us() {
        return this.bwC;
    }

    public void setExtraData(Object obj) {
        this.bwC = obj;
    }

    public List<h> getThreadList() {
        return this.bwD;
    }

    public void ab(List<h> list) {
        this.bwD = list;
    }

    public List<Object> Ut() {
        return this.bwF;
    }

    public void ac(List<Object> list) {
        this.bwF = list;
    }

    public List<h> Uu() {
        return this.bwE;
    }

    public void ad(List<h> list) {
        this.bwE = list;
    }

    public boolean Uv() {
        return this.bwG;
    }

    public void dk(boolean z) {
        this.bwG = z;
    }

    public boolean isRefresh() {
        return this.bwH;
    }

    public void dl(boolean z) {
        this.bwH = z;
    }

    public int Uw() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.aMk;
    }

    public void setSkinType(int i) {
        this.aMk = i;
    }

    public boolean Ux() {
        return this.bwI;
    }

    public void dm(boolean z) {
        this.bwI = z;
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

    public String Uy() {
        return this.bwJ;
    }

    public void jv(String str) {
        this.bwJ = str;
    }

    public String Uz() {
        return this.bwK;
    }

    public void jw(String str) {
        this.bwK = str;
    }

    public String UA() {
        return this.bwL;
    }

    public void jx(String str) {
        this.bwL = str;
    }
}
