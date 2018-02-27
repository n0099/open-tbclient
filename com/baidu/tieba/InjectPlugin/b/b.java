package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.i;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object bNC;
    private List<i> bND;
    private List<i> bNE;
    private List<Object> bNF;
    private boolean bNG;
    private boolean bNH;
    private int bNI;
    private boolean bNJ;
    private String bNK;
    private String bNL;
    private String bNM;
    private int bfz;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bNG = false;
        this.bNH = false;
        this.bNI = 0;
        this.bNJ = false;
    }

    public Object Sx() {
        return this.bNC;
    }

    public void setExtraData(Object obj) {
        this.bNC = obj;
    }

    public List<i> getThreadList() {
        return this.bND;
    }

    public void X(List<i> list) {
        this.bND = list;
    }

    public List<Object> Sy() {
        return this.bNF;
    }

    public void Y(List<Object> list) {
        this.bNF = list;
    }

    public List<i> Sz() {
        return this.bNE;
    }

    public void Z(List<i> list) {
        this.bNE = list;
    }

    public boolean SA() {
        return this.bNG;
    }

    public void cP(boolean z) {
        this.bNG = z;
    }

    public boolean isRefresh() {
        return this.bNH;
    }

    public void cQ(boolean z) {
        this.bNH = z;
    }

    public int SB() {
        return this.bNI;
    }

    public void eW(int i) {
        this.bNI = i;
    }

    public int getSkinType() {
        return this.bfz;
    }

    public void setSkinType(int i) {
        this.bfz = i;
    }

    public boolean SC() {
        return this.bNJ;
    }

    public void cR(boolean z) {
        this.bNJ = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void je(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String SD() {
        return this.bNK;
    }

    public void hC(String str) {
        this.bNK = str;
    }

    public String SE() {
        return this.bNL;
    }

    public void hD(String str) {
        this.bNL = str;
    }

    public String SF() {
        return this.bNM;
    }

    public void hE(String str) {
        this.bNM = str;
    }
}
