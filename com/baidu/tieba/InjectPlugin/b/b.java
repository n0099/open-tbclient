package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.i;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object bLD;
    private List<i> bLE;
    private List<i> bLF;
    private List<Object> bLG;
    private boolean bLH;
    private boolean bLI;
    private int bLJ;
    private boolean bLK;
    private String bLL;
    private String bLM;
    private String bLN;
    private int bdK;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bLH = false;
        this.bLI = false;
        this.bLJ = 0;
        this.bLK = false;
    }

    public Object RS() {
        return this.bLD;
    }

    public void setExtraData(Object obj) {
        this.bLD = obj;
    }

    public List<i> getThreadList() {
        return this.bLE;
    }

    public void V(List<i> list) {
        this.bLE = list;
    }

    public List<Object> RT() {
        return this.bLG;
    }

    public void W(List<Object> list) {
        this.bLG = list;
    }

    public List<i> RU() {
        return this.bLF;
    }

    public void X(List<i> list) {
        this.bLF = list;
    }

    public boolean RV() {
        return this.bLH;
    }

    public void cK(boolean z) {
        this.bLH = z;
    }

    public boolean isRefresh() {
        return this.bLI;
    }

    public void cL(boolean z) {
        this.bLI = z;
    }

    public int RW() {
        return this.bLJ;
    }

    public void eW(int i) {
        this.bLJ = i;
    }

    public int getSkinType() {
        return this.bdK;
    }

    public void setSkinType(int i) {
        this.bdK = i;
    }

    public boolean RX() {
        return this.bLK;
    }

    public void cM(boolean z) {
        this.bLK = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void ji(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String RY() {
        return this.bLL;
    }

    public void hl(String str) {
        this.bLL = str;
    }

    public String RZ() {
        return this.bLM;
    }

    public void hm(String str) {
        this.bLM = str;
    }

    public String Sa() {
        return this.bLN;
    }

    public void hn(String str) {
        this.bLN = str;
    }
}
