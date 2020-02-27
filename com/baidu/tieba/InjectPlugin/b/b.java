package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object MU;
    private int Ni;
    private int currentPage;
    private List<m> dTd;
    private List<m> dTe;
    private List<Object> dTf;
    private boolean dTg;
    private boolean dTh;
    private boolean dTi;
    private String dTj;
    private String dTk;
    private String dTl;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.dTg = false;
        this.dTh = false;
        this.currentPage = 0;
        this.dTi = false;
    }

    public Object nq() {
        return this.MU;
    }

    public void setExtraData(Object obj) {
        this.MU = obj;
    }

    public List<m> getThreadList() {
        return this.dTd;
    }

    public void aT(List<m> list) {
        this.dTd = list;
    }

    public List<Object> aVF() {
        return this.dTf;
    }

    public void aU(List<Object> list) {
        this.dTf = list;
    }

    public List<m> aVG() {
        return this.dTe;
    }

    public void aV(List<m> list) {
        this.dTe = list;
    }

    public boolean aVH() {
        return this.dTg;
    }

    public void ht(boolean z) {
        this.dTg = z;
    }

    public boolean aVI() {
        return this.dTh;
    }

    public void hu(boolean z) {
        this.dTh = z;
    }

    public int aVJ() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.Ni;
    }

    public void setSkinType(int i) {
        this.Ni = i;
    }

    public boolean aVK() {
        return this.dTi;
    }

    public void hv(boolean z) {
        this.dTi = z;
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

    public String aVL() {
        return this.dTj;
    }

    public void wj(String str) {
        this.dTj = str;
    }

    public String aVM() {
        return this.dTk;
    }

    public void wk(String str) {
        this.dTk = str;
    }

    public String aVN() {
        return this.dTl;
    }

    public void wl(String str) {
        this.dTl = str;
    }
}
