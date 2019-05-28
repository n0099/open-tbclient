package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object Xp;
    private List<m> cPV;
    private List<m> cPW;
    private List<Object> cPX;
    private boolean cPY;
    private boolean cPZ;
    private boolean cQa;
    private String cQb;
    private String cQc;
    private String cQd;
    private int ccI;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.cPY = false;
        this.cPZ = false;
        this.currentPage = 0;
        this.cQa = false;
    }

    public Object qy() {
        return this.Xp;
    }

    public void setExtraData(Object obj) {
        this.Xp = obj;
    }

    public List<m> getThreadList() {
        return this.cPV;
    }

    public void av(List<m> list) {
        this.cPV = list;
    }

    public List<Object> azu() {
        return this.cPX;
    }

    public void aw(List<Object> list) {
        this.cPX = list;
    }

    public List<m> azv() {
        return this.cPW;
    }

    public void ax(List<m> list) {
        this.cPW = list;
    }

    public boolean azw() {
        return this.cPY;
    }

    public void fX(boolean z) {
        this.cPY = z;
    }

    public boolean isRefresh() {
        return this.cPZ;
    }

    public void fY(boolean z) {
        this.cPZ = z;
    }

    public int azx() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.ccI;
    }

    public void setSkinType(int i) {
        this.ccI = i;
    }

    public boolean azy() {
        return this.cQa;
    }

    public void fZ(boolean z) {
        this.cQa = z;
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

    public String azz() {
        return this.cQb;
    }

    public void rp(String str) {
        this.cQb = str;
    }

    public String azA() {
        return this.cQc;
    }

    public void rq(String str) {
        this.cQc = str;
    }

    public String azB() {
        return this.cQd;
    }

    public void rr(String str) {
        this.cQd = str;
    }
}
