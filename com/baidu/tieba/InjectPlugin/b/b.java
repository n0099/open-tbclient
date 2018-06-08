package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int ayX;
    private Object bfL;
    private List<h> bfM;
    private List<h> bfN;
    private List<Object> bfO;
    private boolean bfP;
    private boolean bfQ;
    private boolean bfR;
    private String bfS;
    private String bfT;
    private String bfU;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bfP = false;
        this.bfQ = false;
        this.currentPage = 0;
        this.bfR = false;
    }

    public Object Ot() {
        return this.bfL;
    }

    public void setExtraData(Object obj) {
        this.bfL = obj;
    }

    public List<h> getThreadList() {
        return this.bfM;
    }

    public void R(List<h> list) {
        this.bfM = list;
    }

    public List<Object> Ou() {
        return this.bfO;
    }

    public void S(List<Object> list) {
        this.bfO = list;
    }

    public List<h> Ov() {
        return this.bfN;
    }

    public void T(List<h> list) {
        this.bfN = list;
    }

    public boolean Ow() {
        return this.bfP;
    }

    public void cl(boolean z) {
        this.bfP = z;
    }

    public boolean isRefresh() {
        return this.bfQ;
    }

    public void cm(boolean z) {
        this.bfQ = z;
    }

    public int Ox() {
        return this.currentPage;
    }

    public void bX(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.ayX;
    }

    public void setSkinType(int i) {
        this.ayX = i;
    }

    public boolean Oy() {
        return this.bfR;
    }

    public void cn(boolean z) {
        this.bfR = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void ge(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String Oz() {
        return this.bfS;
    }

    public void hU(String str) {
        this.bfS = str;
    }

    public String OA() {
        return this.bfT;
    }

    public void hV(String str) {
        this.bfT = str;
    }

    public String OB() {
        return this.bfU;
    }

    public void hW(String str) {
        this.bfU = str;
    }
}
