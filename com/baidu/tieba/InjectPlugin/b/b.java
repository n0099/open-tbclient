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
    private int aph;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aUE = false;
        this.aUF = false;
        this.aUG = 0;
        this.aUH = false;
    }

    public Object Ki() {
        return this.aUA;
    }

    public void setExtraData(Object obj) {
        this.aUA = obj;
    }

    public List<f> getThreadList() {
        return this.aUB;
    }

    public void N(List<f> list) {
        this.aUB = list;
    }

    public List<Object> Kj() {
        return this.aUD;
    }

    public void O(List<Object> list) {
        this.aUD = list;
    }

    public List<f> Kk() {
        return this.aUC;
    }

    public void P(List<f> list) {
        this.aUC = list;
    }

    public boolean Kl() {
        return this.aUE;
    }

    public void cf(boolean z) {
        this.aUE = z;
    }

    public boolean isRefresh() {
        return this.aUF;
    }

    public void cg(boolean z) {
        this.aUF = z;
    }

    public int Km() {
        return this.aUG;
    }

    public void bX(int i) {
        this.aUG = i;
    }

    public int getSkinType() {
        return this.aph;
    }

    public void setSkinType(int i) {
        this.aph = i;
    }

    public boolean Kn() {
        return this.aUH;
    }

    public void ch(boolean z) {
        this.aUH = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void gf(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String Ko() {
        return this.aUI;
    }

    public void hg(String str) {
        this.aUI = str;
    }

    public String Kp() {
        return this.aUJ;
    }

    public void hh(String str) {
        this.aUJ = str;
    }

    public String Kq() {
        return this.aUK;
    }

    public void hi(String str) {
        this.aUK = str;
    }
}
