package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.i;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private boolean bLA;
    private int bLB;
    private boolean bLC;
    private String bLD;
    private String bLE;
    private String bLF;
    private Object bLv;
    private List<i> bLw;
    private List<i> bLx;
    private List<Object> bLy;
    private boolean bLz;
    private int bdE;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bLz = false;
        this.bLA = false;
        this.bLB = 0;
        this.bLC = false;
    }

    public Object Se() {
        return this.bLv;
    }

    public void setExtraData(Object obj) {
        this.bLv = obj;
    }

    public List<i> getThreadList() {
        return this.bLw;
    }

    public void X(List<i> list) {
        this.bLw = list;
    }

    public List<Object> Sf() {
        return this.bLy;
    }

    public void Y(List<Object> list) {
        this.bLy = list;
    }

    public List<i> Sg() {
        return this.bLx;
    }

    public void Z(List<i> list) {
        this.bLx = list;
    }

    public boolean Sh() {
        return this.bLz;
    }

    public void cM(boolean z) {
        this.bLz = z;
    }

    public boolean isRefresh() {
        return this.bLA;
    }

    public void cN(boolean z) {
        this.bLA = z;
    }

    public int Si() {
        return this.bLB;
    }

    public void eY(int i) {
        this.bLB = i;
    }

    public int getSkinType() {
        return this.bdE;
    }

    public void setSkinType(int i) {
        this.bdE = i;
    }

    public boolean Sj() {
        return this.bLC;
    }

    public void cO(boolean z) {
        this.bLC = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void jm(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String Sk() {
        return this.bLD;
    }

    public void hk(String str) {
        this.bLD = str;
    }

    public String Sl() {
        return this.bLE;
    }

    public void hl(String str) {
        this.bLE = str;
    }

    public String Sm() {
        return this.bLF;
    }

    public void hm(String str) {
        this.bLF = str;
    }
}
