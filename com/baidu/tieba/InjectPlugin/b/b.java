package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object HC;
    private int csX;
    private int currentPage;
    private List<m> dbM;
    private List<m> dbN;
    private List<Object> dbO;
    private boolean dbP;
    private boolean dbQ;
    private boolean dbR;
    private String dbS;
    private String dbT;
    private String dbU;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.dbP = false;
        this.dbQ = false;
        this.currentPage = 0;
        this.dbR = false;
    }

    public Object mb() {
        return this.HC;
    }

    public void setExtraData(Object obj) {
        this.HC = obj;
    }

    public List<m> getThreadList() {
        return this.dbM;
    }

    public void aN(List<m> list) {
        this.dbM = list;
    }

    public List<Object> aBi() {
        return this.dbO;
    }

    public void aO(List<Object> list) {
        this.dbO = list;
    }

    public List<m> aBj() {
        return this.dbN;
    }

    public void aP(List<m> list) {
        this.dbN = list;
    }

    public boolean aBk() {
        return this.dbP;
    }

    public void fT(boolean z) {
        this.dbP = z;
    }

    public boolean aBl() {
        return this.dbQ;
    }

    public void fU(boolean z) {
        this.dbQ = z;
    }

    public int aBm() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.csX;
    }

    public void setSkinType(int i) {
        this.csX = i;
    }

    public boolean aBn() {
        return this.dbR;
    }

    public void fV(boolean z) {
        this.dbR = z;
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

    public String aBo() {
        return this.dbS;
    }

    public void qB(String str) {
        this.dbS = str;
    }

    public String aBp() {
        return this.dbT;
    }

    public void qC(String str) {
        this.dbT = str;
    }

    public String aBq() {
        return this.dbU;
    }

    public void qD(String str) {
        this.dbU = str;
    }
}
