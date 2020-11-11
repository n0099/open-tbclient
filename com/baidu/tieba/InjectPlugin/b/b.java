package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aiJ;
    private int ajq;
    private int currentPage;
    private List<q> fNQ;
    private List<q> fNR;
    private List<Object> fNS;
    private boolean fNT;
    private boolean fNU;
    private boolean fNV;
    private String fNW;
    private String fNX;
    private String fNY;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.fNT = false;
        this.fNU = false;
        this.currentPage = 0;
        this.fNV = false;
    }

    public Object ud() {
        return this.aiJ;
    }

    public void setExtraData(Object obj) {
        this.aiJ = obj;
    }

    public List<q> getThreadList() {
        return this.fNQ;
    }

    public void bK(List<q> list) {
        this.fNQ = list;
    }

    public List<Object> bHN() {
        return this.fNS;
    }

    public void bL(List<Object> list) {
        this.fNS = list;
    }

    public List<q> bHO() {
        return this.fNR;
    }

    public void bM(List<q> list) {
        this.fNR = list;
    }

    public boolean bHP() {
        return this.fNT;
    }

    public void lb(boolean z) {
        this.fNT = z;
    }

    public boolean bHQ() {
        return this.fNU;
    }

    public void lc(boolean z) {
        this.fNU = z;
    }

    public int bHR() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.ajq;
    }

    public void setSkinType(int i) {
        this.ajq = i;
    }

    public boolean bHS() {
        return this.fNV;
    }

    public void ld(boolean z) {
        this.fNV = z;
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

    public String bHT() {
        return this.fNW;
    }

    public void ER(String str) {
        this.fNW = str;
    }

    public String bHU() {
        return this.fNX;
    }

    public void ES(String str) {
        this.fNX = str;
    }

    public String bHV() {
        return this.fNY;
    }

    public void ET(String str) {
        this.fNY = str;
    }
}
