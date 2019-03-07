package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object Zv;
    private int bUJ;
    private List<m> cHM;
    private List<m> cHN;
    private List<Object> cHO;
    private boolean cHP;
    private boolean cHQ;
    private boolean cHR;
    private String cHS;
    private String cHT;
    private String cHU;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.cHP = false;
        this.cHQ = false;
        this.currentPage = 0;
        this.cHR = false;
    }

    public Object rD() {
        return this.Zv;
    }

    public void setExtraData(Object obj) {
        this.Zv = obj;
    }

    public List<m> getThreadList() {
        return this.cHM;
    }

    public void ao(List<m> list) {
        this.cHM = list;
    }

    public List<Object> aur() {
        return this.cHO;
    }

    public void ap(List<Object> list) {
        this.cHO = list;
    }

    public List<m> aus() {
        return this.cHN;
    }

    public void aq(List<m> list) {
        this.cHN = list;
    }

    public boolean aut() {
        return this.cHP;
    }

    public void fA(boolean z) {
        this.cHP = z;
    }

    public boolean isRefresh() {
        return this.cHQ;
    }

    public void fB(boolean z) {
        this.cHQ = z;
    }

    public int auu() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.bUJ;
    }

    public void setSkinType(int i) {
        this.bUJ = i;
    }

    public boolean auv() {
        return this.cHR;
    }

    public void fC(boolean z) {
        this.cHR = z;
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

    public String auw() {
        return this.cHS;
    }

    public void qg(String str) {
        this.cHS = str;
    }

    public String aux() {
        return this.cHT;
    }

    public void qh(String str) {
        this.cHT = str;
    }

    public String auy() {
        return this.cHU;
    }

    public void qi(String str) {
        this.cHU = str;
    }
}
