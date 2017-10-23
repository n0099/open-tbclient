package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.f;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aUn;
    private List<f> aUo;
    private List<f> aUp;
    private List<Object> aUq;
    private boolean aUr;
    private boolean aUs;
    private int aUt;
    private boolean aUu;
    private String aUv;
    private String aUw;
    private String aUx;
    private int aoN;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aUr = false;
        this.aUs = false;
        this.aUt = 0;
        this.aUu = false;
    }

    public Object JN() {
        return this.aUn;
    }

    public void setExtraData(Object obj) {
        this.aUn = obj;
    }

    public List<f> getThreadList() {
        return this.aUo;
    }

    public void M(List<f> list) {
        this.aUo = list;
    }

    public List<Object> JO() {
        return this.aUq;
    }

    public void N(List<Object> list) {
        this.aUq = list;
    }

    public List<f> JP() {
        return this.aUp;
    }

    public void O(List<f> list) {
        this.aUp = list;
    }

    public boolean JQ() {
        return this.aUr;
    }

    public void ci(boolean z) {
        this.aUr = z;
    }

    public boolean JR() {
        return this.aUs;
    }

    public void cj(boolean z) {
        this.aUs = z;
    }

    public int JS() {
        return this.aUt;
    }

    public void bX(int i) {
        this.aUt = i;
    }

    public int getSkinType() {
        return this.aoN;
    }

    public void setSkinType(int i) {
        this.aoN = i;
    }

    public boolean JT() {
        return this.aUu;
    }

    public void ck(boolean z) {
        this.aUu = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void fX(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String JU() {
        return this.aUv;
    }

    public void gX(String str) {
        this.aUv = str;
    }

    public String JV() {
        return this.aUw;
    }

    public void gY(String str) {
        this.aUw = str;
    }

    public String JW() {
        return this.aUx;
    }

    public void gZ(String str) {
        this.aUx = str;
    }
}
