package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int aHp;
    private List<h> brA;
    private List<h> brB;
    private List<Object> brC;
    private boolean brD;
    private boolean brE;
    private boolean brF;
    private String brG;
    private String brH;
    private String brI;
    private Object brz;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.brD = false;
        this.brE = false;
        this.currentPage = 0;
        this.brF = false;
    }

    public Object SF() {
        return this.brz;
    }

    public void setExtraData(Object obj) {
        this.brz = obj;
    }

    public List<h> getThreadList() {
        return this.brA;
    }

    public void ab(List<h> list) {
        this.brA = list;
    }

    public List<Object> SG() {
        return this.brC;
    }

    public void ac(List<Object> list) {
        this.brC = list;
    }

    public List<h> SH() {
        return this.brB;
    }

    public void ad(List<h> list) {
        this.brB = list;
    }

    public boolean SI() {
        return this.brD;
    }

    public void cP(boolean z) {
        this.brD = z;
    }

    public boolean isRefresh() {
        return this.brE;
    }

    public void cQ(boolean z) {
        this.brE = z;
    }

    public int SJ() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.aHp;
    }

    public void setSkinType(int i) {
        this.aHp = i;
    }

    public boolean SK() {
        return this.brF;
    }

    public void cR(boolean z) {
        this.brF = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void gS(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String SL() {
        return this.brG;
    }

    public void iK(String str) {
        this.brG = str;
    }

    public String SM() {
        return this.brH;
    }

    public void iL(String str) {
        this.brH = str;
    }

    public String SN() {
        return this.brI;
    }

    public void iM(String str) {
        this.brI = str;
    }
}
