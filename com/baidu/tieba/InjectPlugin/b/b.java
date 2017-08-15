package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.f;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aTT;
    private List<f> aTU;
    private List<f> aTV;
    private List<Object> aTW;
    private boolean aTX;
    private boolean aTY;
    private int aTZ;
    private boolean aUa;
    private String aUb;
    private String aUc;
    private String aUd;
    private int aqm;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aTX = false;
        this.aTY = false;
        this.aTZ = 0;
        this.aUa = false;
    }

    public Object JB() {
        return this.aTT;
    }

    public void setExtraData(Object obj) {
        this.aTT = obj;
    }

    public List<f> getThreadList() {
        return this.aTU;
    }

    public void setThreadList(List<f> list) {
        this.aTU = list;
    }

    public List<Object> JC() {
        return this.aTW;
    }

    public void N(List<Object> list) {
        this.aTW = list;
    }

    public List<f> JD() {
        return this.aTV;
    }

    public void O(List<f> list) {
        this.aTV = list;
    }

    public boolean JE() {
        return this.aTX;
    }

    public void cj(boolean z) {
        this.aTX = z;
    }

    public boolean JF() {
        return this.aTY;
    }

    public void ck(boolean z) {
        this.aTY = z;
    }

    public int JG() {
        return this.aTZ;
    }

    public void bX(int i) {
        this.aTZ = i;
    }

    public int getSkinType() {
        return this.aqm;
    }

    public void setSkinType(int i) {
        this.aqm = i;
    }

    public boolean JH() {
        return this.aUa;
    }

    public void cl(boolean z) {
        this.aUa = z;
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

    public String JI() {
        return this.aUb;
    }

    public void hb(String str) {
        this.aUb = str;
    }

    public String JJ() {
        return this.aUc;
    }

    public void hc(String str) {
        this.aUc = str;
    }

    public String JK() {
        return this.aUd;
    }

    public void hd(String str) {
        this.aUd = str;
    }
}
