package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int aMj;
    private Object bwB;
    private List<h> bwC;
    private List<h> bwD;
    private List<Object> bwE;
    private boolean bwF;
    private boolean bwG;
    private boolean bwH;
    private String bwI;
    private String bwJ;
    private String bwK;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bwF = false;
        this.bwG = false;
        this.currentPage = 0;
        this.bwH = false;
    }

    public Object Us() {
        return this.bwB;
    }

    public void setExtraData(Object obj) {
        this.bwB = obj;
    }

    public List<h> getThreadList() {
        return this.bwC;
    }

    public void ab(List<h> list) {
        this.bwC = list;
    }

    public List<Object> Ut() {
        return this.bwE;
    }

    public void ac(List<Object> list) {
        this.bwE = list;
    }

    public List<h> Uu() {
        return this.bwD;
    }

    public void ad(List<h> list) {
        this.bwD = list;
    }

    public boolean Uv() {
        return this.bwF;
    }

    public void dk(boolean z) {
        this.bwF = z;
    }

    public boolean isRefresh() {
        return this.bwG;
    }

    public void dl(boolean z) {
        this.bwG = z;
    }

    public int Uw() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.aMj;
    }

    public void setSkinType(int i) {
        this.aMj = i;
    }

    public boolean Ux() {
        return this.bwH;
    }

    public void dm(boolean z) {
        this.bwH = z;
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
        return this.bwI;
    }

    public void jv(String str) {
        this.bwI = str;
    }

    public String Uz() {
        return this.bwJ;
    }

    public void jw(String str) {
        this.bwJ = str;
    }

    public String UA() {
        return this.bwK;
    }

    public void jx(String str) {
        this.bwK = str;
    }
}
