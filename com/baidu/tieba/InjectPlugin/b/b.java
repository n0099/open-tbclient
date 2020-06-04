package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object agg;
    private int agt;
    private int currentPage;
    private boolean eIA;
    private String eIB;
    private String eIC;
    private String eID;
    private List<o> eIv;
    private List<o> eIw;
    private List<Object> eIx;
    private boolean eIy;
    private boolean eIz;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.eIy = false;
        this.eIz = false;
        this.currentPage = 0;
        this.eIA = false;
    }

    public Object rS() {
        return this.agg;
    }

    public void setExtraData(Object obj) {
        this.agg = obj;
    }

    public List<o> getThreadList() {
        return this.eIv;
    }

    public void aY(List<o> list) {
        this.eIv = list;
    }

    public List<Object> bkh() {
        return this.eIx;
    }

    public void aZ(List<Object> list) {
        this.eIx = list;
    }

    public List<o> bki() {
        return this.eIw;
    }

    public void ba(List<o> list) {
        this.eIw = list;
    }

    public boolean bkj() {
        return this.eIy;
    }

    public void iP(boolean z) {
        this.eIy = z;
    }

    public boolean bkk() {
        return this.eIz;
    }

    public void iQ(boolean z) {
        this.eIz = z;
    }

    public int bkl() {
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

    public boolean bkm() {
        return this.eIA;
    }

    public void iR(boolean z) {
        this.eIA = z;
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

    public String bkn() {
        return this.eIB;
    }

    public void zg(String str) {
        this.eIB = str;
    }

    public String bko() {
        return this.eIC;
    }

    public void zh(String str) {
        this.eIC = str;
    }

    public String bkp() {
        return this.eID;
    }

    public void zi(String str) {
        this.eID = str;
    }
}
