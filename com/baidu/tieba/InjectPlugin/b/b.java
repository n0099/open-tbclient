package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.f;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aSG;
    private List<f> aSH;
    private List<f> aSI;
    private List<Object> aSJ;
    private boolean aSK;
    private boolean aSL;
    private int aSM;
    private boolean aSN;
    private String aSO;
    private String aSP;
    private String aSQ;
    private int aoR;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aSK = false;
        this.aSL = false;
        this.aSM = 0;
        this.aSN = false;
    }

    public Object Jv() {
        return this.aSG;
    }

    public void setExtraData(Object obj) {
        this.aSG = obj;
    }

    public List<f> getThreadList() {
        return this.aSH;
    }

    public void setThreadList(List<f> list) {
        this.aSH = list;
    }

    public List<Object> Jw() {
        return this.aSJ;
    }

    public void N(List<Object> list) {
        this.aSJ = list;
    }

    public List<f> Jx() {
        return this.aSI;
    }

    public void O(List<f> list) {
        this.aSI = list;
    }

    public boolean Jy() {
        return this.aSK;
    }

    public void cj(boolean z) {
        this.aSK = z;
    }

    public boolean Jz() {
        return this.aSL;
    }

    public void ck(boolean z) {
        this.aSL = z;
    }

    public int JA() {
        return this.aSM;
    }

    public void bV(int i) {
        this.aSM = i;
    }

    public int getSkinType() {
        return this.aoR;
    }

    public void setSkinType(int i) {
        this.aoR = i;
    }

    public boolean JB() {
        return this.aSN;
    }

    public void cl(boolean z) {
        this.aSN = z;
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

    public String JC() {
        return this.aSO;
    }

    public void gW(String str) {
        this.aSO = str;
    }

    public String JD() {
        return this.aSP;
    }

    public void gX(String str) {
        this.aSP = str;
    }

    public String JE() {
        return this.aSQ;
    }

    public void gY(String str) {
        this.aSQ = str;
    }
}
