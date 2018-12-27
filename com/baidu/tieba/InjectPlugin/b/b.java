package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int aLH;
    private Object bvN;
    private List<h> bvO;
    private List<h> bvP;
    private List<Object> bvQ;
    private boolean bvR;
    private boolean bvS;
    private boolean bvT;
    private String bvU;
    private String bvV;
    private String bvW;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bvR = false;
        this.bvS = false;
        this.currentPage = 0;
        this.bvT = false;
    }

    public Object TW() {
        return this.bvN;
    }

    public void setExtraData(Object obj) {
        this.bvN = obj;
    }

    public List<h> getThreadList() {
        return this.bvO;
    }

    public void aa(List<h> list) {
        this.bvO = list;
    }

    public List<Object> TX() {
        return this.bvQ;
    }

    public void ab(List<Object> list) {
        this.bvQ = list;
    }

    public List<h> TY() {
        return this.bvP;
    }

    public void ac(List<h> list) {
        this.bvP = list;
    }

    public boolean TZ() {
        return this.bvR;
    }

    public void dh(boolean z) {
        this.bvR = z;
    }

    public boolean isRefresh() {
        return this.bvS;
    }

    public void di(boolean z) {
        this.bvS = z;
    }

    public int Ua() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.aLH;
    }

    public void setSkinType(int i) {
        this.aLH = i;
    }

    public boolean Ub() {
        return this.bvT;
    }

    public void dj(boolean z) {
        this.bvT = z;
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

    public String Uc() {
        return this.bvU;
    }

    public void jf(String str) {
        this.bvU = str;
    }

    public String Ud() {
        return this.bvV;
    }

    public void jg(String str) {
        this.bvV = str;
    }

    public String Ue() {
        return this.bvW;
    }

    public void jh(String str) {
        this.bvW = str;
    }
}
