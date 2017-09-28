package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.f;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aUA;
    private List<f> aUB;
    private List<f> aUC;
    private List<Object> aUD;
    private boolean aUE;
    private boolean aUF;
    private int aUG;
    private boolean aUH;
    private String aUI;
    private String aUJ;
    private String aUK;
    private int aoZ;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aUE = false;
        this.aUF = false;
        this.aUG = 0;
        this.aUH = false;
    }

    public Object JT() {
        return this.aUA;
    }

    public void setExtraData(Object obj) {
        this.aUA = obj;
    }

    public List<f> getThreadList() {
        return this.aUB;
    }

    public void M(List<f> list) {
        this.aUB = list;
    }

    public List<Object> JU() {
        return this.aUD;
    }

    public void N(List<Object> list) {
        this.aUD = list;
    }

    public List<f> JV() {
        return this.aUC;
    }

    public void O(List<f> list) {
        this.aUC = list;
    }

    public boolean JW() {
        return this.aUE;
    }

    public void cj(boolean z) {
        this.aUE = z;
    }

    public boolean JX() {
        return this.aUF;
    }

    public void ck(boolean z) {
        this.aUF = z;
    }

    public int JY() {
        return this.aUG;
    }

    public void bY(int i) {
        this.aUG = i;
    }

    public int getSkinType() {
        return this.aoZ;
    }

    public void setSkinType(int i) {
        this.aoZ = i;
    }

    public boolean JZ() {
        return this.aUH;
    }

    public void cl(boolean z) {
        this.aUH = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void fY(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String Ka() {
        return this.aUI;
    }

    public void gY(String str) {
        this.aUI = str;
    }

    public String Kb() {
        return this.aUJ;
    }

    public void gZ(String str) {
        this.aUJ = str;
    }

    public String Kc() {
        return this.aUK;
    }

    public void ha(String str) {
        this.aUK = str;
    }
}
