package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object Xo;
    private List<m> cPW;
    private List<m> cPX;
    private List<Object> cPY;
    private boolean cPZ;
    private boolean cQa;
    private boolean cQb;
    private String cQc;
    private String cQd;
    private String cQe;
    private int ccJ;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.cPZ = false;
        this.cQa = false;
        this.currentPage = 0;
        this.cQb = false;
    }

    public Object qy() {
        return this.Xo;
    }

    public void setExtraData(Object obj) {
        this.Xo = obj;
    }

    public List<m> getThreadList() {
        return this.cPW;
    }

    public void av(List<m> list) {
        this.cPW = list;
    }

    public List<Object> azu() {
        return this.cPY;
    }

    public void aw(List<Object> list) {
        this.cPY = list;
    }

    public List<m> azv() {
        return this.cPX;
    }

    public void ax(List<m> list) {
        this.cPX = list;
    }

    public boolean azw() {
        return this.cPZ;
    }

    public void fX(boolean z) {
        this.cPZ = z;
    }

    public boolean isRefresh() {
        return this.cQa;
    }

    public void fY(boolean z) {
        this.cQa = z;
    }

    public int azx() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.ccJ;
    }

    public void setSkinType(int i) {
        this.ccJ = i;
    }

    public boolean azy() {
        return this.cQb;
    }

    public void fZ(boolean z) {
        this.cQb = z;
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
        return this.cQc;
    }

    public void ro(String str) {
        this.cQc = str;
    }

    public String azA() {
        return this.cQd;
    }

    public void rp(String str) {
        this.cQd = str;
    }

    public String azB() {
        return this.cQe;
    }

    public void rq(String str) {
        this.cQe = str;
    }
}
