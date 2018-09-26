package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int aCJ;
    private List<Object> bnA;
    private boolean bnB;
    private boolean bnC;
    private boolean bnD;
    private String bnE;
    private String bnF;
    private String bnG;
    private Object bnx;
    private List<h> bny;
    private List<h> bnz;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bnB = false;
        this.bnC = false;
        this.currentPage = 0;
        this.bnD = false;
    }

    public Object QL() {
        return this.bnx;
    }

    public void setExtraData(Object obj) {
        this.bnx = obj;
    }

    public List<h> getThreadList() {
        return this.bny;
    }

    public void S(List<h> list) {
        this.bny = list;
    }

    public List<Object> QM() {
        return this.bnA;
    }

    public void T(List<Object> list) {
        this.bnA = list;
    }

    public List<h> QN() {
        return this.bnz;
    }

    public void U(List<h> list) {
        this.bnz = list;
    }

    public boolean QO() {
        return this.bnB;
    }

    public void cG(boolean z) {
        this.bnB = z;
    }

    public boolean isRefresh() {
        return this.bnC;
    }

    public void cH(boolean z) {
        this.bnC = z;
    }

    public int QP() {
        return this.currentPage;
    }

    public void cj(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.aCJ;
    }

    public void setSkinType(int i) {
        this.aCJ = i;
    }

    public boolean QQ() {
        return this.bnD;
    }

    public void cI(boolean z) {
        this.bnD = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void gK(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String QR() {
        return this.bnE;
    }

    public void ix(String str) {
        this.bnE = str;
    }

    public String QS() {
        return this.bnF;
    }

    public void iy(String str) {
        this.bnF = str;
    }

    public String QT() {
        return this.bnG;
    }

    public void iz(String str) {
        this.bnG = str;
    }
}
