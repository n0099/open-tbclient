package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.f;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private String aUA;
    private String aUB;
    private String aUC;
    private Object aUs;
    private List<f> aUt;
    private List<f> aUu;
    private List<Object> aUv;
    private boolean aUw;
    private boolean aUx;
    private int aUy;
    private boolean aUz;
    private int api;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aUw = false;
        this.aUx = false;
        this.aUy = 0;
        this.aUz = false;
    }

    public Object JX() {
        return this.aUs;
    }

    public void setExtraData(Object obj) {
        this.aUs = obj;
    }

    public List<f> getThreadList() {
        return this.aUt;
    }

    public void N(List<f> list) {
        this.aUt = list;
    }

    public List<Object> JY() {
        return this.aUv;
    }

    public void O(List<Object> list) {
        this.aUv = list;
    }

    public List<f> JZ() {
        return this.aUu;
    }

    public void P(List<f> list) {
        this.aUu = list;
    }

    public boolean Ka() {
        return this.aUw;
    }

    public void ce(boolean z) {
        this.aUw = z;
    }

    public boolean isRefresh() {
        return this.aUx;
    }

    public void cf(boolean z) {
        this.aUx = z;
    }

    public int Kb() {
        return this.aUy;
    }

    public void bX(int i) {
        this.aUy = i;
    }

    public int getSkinType() {
        return this.api;
    }

    public void setSkinType(int i) {
        this.api = i;
    }

    public boolean Kc() {
        return this.aUz;
    }

    public void cg(boolean z) {
        this.aUz = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void gg(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String Kd() {
        return this.aUA;
    }

    public void hf(String str) {
        this.aUA = str;
    }

    public String Ke() {
        return this.aUB;
    }

    public void hg(String str) {
        this.aUB = str;
    }

    public String Kf() {
        return this.aUC;
    }

    public void hh(String str) {
        this.aUC = str;
    }
}
