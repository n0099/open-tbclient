package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object Zw;
    private int bUK;
    private List<m> cHJ;
    private List<m> cHK;
    private List<Object> cHL;
    private boolean cHM;
    private boolean cHN;
    private boolean cHO;
    private String cHP;
    private String cHQ;
    private String cHR;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.cHM = false;
        this.cHN = false;
        this.currentPage = 0;
        this.cHO = false;
    }

    public Object rD() {
        return this.Zw;
    }

    public void setExtraData(Object obj) {
        this.Zw = obj;
    }

    public List<m> getThreadList() {
        return this.cHJ;
    }

    public void ao(List<m> list) {
        this.cHJ = list;
    }

    public List<Object> aur() {
        return this.cHL;
    }

    public void ap(List<Object> list) {
        this.cHL = list;
    }

    public List<m> aus() {
        return this.cHK;
    }

    public void aq(List<m> list) {
        this.cHK = list;
    }

    public boolean aut() {
        return this.cHM;
    }

    public void fA(boolean z) {
        this.cHM = z;
    }

    public boolean isRefresh() {
        return this.cHN;
    }

    public void fB(boolean z) {
        this.cHN = z;
    }

    public int auu() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.bUK;
    }

    public void setSkinType(int i) {
        this.bUK = i;
    }

    public boolean auv() {
        return this.cHO;
    }

    public void fC(boolean z) {
        this.cHO = z;
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
        return this.cHP;
    }

    public void qf(String str) {
        this.cHP = str;
    }

    public String aux() {
        return this.cHQ;
    }

    public void qg(String str) {
        this.cHQ = str;
    }

    public String auy() {
        return this.cHR;
    }

    public void qh(String str) {
        this.cHR = str;
    }
}
