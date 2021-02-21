package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int ajU;
    private Object ajn;
    private int currentPage;
    private String ePN;
    private String forumId;
    private List<Object> gcA;
    private boolean gcB;
    private boolean gcC;
    private boolean gcD;
    private String gcE;
    private String gcF;
    private List<n> gcy;
    private List<n> gcz;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.gcB = false;
        this.gcC = false;
        this.currentPage = 0;
        this.gcD = false;
    }

    public Object tr() {
        return this.ajn;
    }

    public void setExtraData(Object obj) {
        this.ajn = obj;
    }

    public List<n> getThreadList() {
        return this.gcy;
    }

    public void bQ(List<n> list) {
        this.gcy = list;
    }

    public List<Object> bJG() {
        return this.gcA;
    }

    public void bR(List<Object> list) {
        this.gcA = list;
    }

    public List<n> bJH() {
        return this.gcz;
    }

    public void bS(List<n> list) {
        this.gcz = list;
    }

    public boolean bJI() {
        return this.gcB;
    }

    public void lT(boolean z) {
        this.gcB = z;
    }

    public boolean bJJ() {
        return this.gcC;
    }

    public void lU(boolean z) {
        this.gcC = z;
    }

    public int bJK() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.ajU;
    }

    public void setSkinType(int i) {
        this.ajU = i;
    }

    public boolean bJL() {
        return this.gcD;
    }

    public void lV(boolean z) {
        this.gcD = z;
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

    public String bJM() {
        return this.ePN;
    }

    public void En(String str) {
        this.ePN = str;
    }

    public String bJN() {
        return this.gcE;
    }

    public void Eo(String str) {
        this.gcE = str;
    }

    public String bJO() {
        return this.gcF;
    }

    public void Ep(String str) {
        this.gcF = str;
    }
}
