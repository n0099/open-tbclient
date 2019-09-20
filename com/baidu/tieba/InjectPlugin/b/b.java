package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object XI;
    private String cSA;
    private List<m> cSs;
    private List<m> cSt;
    private List<Object> cSu;
    private boolean cSv;
    private boolean cSw;
    private boolean cSx;
    private String cSy;
    private String cSz;
    private int ceL;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.cSv = false;
        this.cSw = false;
        this.currentPage = 0;
        this.cSx = false;
    }

    public Object qW() {
        return this.XI;
    }

    public void setExtraData(Object obj) {
        this.XI = obj;
    }

    public List<m> getThreadList() {
        return this.cSs;
    }

    public void av(List<m> list) {
        this.cSs = list;
    }

    public List<Object> aAY() {
        return this.cSu;
    }

    public void aw(List<Object> list) {
        this.cSu = list;
    }

    public List<m> aAZ() {
        return this.cSt;
    }

    public void ax(List<m> list) {
        this.cSt = list;
    }

    public boolean aBa() {
        return this.cSv;
    }

    public void ge(boolean z) {
        this.cSv = z;
    }

    public boolean isRefresh() {
        return this.cSw;
    }

    public void gf(boolean z) {
        this.cSw = z;
    }

    public int aBb() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.ceL;
    }

    public void setSkinType(int i) {
        this.ceL = i;
    }

    public boolean aBc() {
        return this.cSx;
    }

    public void gg(boolean z) {
        this.cSx = z;
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

    public String aBd() {
        return this.cSy;
    }

    public void rR(String str) {
        this.cSy = str;
    }

    public String aBe() {
        return this.cSz;
    }

    public void rS(String str) {
        this.cSz = str;
    }

    public String aBf() {
        return this.cSA;
    }

    public void rT(String str) {
        this.cSA = str;
    }
}
