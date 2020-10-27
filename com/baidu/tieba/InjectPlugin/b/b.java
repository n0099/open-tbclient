package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aiJ;
    private int ajq;
    private int currentPage;
    private List<q> fIa;
    private List<q> fIb;
    private List<Object> fIc;
    private boolean fId;
    private boolean fIe;
    private boolean fIf;
    private String fIg;
    private String fIh;
    private String fIi;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.fId = false;
        this.fIe = false;
        this.currentPage = 0;
        this.fIf = false;
    }

    public Object ud() {
        return this.aiJ;
    }

    public void setExtraData(Object obj) {
        this.aiJ = obj;
    }

    public List<q> getThreadList() {
        return this.fIa;
    }

    public void bD(List<q> list) {
        this.fIa = list;
    }

    public List<Object> bFo() {
        return this.fIc;
    }

    public void bE(List<Object> list) {
        this.fIc = list;
    }

    public List<q> bFp() {
        return this.fIb;
    }

    public void bF(List<q> list) {
        this.fIb = list;
    }

    public boolean bFq() {
        return this.fId;
    }

    public void kS(boolean z) {
        this.fId = z;
    }

    public boolean bFr() {
        return this.fIe;
    }

    public void kT(boolean z) {
        this.fIe = z;
    }

    public int bFs() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.ajq;
    }

    public void setSkinType(int i) {
        this.ajq = i;
    }

    public boolean bFt() {
        return this.fIf;
    }

    public void kU(boolean z) {
        this.fIf = z;
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

    public String bFu() {
        return this.fIg;
    }

    public void ED(String str) {
        this.fIg = str;
    }

    public String bFv() {
        return this.fIh;
    }

    public void EE(String str) {
        this.fIh = str;
    }

    public String bFw() {
        return this.fIi;
    }

    public void EF(String str) {
        this.fIi = str;
    }
}
