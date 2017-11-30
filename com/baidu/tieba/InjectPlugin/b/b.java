package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.f;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aXB;
    private List<f> aXC;
    private List<f> aXD;
    private List<Object> aXE;
    private boolean aXF;
    private boolean aXG;
    private int aXH;
    private boolean aXI;
    private String aXJ;
    private String aXK;
    private String aXL;
    private int apA;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aXF = false;
        this.aXG = false;
        this.aXH = 0;
        this.aXI = false;
    }

    public Object KF() {
        return this.aXB;
    }

    public void setExtraData(Object obj) {
        this.aXB = obj;
    }

    public List<f> getThreadList() {
        return this.aXC;
    }

    public void O(List<f> list) {
        this.aXC = list;
    }

    public List<Object> KG() {
        return this.aXE;
    }

    public void P(List<Object> list) {
        this.aXE = list;
    }

    public List<f> KH() {
        return this.aXD;
    }

    public void Q(List<f> list) {
        this.aXD = list;
    }

    public boolean KI() {
        return this.aXF;
    }

    public void ci(boolean z) {
        this.aXF = z;
    }

    public boolean isRefresh() {
        return this.aXG;
    }

    public void cj(boolean z) {
        this.aXG = z;
    }

    public int KJ() {
        return this.aXH;
    }

    public void bY(int i) {
        this.aXH = i;
    }

    public int getSkinType() {
        return this.apA;
    }

    public void setSkinType(int i) {
        this.apA = i;
    }

    public boolean KK() {
        return this.aXI;
    }

    public void ck(boolean z) {
        this.aXI = z;
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
        return this.aXJ;
    }

    public void hj(String str) {
        this.aXJ = str;
    }

    public String KM() {
        return this.aXK;
    }

    public void hk(String str) {
        this.aXK = str;
    }

    public String KN() {
        return this.aXL;
    }

    public void hl(String str) {
        this.aXL = str;
    }
}
