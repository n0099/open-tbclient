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
    private String gcA;
    private List<n> gcs;
    private List<n> gcu;
    private List<Object> gcv;
    private boolean gcw;
    private boolean gcx;
    private boolean gcy;
    private String gcz;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.gcw = false;
        this.gcx = false;
        this.currentPage = 0;
        this.gcy = false;
    }

    public Object tr() {
        return this.ajn;
    }

    public void setExtraData(Object obj) {
        this.ajn = obj;
    }

    public List<n> getThreadList() {
        return this.gcs;
    }

    public void bQ(List<n> list) {
        this.gcs = list;
    }

    public List<Object> bJB() {
        return this.gcv;
    }

    public void bR(List<Object> list) {
        this.gcv = list;
    }

    public List<n> bJC() {
        return this.gcu;
    }

    public void bS(List<n> list) {
        this.gcu = list;
    }

    public boolean bJD() {
        return this.gcw;
    }

    public void lT(boolean z) {
        this.gcw = z;
    }

    public boolean bJE() {
        return this.gcx;
    }

    public void lU(boolean z) {
        this.gcx = z;
    }

    public int bJF() {
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

    public boolean bJG() {
        return this.gcy;
    }

    public void lV(boolean z) {
        this.gcy = z;
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

    public String bJH() {
        return this.ePN;
    }

    public void Ep(String str) {
        this.ePN = str;
    }

    public String bJI() {
        return this.gcz;
    }

    public void Eq(String str) {
        this.gcz = str;
    }

    public String bJJ() {
        return this.gcA;
    }

    public void Er(String str) {
        this.gcA = str;
    }
}
