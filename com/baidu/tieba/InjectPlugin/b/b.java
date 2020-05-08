package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object afJ;
    private int afW;
    private int currentPage;
    private List<m> etL;
    private List<m> etM;
    private List<Object> etN;
    private boolean etO;
    private boolean etP;
    private boolean etQ;
    private String etR;
    private String etS;
    private String etT;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.etO = false;
        this.etP = false;
        this.currentPage = 0;
        this.etQ = false;
    }

    public Object rJ() {
        return this.afJ;
    }

    public void setExtraData(Object obj) {
        this.afJ = obj;
    }

    public List<m> getThreadList() {
        return this.etL;
    }

    public void bd(List<m> list) {
        this.etL = list;
    }

    public List<Object> bdU() {
        return this.etN;
    }

    public void be(List<Object> list) {
        this.etN = list;
    }

    public List<m> bdV() {
        return this.etM;
    }

    public void bf(List<m> list) {
        this.etM = list;
    }

    public boolean bdW() {
        return this.etO;
    }

    public void is(boolean z) {
        this.etO = z;
    }

    public boolean bdX() {
        return this.etP;
    }

    public void it(boolean z) {
        this.etP = z;
    }

    public int bdY() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.afW;
    }

    public void setSkinType(int i) {
        this.afW = i;
    }

    public boolean bdZ() {
        return this.etQ;
    }

    public void iu(boolean z) {
        this.etQ = z;
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

    public String bea() {
        return this.etR;
    }

    public void xA(String str) {
        this.etR = str;
    }

    public String beb() {
        return this.etS;
    }

    public void xB(String str) {
        this.etS = str;
    }

    public String bec() {
        return this.etT;
    }

    public void xC(String str) {
        this.etT = str;
    }
}
