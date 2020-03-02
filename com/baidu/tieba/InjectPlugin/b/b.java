package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object MU;
    private int Ni;
    private int currentPage;
    private List<m> dTe;
    private List<m> dTf;
    private List<Object> dTg;
    private boolean dTh;
    private boolean dTi;
    private boolean dTj;
    private String dTk;
    private String dTl;
    private String dTm;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.dTh = false;
        this.dTi = false;
        this.currentPage = 0;
        this.dTj = false;
    }

    public Object nq() {
        return this.MU;
    }

    public void setExtraData(Object obj) {
        this.MU = obj;
    }

    public List<m> getThreadList() {
        return this.dTe;
    }

    public void aT(List<m> list) {
        this.dTe = list;
    }

    public List<Object> aVH() {
        return this.dTg;
    }

    public void aU(List<Object> list) {
        this.dTg = list;
    }

    public List<m> aVI() {
        return this.dTf;
    }

    public void aV(List<m> list) {
        this.dTf = list;
    }

    public boolean aVJ() {
        return this.dTh;
    }

    public void ht(boolean z) {
        this.dTh = z;
    }

    public boolean aVK() {
        return this.dTi;
    }

    public void hu(boolean z) {
        this.dTi = z;
    }

    public int aVL() {
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

    public boolean aVM() {
        return this.dTj;
    }

    public void hv(boolean z) {
        this.dTj = z;
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

    public String aVN() {
        return this.dTk;
    }

    public void wj(String str) {
        this.dTk = str;
    }

    public String aVO() {
        return this.dTl;
    }

    public void wk(String str) {
        this.dTl = str;
    }

    public String aVP() {
        return this.dTm;
    }

    public void wl(String str) {
        this.dTm = str;
    }
}
