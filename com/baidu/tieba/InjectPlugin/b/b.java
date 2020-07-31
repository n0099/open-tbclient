package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object agK;
    private int aho;
    private int currentPage;
    private List<q> eZc;
    private List<q> eZd;
    private List<Object> eZe;
    private boolean eZf;
    private boolean eZg;
    private boolean eZh;
    private String eZi;
    private String eZj;
    private String eZk;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.eZf = false;
        this.eZg = false;
        this.currentPage = 0;
        this.eZh = false;
    }

    public Object sm() {
        return this.agK;
    }

    public void setExtraData(Object obj) {
        this.agK = obj;
    }

    public List<q> getThreadList() {
        return this.eZc;
    }

    public void bm(List<q> list) {
        this.eZc = list;
    }

    public List<Object> bqB() {
        return this.eZe;
    }

    public void bn(List<Object> list) {
        this.eZe = list;
    }

    public List<q> bqC() {
        return this.eZd;
    }

    public void bo(List<q> list) {
        this.eZd = list;
    }

    public boolean bqD() {
        return this.eZf;
    }

    public void jG(boolean z) {
        this.eZf = z;
    }

    public boolean bqE() {
        return this.eZg;
    }

    public void jH(boolean z) {
        this.eZg = z;
    }

    public int bqF() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.aho;
    }

    public void setSkinType(int i) {
        this.aho = i;
    }

    public boolean bqG() {
        return this.eZh;
    }

    public void jI(boolean z) {
        this.eZh = z;
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

    public String bqH() {
        return this.eZi;
    }

    public void AH(String str) {
        this.eZi = str;
    }

    public String bqI() {
        return this.eZj;
    }

    public void AI(String str) {
        this.eZj = str;
    }

    public String bqJ() {
        return this.eZk;
    }

    public void AJ(String str) {
        this.eZk = str;
    }
}
