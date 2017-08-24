package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.f;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aTU;
    private List<f> aTV;
    private List<f> aTW;
    private List<Object> aTX;
    private boolean aTY;
    private boolean aTZ;
    private int aUa;
    private boolean aUb;
    private String aUc;
    private String aUd;
    private String aUe;
    private int aqm;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aTY = false;
        this.aTZ = false;
        this.aUa = 0;
        this.aUb = false;
    }

    public Object JB() {
        return this.aTU;
    }

    public void setExtraData(Object obj) {
        this.aTU = obj;
    }

    public List<f> getThreadList() {
        return this.aTV;
    }

    public void setThreadList(List<f> list) {
        this.aTV = list;
    }

    public List<Object> JC() {
        return this.aTX;
    }

    public void N(List<Object> list) {
        this.aTX = list;
    }

    public List<f> JD() {
        return this.aTW;
    }

    public void O(List<f> list) {
        this.aTW = list;
    }

    public boolean JE() {
        return this.aTY;
    }

    public void cj(boolean z) {
        this.aTY = z;
    }

    public boolean JF() {
        return this.aTZ;
    }

    public void ck(boolean z) {
        this.aTZ = z;
    }

    public int JG() {
        return this.aUa;
    }

    public void bX(int i) {
        this.aUa = i;
    }

    public int getSkinType() {
        return this.aqm;
    }

    public void setSkinType(int i) {
        this.aqm = i;
    }

    public boolean JH() {
        return this.aUb;
    }

    public void cl(boolean z) {
        this.aUb = z;
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
        return this.aUc;
    }

    public void he(String str) {
        this.aUc = str;
    }

    public String JJ() {
        return this.aUd;
    }

    public void hf(String str) {
        this.aUd = str;
    }

    public String JK() {
        return this.aUe;
    }

    public void hg(String str) {
        this.aUe = str;
    }
}
