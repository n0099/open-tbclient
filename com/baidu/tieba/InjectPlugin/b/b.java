package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aXD;
    private List<h> aXE;
    private List<h> aXF;
    private List<Object> aXG;
    private boolean aXH;
    private boolean aXI;
    private boolean aXJ;
    private String aXK;
    private String aXL;
    private String aXM;
    private int aqQ;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aXH = false;
        this.aXI = false;
        this.currentPage = 0;
        this.aXJ = false;
    }

    public Object KW() {
        return this.aXD;
    }

    public void setExtraData(Object obj) {
        this.aXD = obj;
    }

    public List<h> getThreadList() {
        return this.aXE;
    }

    public void O(List<h> list) {
        this.aXE = list;
    }

    public List<Object> KX() {
        return this.aXG;
    }

    public void P(List<Object> list) {
        this.aXG = list;
    }

    public List<h> KY() {
        return this.aXF;
    }

    public void Q(List<h> list) {
        this.aXF = list;
    }

    public boolean KZ() {
        return this.aXH;
    }

    public void cg(boolean z) {
        this.aXH = z;
    }

    public boolean isRefresh() {
        return this.aXI;
    }

    public void ch(boolean z) {
        this.aXI = z;
    }

    public int La() {
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

    public boolean Lb() {
        return this.aXJ;
    }

    public void ci(boolean z) {
        this.aXJ = z;
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

    public String Lc() {
        return this.aXK;
    }

    public void hv(String str) {
        this.aXK = str;
    }

    public String Ld() {
        return this.aXL;
    }

    public void hw(String str) {
        this.aXL = str;
    }

    public String Le() {
        return this.aXM;
    }

    public void hx(String str) {
        this.aXM = str;
    }
}
