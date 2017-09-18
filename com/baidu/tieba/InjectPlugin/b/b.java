package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.f;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aTB;
    private List<f> aTC;
    private List<f> aTD;
    private List<Object> aTE;
    private boolean aTF;
    private boolean aTG;
    private int aTH;
    private boolean aTI;
    private String aTJ;
    private String aTK;
    private String aTL;
    private int apQ;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aTF = false;
        this.aTG = false;
        this.aTH = 0;
        this.aTI = false;
    }

    public Object JK() {
        return this.aTB;
    }

    public void setExtraData(Object obj) {
        this.aTB = obj;
    }

    public List<f> getThreadList() {
        return this.aTC;
    }

    public void setThreadList(List<f> list) {
        this.aTC = list;
    }

    public List<Object> JL() {
        return this.aTE;
    }

    public void N(List<Object> list) {
        this.aTE = list;
    }

    public List<f> JM() {
        return this.aTD;
    }

    public void O(List<f> list) {
        this.aTD = list;
    }

    public boolean JN() {
        return this.aTF;
    }

    public void ck(boolean z) {
        this.aTF = z;
    }

    public boolean JO() {
        return this.aTG;
    }

    public void cl(boolean z) {
        this.aTG = z;
    }

    public int JP() {
        return this.aTH;
    }

    public void bX(int i) {
        this.aTH = i;
    }

    public int getSkinType() {
        return this.apQ;
    }

    public void setSkinType(int i) {
        this.apQ = i;
    }

    public boolean JQ() {
        return this.aTI;
    }

    public void cm(boolean z) {
        this.aTI = z;
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

    public String JR() {
        return this.aTJ;
    }

    public void ha(String str) {
        this.aTJ = str;
    }

    public String JS() {
        return this.aTK;
    }

    public void hb(String str) {
        this.aTK = str;
    }

    public String JT() {
        return this.aTL;
    }

    public void hc(String str) {
        this.aTL = str;
    }
}
