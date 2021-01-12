package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object ajy;
    private int akf;
    private int currentPage;
    private String eNB;
    private String forumId;
    private List<n> gaa;
    private List<n> gab;
    private List<Object> gac;
    private boolean gad;
    private boolean gae;
    private boolean gaf;
    private String gag;
    private String gah;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.gad = false;
        this.gae = false;
        this.currentPage = 0;
        this.gaf = false;
    }

    public Object tu() {
        return this.ajy;
    }

    public void setExtraData(Object obj) {
        this.ajy = obj;
    }

    public List<n> getThreadList() {
        return this.gaa;
    }

    public void bV(List<n> list) {
        this.gaa = list;
    }

    public List<Object> bJh() {
        return this.gac;
    }

    public void bW(List<Object> list) {
        this.gac = list;
    }

    public List<n> bJi() {
        return this.gab;
    }

    public void bX(List<n> list) {
        this.gab = list;
    }

    public boolean bJj() {
        return this.gad;
    }

    public void lP(boolean z) {
        this.gad = z;
    }

    public boolean bJk() {
        return this.gae;
    }

    public void lQ(boolean z) {
        this.gae = z;
    }

    public int bJl() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.akf;
    }

    public void setSkinType(int i) {
        this.akf = i;
    }

    public boolean bJm() {
        return this.gaf;
    }

    public void lR(boolean z) {
        this.gaf = z;
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

    public String bJn() {
        return this.eNB;
    }

    public void DS(String str) {
        this.eNB = str;
    }

    public String bJo() {
        return this.gag;
    }

    public void DT(String str) {
        this.gag = str;
    }

    public String bJp() {
        return this.gah;
    }

    public void DU(String str) {
        this.gah = str;
    }
}
