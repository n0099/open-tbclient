package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aXE;
    private List<h> aXF;
    private List<h> aXG;
    private List<Object> aXH;
    private boolean aXI;
    private boolean aXJ;
    private boolean aXK;
    private String aXL;
    private String aXM;
    private String aXN;
    private int aqQ;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aXI = false;
        this.aXJ = false;
        this.currentPage = 0;
        this.aXK = false;
    }

    public Object KU() {
        return this.aXE;
    }

    public void setExtraData(Object obj) {
        this.aXE = obj;
    }

    public List<h> getThreadList() {
        return this.aXF;
    }

    public void O(List<h> list) {
        this.aXF = list;
    }

    public List<Object> KV() {
        return this.aXH;
    }

    public void P(List<Object> list) {
        this.aXH = list;
    }

    public List<h> KW() {
        return this.aXG;
    }

    public void Q(List<h> list) {
        this.aXG = list;
    }

    public boolean KX() {
        return this.aXI;
    }

    public void cg(boolean z) {
        this.aXI = z;
    }

    public boolean isRefresh() {
        return this.aXJ;
    }

    public void ch(boolean z) {
        this.aXJ = z;
    }

    public int KY() {
        return this.currentPage;
    }

    public void bV(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.aqQ;
    }

    public void setSkinType(int i) {
        this.aqQ = i;
    }

    public boolean KZ() {
        return this.aXK;
    }

    public void ci(boolean z) {
        this.aXK = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void gd(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String La() {
        return this.aXL;
    }

    public void hw(String str) {
        this.aXL = str;
    }

    public String Lb() {
        return this.aXM;
    }

    public void hx(String str) {
        this.aXM = str;
    }

    public String Lc() {
        return this.aXN;
    }

    public void hy(String str) {
        this.aXN = str;
    }
}
