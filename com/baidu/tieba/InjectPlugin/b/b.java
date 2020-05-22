package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object agg;
    private int agt;
    private int currentPage;
    private List<o> eIk;
    private List<o> eIl;
    private List<Object> eIm;
    private boolean eIn;
    private boolean eIo;
    private boolean eIp;
    private String eIq;
    private String eIr;
    private String eIs;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.eIn = false;
        this.eIo = false;
        this.currentPage = 0;
        this.eIp = false;
    }

    public Object rS() {
        return this.agg;
    }

    public void setExtraData(Object obj) {
        this.agg = obj;
    }

    public List<o> getThreadList() {
        return this.eIk;
    }

    public void aY(List<o> list) {
        this.eIk = list;
    }

    public List<Object> bkf() {
        return this.eIm;
    }

    public void aZ(List<Object> list) {
        this.eIm = list;
    }

    public List<o> bkg() {
        return this.eIl;
    }

    public void ba(List<o> list) {
        this.eIl = list;
    }

    public boolean bkh() {
        return this.eIn;
    }

    public void iP(boolean z) {
        this.eIn = z;
    }

    public boolean bki() {
        return this.eIo;
    }

    public void iQ(boolean z) {
        this.eIo = z;
    }

    public int bkj() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.agt;
    }

    public void setSkinType(int i) {
        this.agt = i;
    }

    public boolean bkk() {
        return this.eIp;
    }

    public void iR(boolean z) {
        this.eIp = z;
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

    public String bkl() {
        return this.eIq;
    }

    public void zg(String str) {
        this.eIq = str;
    }

    public String bkm() {
        return this.eIr;
    }

    public void zh(String str) {
        this.eIr = str;
    }

    public String bkn() {
        return this.eIs;
    }

    public void zi(String str) {
        this.eIs = str;
    }
}
