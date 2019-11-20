package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object Hc;
    private int csg;
    private int currentPage;
    private List<m> daV;
    private List<m> daW;
    private List<Object> daX;
    private boolean daY;
    private boolean daZ;
    private boolean dba;
    private String dbb;
    private String dbc;
    private String dbd;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.daY = false;
        this.daZ = false;
        this.currentPage = 0;
        this.dba = false;
    }

    public Object mb() {
        return this.Hc;
    }

    public void setExtraData(Object obj) {
        this.Hc = obj;
    }

    public List<m> getThreadList() {
        return this.daV;
    }

    public void aN(List<m> list) {
        this.daV = list;
    }

    public List<Object> aBg() {
        return this.daX;
    }

    public void aO(List<Object> list) {
        this.daX = list;
    }

    public List<m> aBh() {
        return this.daW;
    }

    public void aP(List<m> list) {
        this.daW = list;
    }

    public boolean aBi() {
        return this.daY;
    }

    public void fT(boolean z) {
        this.daY = z;
    }

    public boolean aBj() {
        return this.daZ;
    }

    public void fU(boolean z) {
        this.daZ = z;
    }

    public int aBk() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.csg;
    }

    public void setSkinType(int i) {
        this.csg = i;
    }

    public boolean aBl() {
        return this.dba;
    }

    public void fV(boolean z) {
        this.dba = z;
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

    public String aBm() {
        return this.dbb;
    }

    public void qB(String str) {
        this.dbb = str;
    }

    public String aBn() {
        return this.dbc;
    }

    public void qC(String str) {
        this.dbc = str;
    }

    public String aBo() {
        return this.dbd;
    }

    public void qD(String str) {
        this.dbd = str;
    }
}
