package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int aIf;
    private Object bsl;
    private List<h> bsm;
    private List<h> bsn;
    private List<Object> bso;
    private boolean bsp;
    private boolean bsq;
    private boolean bsr;
    private String bss;
    private String bst;
    private String bsu;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bsp = false;
        this.bsq = false;
        this.currentPage = 0;
        this.bsr = false;
    }

    public Object SO() {
        return this.bsl;
    }

    public void setExtraData(Object obj) {
        this.bsl = obj;
    }

    public List<h> getThreadList() {
        return this.bsm;
    }

    public void aa(List<h> list) {
        this.bsm = list;
    }

    public List<Object> SP() {
        return this.bso;
    }

    public void ab(List<Object> list) {
        this.bso = list;
    }

    public List<h> SQ() {
        return this.bsn;
    }

    public void ac(List<h> list) {
        this.bsn = list;
    }

    public boolean SR() {
        return this.bsp;
    }

    public void dg(boolean z) {
        this.bsp = z;
    }

    public boolean isRefresh() {
        return this.bsq;
    }

    public void dh(boolean z) {
        this.bsq = z;
    }

    public int SS() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.aIf;
    }

    public void setSkinType(int i) {
        this.aIf = i;
    }

    public boolean ST() {
        return this.bsr;
    }

    public void di(boolean z) {
        this.bsr = z;
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

    public String SU() {
        return this.bss;
    }

    public void iM(String str) {
        this.bss = str;
    }

    public String SV() {
        return this.bst;
    }

    public void iN(String str) {
        this.bst = str;
    }

    public String SW() {
        return this.bsu;
    }

    public void iO(String str) {
        this.bsu = str;
    }
}
