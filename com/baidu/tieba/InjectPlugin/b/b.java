package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object akF;
    private int aln;
    private int currentPage;
    private String eRo;
    private String forumId;
    private List<n> gdY;
    private List<n> gdZ;
    private List<Object> gea;
    private boolean geb;
    private boolean gec;
    private boolean ged;
    private String gee;
    private String gef;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.geb = false;
        this.gec = false;
        this.currentPage = 0;
        this.ged = false;
    }

    public Object tr() {
        return this.akF;
    }

    public void setExtraData(Object obj) {
        this.akF = obj;
    }

    public List<n> getThreadList() {
        return this.gdY;
    }

    public void bQ(List<n> list) {
        this.gdY = list;
    }

    public List<Object> bJK() {
        return this.gea;
    }

    public void bR(List<Object> list) {
        this.gea = list;
    }

    public List<n> bJL() {
        return this.gdZ;
    }

    public void bS(List<n> list) {
        this.gdZ = list;
    }

    public boolean bJM() {
        return this.geb;
    }

    public void lT(boolean z) {
        this.geb = z;
    }

    public boolean bJN() {
        return this.gec;
    }

    public void lU(boolean z) {
        this.gec = z;
    }

    public int bJO() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.aln;
    }

    public void setSkinType(int i) {
        this.aln = i;
    }

    public boolean bJP() {
        return this.ged;
    }

    public void lV(boolean z) {
        this.ged = z;
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

    public String bJQ() {
        return this.eRo;
    }

    public void Eu(String str) {
        this.eRo = str;
    }

    public String bJR() {
        return this.gee;
    }

    public void Ev(String str) {
        this.gee = str;
    }

    public String bJS() {
        return this.gef;
    }

    public void Ew(String str) {
        this.gef = str;
    }
}
