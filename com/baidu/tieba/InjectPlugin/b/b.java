package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.f;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aXH;
    private List<f> aXI;
    private List<f> aXJ;
    private List<Object> aXK;
    private boolean aXL;
    private boolean aXM;
    private int aXN;
    private boolean aXO;
    private String aXP;
    private String aXQ;
    private String aXR;
    private int apG;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aXL = false;
        this.aXM = false;
        this.aXN = 0;
        this.aXO = false;
    }

    public Object KF() {
        return this.aXH;
    }

    public void setExtraData(Object obj) {
        this.aXH = obj;
    }

    public List<f> getThreadList() {
        return this.aXI;
    }

    public void O(List<f> list) {
        this.aXI = list;
    }

    public List<Object> KG() {
        return this.aXK;
    }

    public void P(List<Object> list) {
        this.aXK = list;
    }

    public List<f> KH() {
        return this.aXJ;
    }

    public void Q(List<f> list) {
        this.aXJ = list;
    }

    public boolean KI() {
        return this.aXL;
    }

    public void cj(boolean z) {
        this.aXL = z;
    }

    public boolean isRefresh() {
        return this.aXM;
    }

    public void ck(boolean z) {
        this.aXM = z;
    }

    public int KJ() {
        return this.aXN;
    }

    public void bY(int i) {
        this.aXN = i;
    }

    public int getSkinType() {
        return this.apG;
    }

    public void setSkinType(int i) {
        this.apG = i;
    }

    public boolean KK() {
        return this.aXO;
    }

    public void cl(boolean z) {
        this.aXO = z;
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
        return this.aXP;
    }

    public void hh(String str) {
        this.aXP = str;
    }

    public String KM() {
        return this.aXQ;
    }

    public void hi(String str) {
        this.aXQ = str;
    }

    public String KN() {
        return this.aXR;
    }

    public void hj(String str) {
        this.aXR = str;
    }
}
