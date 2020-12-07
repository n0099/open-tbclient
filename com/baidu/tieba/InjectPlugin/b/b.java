package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object ajN;
    private int aku;
    private int currentPage;
    private String eIu;
    private List<q> fVe;
    private List<q> fVf;
    private List<Object> fVg;
    private boolean fVh;
    private boolean fVi;
    private boolean fVj;
    private String fVk;
    private String fVl;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.fVh = false;
        this.fVi = false;
        this.currentPage = 0;
        this.fVj = false;
    }

    public Object ug() {
        return this.ajN;
    }

    public void setExtraData(Object obj) {
        this.ajN = obj;
    }

    public List<q> getThreadList() {
        return this.fVe;
    }

    public void bO(List<q> list) {
        this.fVe = list;
    }

    public List<Object> bKG() {
        return this.fVg;
    }

    public void bP(List<Object> list) {
        this.fVg = list;
    }

    public List<q> bKH() {
        return this.fVf;
    }

    public void bQ(List<q> list) {
        this.fVf = list;
    }

    public boolean bKI() {
        return this.fVh;
    }

    public void lw(boolean z) {
        this.fVh = z;
    }

    public boolean bKJ() {
        return this.fVi;
    }

    public void lx(boolean z) {
        this.fVi = z;
    }

    public int bKK() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.aku;
    }

    public void setSkinType(int i) {
        this.aku = i;
    }

    public boolean bKL() {
        return this.fVj;
    }

    public void ly(boolean z) {
        this.fVj = z;
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

    public String bKM() {
        return this.eIu;
    }

    public void Fg(String str) {
        this.eIu = str;
    }

    public String bKN() {
        return this.fVk;
    }

    public void Fh(String str) {
        this.fVk = str;
    }

    public String bKO() {
        return this.fVl;
    }

    public void Fi(String str) {
        this.fVl = str;
    }
}
