package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.i;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object bNF;
    private List<i> bNG;
    private List<i> bNH;
    private List<Object> bNI;
    private boolean bNJ;
    private boolean bNK;
    private int bNL;
    private boolean bNM;
    private String bNN;
    private String bNO;
    private String bNP;
    private int bfC;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bNJ = false;
        this.bNK = false;
        this.bNL = 0;
        this.bNM = false;
    }

    public Object Sy() {
        return this.bNF;
    }

    public void setExtraData(Object obj) {
        this.bNF = obj;
    }

    public List<i> getThreadList() {
        return this.bNG;
    }

    public void X(List<i> list) {
        this.bNG = list;
    }

    public List<Object> Sz() {
        return this.bNI;
    }

    public void Y(List<Object> list) {
        this.bNI = list;
    }

    public List<i> SA() {
        return this.bNH;
    }

    public void Z(List<i> list) {
        this.bNH = list;
    }

    public boolean SB() {
        return this.bNJ;
    }

    public void cP(boolean z) {
        this.bNJ = z;
    }

    public boolean isRefresh() {
        return this.bNK;
    }

    public void cQ(boolean z) {
        this.bNK = z;
    }

    public int SC() {
        return this.bNL;
    }

    public void eW(int i) {
        this.bNL = i;
    }

    public int getSkinType() {
        return this.bfC;
    }

    public void setSkinType(int i) {
        this.bfC = i;
    }

    public boolean SD() {
        return this.bNM;
    }

    public void cR(boolean z) {
        this.bNM = z;
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

    public String SE() {
        return this.bNN;
    }

    public void hC(String str) {
        this.bNN = str;
    }

    public String SF() {
        return this.bNO;
    }

    public void hD(String str) {
        this.bNO = str;
    }

    public String SG() {
        return this.bNP;
    }

    public void hE(String str) {
        this.bNP = str;
    }
}
