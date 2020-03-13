package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object MU;
    private int Ni;
    private int currentPage;
    private List<m> dTr;
    private List<m> dTs;
    private List<Object> dTt;
    private boolean dTu;
    private boolean dTv;
    private boolean dTw;
    private String dTx;
    private String dTy;
    private String dTz;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.dTu = false;
        this.dTv = false;
        this.currentPage = 0;
        this.dTw = false;
    }

    public Object nq() {
        return this.MU;
    }

    public void setExtraData(Object obj) {
        this.MU = obj;
    }

    public List<m> getThreadList() {
        return this.dTr;
    }

    public void aT(List<m> list) {
        this.dTr = list;
    }

    public List<Object> aVI() {
        return this.dTt;
    }

    public void aU(List<Object> list) {
        this.dTt = list;
    }

    public List<m> aVJ() {
        return this.dTs;
    }

    public void aV(List<m> list) {
        this.dTs = list;
    }

    public boolean aVK() {
        return this.dTu;
    }

    public void ht(boolean z) {
        this.dTu = z;
    }

    public boolean aVL() {
        return this.dTv;
    }

    public void hu(boolean z) {
        this.dTv = z;
    }

    public int aVM() {
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

    public boolean aVN() {
        return this.dTw;
    }

    public void hv(boolean z) {
        this.dTw = z;
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

    public String aVO() {
        return this.dTx;
    }

    public void wk(String str) {
        this.dTx = str;
    }

    public String aVP() {
        return this.dTy;
    }

    public void wl(String str) {
        this.dTy = str;
    }

    public String aVQ() {
        return this.dTz;
    }

    public void wm(String str) {
        this.dTz = str;
    }
}
