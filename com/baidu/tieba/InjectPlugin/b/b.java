package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object MV;
    private int Nj;
    private int currentPage;
    private List<m> dTH;
    private List<m> dTI;
    private List<Object> dTJ;
    private boolean dTK;
    private boolean dTL;
    private boolean dTM;
    private String dTN;
    private String dTO;
    private String dTP;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.dTK = false;
        this.dTL = false;
        this.currentPage = 0;
        this.dTM = false;
    }

    public Object nq() {
        return this.MV;
    }

    public void setExtraData(Object obj) {
        this.MV = obj;
    }

    public List<m> getThreadList() {
        return this.dTH;
    }

    public void aT(List<m> list) {
        this.dTH = list;
    }

    public List<Object> aVM() {
        return this.dTJ;
    }

    public void aU(List<Object> list) {
        this.dTJ = list;
    }

    public List<m> aVN() {
        return this.dTI;
    }

    public void aV(List<m> list) {
        this.dTI = list;
    }

    public boolean aVO() {
        return this.dTK;
    }

    public void hu(boolean z) {
        this.dTK = z;
    }

    public boolean aVP() {
        return this.dTL;
    }

    public void hv(boolean z) {
        this.dTL = z;
    }

    public int aVQ() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.Nj;
    }

    public void setSkinType(int i) {
        this.Nj = i;
    }

    public boolean aVR() {
        return this.dTM;
    }

    public void hw(boolean z) {
        this.dTM = z;
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

    public String aVS() {
        return this.dTN;
    }

    public void wl(String str) {
        this.dTN = str;
    }

    public String aVT() {
        return this.dTO;
    }

    public void wm(String str) {
        this.dTO = str;
    }

    public String aVU() {
        return this.dTP;
    }

    public void wn(String str) {
        this.dTP = str;
    }
}
