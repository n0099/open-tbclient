package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aiI;
    private int ajp;
    private int currentPage;
    private String forumId;
    private List<q> fzF;
    private List<q> fzG;
    private List<Object> fzH;
    private boolean fzI;
    private boolean fzJ;
    private boolean fzK;
    private String fzL;
    private String fzM;
    private String fzN;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.fzI = false;
        this.fzJ = false;
        this.currentPage = 0;
        this.fzK = false;
    }

    public Object ud() {
        return this.aiI;
    }

    public void setExtraData(Object obj) {
        this.aiI = obj;
    }

    public List<q> getThreadList() {
        return this.fzF;
    }

    public void bu(List<q> list) {
        this.fzF = list;
    }

    public List<Object> bDv() {
        return this.fzH;
    }

    public void bv(List<Object> list) {
        this.fzH = list;
    }

    public List<q> bDw() {
        return this.fzG;
    }

    public void bw(List<q> list) {
        this.fzG = list;
    }

    public boolean bDx() {
        return this.fzI;
    }

    public void kF(boolean z) {
        this.fzI = z;
    }

    public boolean bDy() {
        return this.fzJ;
    }

    public void kG(boolean z) {
        this.fzJ = z;
    }

    public int bDz() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.ajp;
    }

    public void setSkinType(int i) {
        this.ajp = i;
    }

    public boolean bDA() {
        return this.fzK;
    }

    public void kH(boolean z) {
        this.fzK = z;
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

    public String bDB() {
        return this.fzL;
    }

    public void Ek(String str) {
        this.fzL = str;
    }

    public String bDC() {
        return this.fzM;
    }

    public void El(String str) {
        this.fzM = str;
    }

    public String bDD() {
        return this.fzN;
    }

    public void Em(String str) {
        this.fzN = str;
    }
}
