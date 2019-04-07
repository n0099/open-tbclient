package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object Zw;
    private int bUM;
    private List<m> cHL;
    private List<m> cHM;
    private List<Object> cHN;
    private boolean cHO;
    private boolean cHP;
    private boolean cHQ;
    private String cHR;
    private String cHS;
    private String cHT;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.cHO = false;
        this.cHP = false;
        this.currentPage = 0;
        this.cHQ = false;
    }

    public Object rD() {
        return this.Zw;
    }

    public void setExtraData(Object obj) {
        this.Zw = obj;
    }

    public List<m> getThreadList() {
        return this.cHL;
    }

    public void ao(List<m> list) {
        this.cHL = list;
    }

    public List<Object> auo() {
        return this.cHN;
    }

    public void ap(List<Object> list) {
        this.cHN = list;
    }

    public List<m> aup() {
        return this.cHM;
    }

    public void aq(List<m> list) {
        this.cHM = list;
    }

    public boolean auq() {
        return this.cHO;
    }

    public void fA(boolean z) {
        this.cHO = z;
    }

    public boolean isRefresh() {
        return this.cHP;
    }

    public void fB(boolean z) {
        this.cHP = z;
    }

    public int aur() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.bUM;
    }

    public void setSkinType(int i) {
        this.bUM = i;
    }

    public boolean aus() {
        return this.cHQ;
    }

    public void fC(boolean z) {
        this.cHQ = z;
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

    public String aut() {
        return this.cHR;
    }

    public void qg(String str) {
        this.cHR = str;
    }

    public String auu() {
        return this.cHS;
    }

    public void qh(String str) {
        this.cHS = str;
    }

    public String auv() {
        return this.cHT;
    }

    public void qi(String str) {
        this.cHT = str;
    }
}
