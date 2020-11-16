package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aiO;
    private int ajv;
    private int currentPage;
    private String fNA;
    private String fNB;
    private List<q> fNt;
    private List<q> fNu;
    private List<Object> fNv;
    private boolean fNw;
    private boolean fNx;
    private boolean fNy;
    private String fNz;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.fNw = false;
        this.fNx = false;
        this.currentPage = 0;
        this.fNy = false;
    }

    public Object ud() {
        return this.aiO;
    }

    public void setExtraData(Object obj) {
        this.aiO = obj;
    }

    public List<q> getThreadList() {
        return this.fNt;
    }

    public void bK(List<q> list) {
        this.fNt = list;
    }

    public List<Object> bHg() {
        return this.fNv;
    }

    public void bL(List<Object> list) {
        this.fNv = list;
    }

    public List<q> bHh() {
        return this.fNu;
    }

    public void bM(List<q> list) {
        this.fNu = list;
    }

    public boolean bHi() {
        return this.fNw;
    }

    public void lc(boolean z) {
        this.fNw = z;
    }

    public boolean bHj() {
        return this.fNx;
    }

    public void ld(boolean z) {
        this.fNx = z;
    }

    public int bHk() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.ajv;
    }

    public void setSkinType(int i) {
        this.ajv = i;
    }

    public boolean bHl() {
        return this.fNy;
    }

    public void le(boolean z) {
        this.fNy = z;
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

    public String bHm() {
        return this.fNz;
    }

    public void Es(String str) {
        this.fNz = str;
    }

    public String bHn() {
        return this.fNA;
    }

    public void Et(String str) {
        this.fNA = str;
    }

    public String bHo() {
        return this.fNB;
    }

    public void Eu(String str) {
        this.fNB = str;
    }
}
