package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.i;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object bNP;
    private List<i> bNQ;
    private List<i> bNR;
    private List<Object> bNS;
    private boolean bNT;
    private boolean bNU;
    private int bNV;
    private boolean bNW;
    private String bNX;
    private String bNY;
    private String bNZ;
    private int bfL;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bNT = false;
        this.bNU = false;
        this.bNV = 0;
        this.bNW = false;
    }

    public Object Sy() {
        return this.bNP;
    }

    public void setExtraData(Object obj) {
        this.bNP = obj;
    }

    public List<i> getThreadList() {
        return this.bNQ;
    }

    public void X(List<i> list) {
        this.bNQ = list;
    }

    public List<Object> Sz() {
        return this.bNS;
    }

    public void Y(List<Object> list) {
        this.bNS = list;
    }

    public List<i> SA() {
        return this.bNR;
    }

    public void Z(List<i> list) {
        this.bNR = list;
    }

    public boolean SB() {
        return this.bNT;
    }

    public void cP(boolean z) {
        this.bNT = z;
    }

    public boolean isRefresh() {
        return this.bNU;
    }

    public void cQ(boolean z) {
        this.bNU = z;
    }

    public int SC() {
        return this.bNV;
    }

    public void eW(int i) {
        this.bNV = i;
    }

    public int getSkinType() {
        return this.bfL;
    }

    public void setSkinType(int i) {
        this.bfL = i;
    }

    public boolean SD() {
        return this.bNW;
    }

    public void cR(boolean z) {
        this.bNW = z;
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
        return this.bNX;
    }

    public void hC(String str) {
        this.bNX = str;
    }

    public String SF() {
        return this.bNY;
    }

    public void hD(String str) {
        this.bNY = str;
    }

    public String SG() {
        return this.bNZ;
    }

    public void hE(String str) {
        this.bNZ = str;
    }
}
