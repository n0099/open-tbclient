package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private List<Object> aRA;
    private boolean aRB;
    private boolean aRC;
    private int aRD;
    private boolean aRE;
    private String aRF;
    private String aRG;
    private String aRH;
    private Object aRx;
    private List<v> aRy;
    private List<v> aRz;
    private int aoa;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aRB = false;
        this.aRC = false;
        this.aRD = 0;
        this.aRE = false;
    }

    public Object Jj() {
        return this.aRx;
    }

    public void setExtraData(Object obj) {
        this.aRx = obj;
    }

    public List<v> getThreadList() {
        return this.aRy;
    }

    public void setThreadList(List<v> list) {
        this.aRy = list;
    }

    public List<Object> Jk() {
        return this.aRA;
    }

    public void K(List<Object> list) {
        this.aRA = list;
    }

    public List<v> Jl() {
        return this.aRz;
    }

    public void L(List<v> list) {
        this.aRz = list;
    }

    public boolean Jm() {
        return this.aRB;
    }

    public void cg(boolean z) {
        this.aRB = z;
    }

    public boolean Jn() {
        return this.aRC;
    }

    public void ch(boolean z) {
        this.aRC = z;
    }

    public int Jo() {
        return this.aRD;
    }

    public void bW(int i) {
        this.aRD = i;
    }

    public int getSkinType() {
        return this.aoa;
    }

    public void setSkinType(int i) {
        this.aoa = i;
    }

    public boolean Jp() {
        return this.aRE;
    }

    public void ci(boolean z) {
        this.aRE = z;
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

    public String Jq() {
        return this.aRF;
    }

    public void gQ(String str) {
        this.aRF = str;
    }

    public String Jr() {
        return this.aRG;
    }

    public void gR(String str) {
        this.aRG = str;
    }

    public String Js() {
        return this.aRH;
    }

    public void gS(String str) {
        this.aRH = str;
    }
}
