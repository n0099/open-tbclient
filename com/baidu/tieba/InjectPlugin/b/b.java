package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.f;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aTS;
    private List<f> aTT;
    private List<f> aTU;
    private List<Object> aTV;
    private boolean aTW;
    private boolean aTX;
    private int aTY;
    private boolean aTZ;
    private String aUa;
    private String aUb;
    private String aUc;
    private int aql;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aTW = false;
        this.aTX = false;
        this.aTY = 0;
        this.aTZ = false;
    }

    public Object JB() {
        return this.aTS;
    }

    public void setExtraData(Object obj) {
        this.aTS = obj;
    }

    public List<f> getThreadList() {
        return this.aTT;
    }

    public void setThreadList(List<f> list) {
        this.aTT = list;
    }

    public List<Object> JC() {
        return this.aTV;
    }

    public void N(List<Object> list) {
        this.aTV = list;
    }

    public List<f> JD() {
        return this.aTU;
    }

    public void O(List<f> list) {
        this.aTU = list;
    }

    public boolean JE() {
        return this.aTW;
    }

    public void cj(boolean z) {
        this.aTW = z;
    }

    public boolean JF() {
        return this.aTX;
    }

    public void ck(boolean z) {
        this.aTX = z;
    }

    public int JG() {
        return this.aTY;
    }

    public void bX(int i) {
        this.aTY = i;
    }

    public int getSkinType() {
        return this.aql;
    }

    public void setSkinType(int i) {
        this.aql = i;
    }

    public boolean JH() {
        return this.aTZ;
    }

    public void cl(boolean z) {
        this.aTZ = z;
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
        return this.aUa;
    }

    public void hb(String str) {
        this.aUa = str;
    }

    public String JJ() {
        return this.aUb;
    }

    public void hc(String str) {
        this.aUb = str;
    }

    public String JK() {
        return this.aUc;
    }

    public void hd(String str) {
        this.aUc = str;
    }
}
