package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.f;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aTE;
    private List<f> aTF;
    private List<f> aTG;
    private List<Object> aTH;
    private boolean aTI;
    private boolean aTJ;
    private int aTK;
    private boolean aTL;
    private String aTM;
    private String aTN;
    private String aTO;
    private int apS;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aTI = false;
        this.aTJ = false;
        this.aTK = 0;
        this.aTL = false;
    }

    public Object JK() {
        return this.aTE;
    }

    public void setExtraData(Object obj) {
        this.aTE = obj;
    }

    public List<f> getThreadList() {
        return this.aTF;
    }

    public void setThreadList(List<f> list) {
        this.aTF = list;
    }

    public List<Object> JL() {
        return this.aTH;
    }

    public void N(List<Object> list) {
        this.aTH = list;
    }

    public List<f> JM() {
        return this.aTG;
    }

    public void O(List<f> list) {
        this.aTG = list;
    }

    public boolean JN() {
        return this.aTI;
    }

    public void ck(boolean z) {
        this.aTI = z;
    }

    public boolean JO() {
        return this.aTJ;
    }

    public void cl(boolean z) {
        this.aTJ = z;
    }

    public int JP() {
        return this.aTK;
    }

    public void bX(int i) {
        this.aTK = i;
    }

    public int getSkinType() {
        return this.apS;
    }

    public void setSkinType(int i) {
        this.apS = i;
    }

    public boolean JQ() {
        return this.aTL;
    }

    public void cm(boolean z) {
        this.aTL = z;
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
        return this.aTM;
    }

    public void ha(String str) {
        this.aTM = str;
    }

    public String JS() {
        return this.aTN;
    }

    public void hb(String str) {
        this.aTN = str;
    }

    public String JT() {
        return this.aTO;
    }

    public void hc(String str) {
        this.aTO = str;
    }
}
