package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int akW;
    private Object akp;
    private int currentPage;
    private String eSm;
    private String forumId;
    private List<n> geK;
    private List<n> geL;
    private List<Object> geM;
    private boolean geN;
    private boolean geO;
    private boolean geP;
    private String geQ;
    private String geR;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.geN = false;
        this.geO = false;
        this.currentPage = 0;
        this.geP = false;
    }

    public Object tF() {
        return this.akp;
    }

    public void setExtraData(Object obj) {
        this.akp = obj;
    }

    public List<n> getThreadList() {
        return this.geK;
    }

    public void bV(List<n> list) {
        this.geK = list;
    }

    public List<Object> bMY() {
        return this.geM;
    }

    public void bW(List<Object> list) {
        this.geM = list;
    }

    public List<n> bMZ() {
        return this.geL;
    }

    public void bX(List<n> list) {
        this.geL = list;
    }

    public boolean bNa() {
        return this.geN;
    }

    public void lT(boolean z) {
        this.geN = z;
    }

    public boolean bNb() {
        return this.geO;
    }

    public void lU(boolean z) {
        this.geO = z;
    }

    public int bNc() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.akW;
    }

    public void setSkinType(int i) {
        this.akW = i;
    }

    public boolean bNd() {
        return this.geP;
    }

    public void lV(boolean z) {
        this.geP = z;
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

    public String bNe() {
        return this.eSm;
    }

    public void Fe(String str) {
        this.eSm = str;
    }

    public String bNf() {
        return this.geQ;
    }

    public void Ff(String str) {
        this.geQ = str;
    }

    public String bNg() {
        return this.geR;
    }

    public void Fg(String str) {
        this.geR = str;
    }
}
