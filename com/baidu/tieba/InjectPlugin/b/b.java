package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int MH;
    private Object Ms;
    private int currentPage;
    private List<m> dOX;
    private List<m> dOY;
    private List<Object> dOZ;
    private boolean dPa;
    private boolean dPb;
    private boolean dPc;
    private String dPd;
    private String dPe;
    private String dPf;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.dPa = false;
        this.dPb = false;
        this.currentPage = 0;
        this.dPc = false;
    }

    public Object mZ() {
        return this.Ms;
    }

    public void setExtraData(Object obj) {
        this.Ms = obj;
    }

    public List<m> getThreadList() {
        return this.dOX;
    }

    public void aT(List<m> list) {
        this.dOX = list;
    }

    public List<Object> aTo() {
        return this.dOZ;
    }

    public void aU(List<Object> list) {
        this.dOZ = list;
    }

    public List<m> aTp() {
        return this.dOY;
    }

    public void aV(List<m> list) {
        this.dOY = list;
    }

    public boolean aTq() {
        return this.dPa;
    }

    public void hm(boolean z) {
        this.dPa = z;
    }

    public boolean aTr() {
        return this.dPb;
    }

    public void hn(boolean z) {
        this.dPb = z;
    }

    public int aTs() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.MH;
    }

    public void setSkinType(int i) {
        this.MH = i;
    }

    public boolean aTt() {
        return this.dPc;
    }

    public void ho(boolean z) {
        this.dPc = z;
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

    public String aTu() {
        return this.dPd;
    }

    public void vP(String str) {
        this.dPd = str;
    }

    public String aTv() {
        return this.dPe;
    }

    public void vQ(String str) {
        this.dPe = str;
    }

    public String aTw() {
        return this.dPf;
    }

    public void vR(String str) {
        this.dPf = str;
    }
}
