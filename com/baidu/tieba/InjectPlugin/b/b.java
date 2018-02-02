package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.i;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object bLL;
    private List<i> bLM;
    private List<i> bLN;
    private List<Object> bLO;
    private boolean bLP;
    private boolean bLQ;
    private int bLR;
    private boolean bLS;
    private String bLT;
    private String bLU;
    private String bLV;
    private int bdS;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bLP = false;
        this.bLQ = false;
        this.bLR = 0;
        this.bLS = false;
    }

    public Object RU() {
        return this.bLL;
    }

    public void setExtraData(Object obj) {
        this.bLL = obj;
    }

    public List<i> getThreadList() {
        return this.bLM;
    }

    public void V(List<i> list) {
        this.bLM = list;
    }

    public List<Object> RV() {
        return this.bLO;
    }

    public void W(List<Object> list) {
        this.bLO = list;
    }

    public List<i> RW() {
        return this.bLN;
    }

    public void X(List<i> list) {
        this.bLN = list;
    }

    public boolean RX() {
        return this.bLP;
    }

    public void cL(boolean z) {
        this.bLP = z;
    }

    public boolean isRefresh() {
        return this.bLQ;
    }

    public void cM(boolean z) {
        this.bLQ = z;
    }

    public int RY() {
        return this.bLR;
    }

    public void eW(int i) {
        this.bLR = i;
    }

    public int getSkinType() {
        return this.bdS;
    }

    public void setSkinType(int i) {
        this.bdS = i;
    }

    public boolean RZ() {
        return this.bLS;
    }

    public void cN(boolean z) {
        this.bLS = z;
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

    public String Sa() {
        return this.bLT;
    }

    public void ht(String str) {
        this.bLT = str;
    }

    public String Sb() {
        return this.bLU;
    }

    public void hu(String str) {
        this.bLU = str;
    }

    public String Sc() {
        return this.bLV;
    }

    public void hv(String str) {
        this.bLV = str;
    }
}
