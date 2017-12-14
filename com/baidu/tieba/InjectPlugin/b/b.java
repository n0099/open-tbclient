package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.f;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aXD;
    private List<f> aXE;
    private List<f> aXF;
    private List<Object> aXG;
    private boolean aXH;
    private boolean aXI;
    private int aXJ;
    private boolean aXK;
    private String aXL;
    private String aXM;
    private String aXN;
    private int apD;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aXH = false;
        this.aXI = false;
        this.aXJ = 0;
        this.aXK = false;
    }

    public Object KF() {
        return this.aXD;
    }

    public void setExtraData(Object obj) {
        this.aXD = obj;
    }

    public List<f> getThreadList() {
        return this.aXE;
    }

    public void O(List<f> list) {
        this.aXE = list;
    }

    public List<Object> KG() {
        return this.aXG;
    }

    public void P(List<Object> list) {
        this.aXG = list;
    }

    public List<f> KH() {
        return this.aXF;
    }

    public void Q(List<f> list) {
        this.aXF = list;
    }

    public boolean KI() {
        return this.aXH;
    }

    public void cj(boolean z) {
        this.aXH = z;
    }

    public boolean isRefresh() {
        return this.aXI;
    }

    public void ck(boolean z) {
        this.aXI = z;
    }

    public int KJ() {
        return this.aXJ;
    }

    public void bY(int i) {
        this.aXJ = i;
    }

    public int getSkinType() {
        return this.apD;
    }

    public void setSkinType(int i) {
        this.apD = i;
    }

    public boolean KK() {
        return this.aXK;
    }

    public void cl(boolean z) {
        this.aXK = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void gn(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String KL() {
        return this.aXL;
    }

    public void hh(String str) {
        this.aXL = str;
    }

    public String KM() {
        return this.aXM;
    }

    public void hi(String str) {
        this.aXM = str;
    }

    public String KN() {
        return this.aXN;
    }

    public void hj(String str) {
        this.aXN = str;
    }
}
