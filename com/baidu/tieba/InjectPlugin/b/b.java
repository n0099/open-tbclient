package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int MA;
    private Object Mn;
    private int currentPage;
    private List<m> dOP;
    private List<m> dOQ;
    private List<Object> dOR;
    private boolean dOS;
    private boolean dOT;
    private boolean dOU;
    private String dOV;
    private String dOW;
    private String dOX;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.dOS = false;
        this.dOT = false;
        this.currentPage = 0;
        this.dOU = false;
    }

    public Object mY() {
        return this.Mn;
    }

    public void setExtraData(Object obj) {
        this.Mn = obj;
    }

    public List<m> getThreadList() {
        return this.dOP;
    }

    public void aU(List<m> list) {
        this.dOP = list;
    }

    public List<Object> aSU() {
        return this.dOR;
    }

    public void aV(List<Object> list) {
        this.dOR = list;
    }

    public List<m> aSV() {
        return this.dOQ;
    }

    public void aW(List<m> list) {
        this.dOQ = list;
    }

    public boolean aSW() {
        return this.dOS;
    }

    public void hh(boolean z) {
        this.dOS = z;
    }

    public boolean aSX() {
        return this.dOT;
    }

    public void hi(boolean z) {
        this.dOT = z;
    }

    public int aSY() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.MA;
    }

    public void setSkinType(int i) {
        this.MA = i;
    }

    public boolean aSZ() {
        return this.dOU;
    }

    public void hj(boolean z) {
        this.dOU = z;
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

    public String aTa() {
        return this.dOV;
    }

    public void vL(String str) {
        this.dOV = str;
    }

    public String aTb() {
        return this.dOW;
    }

    public void vM(String str) {
        this.dOW = str;
    }

    public String aTc() {
        return this.dOX;
    }

    public void vN(String str) {
        this.dOX = str;
    }
}
