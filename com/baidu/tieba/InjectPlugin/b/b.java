package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object afG;
    private int afT;
    private int currentPage;
    private List<m> etG;
    private List<m> etH;
    private List<Object> etI;
    private boolean etJ;
    private boolean etK;
    private boolean etL;
    private String etM;
    private String etN;
    private String etO;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.etJ = false;
        this.etK = false;
        this.currentPage = 0;
        this.etL = false;
    }

    public Object rJ() {
        return this.afG;
    }

    public void setExtraData(Object obj) {
        this.afG = obj;
    }

    public List<m> getThreadList() {
        return this.etG;
    }

    public void bd(List<m> list) {
        this.etG = list;
    }

    public List<Object> bdW() {
        return this.etI;
    }

    public void be(List<Object> list) {
        this.etI = list;
    }

    public List<m> bdX() {
        return this.etH;
    }

    public void bf(List<m> list) {
        this.etH = list;
    }

    public boolean bdY() {
        return this.etJ;
    }

    public void is(boolean z) {
        this.etJ = z;
    }

    public boolean bdZ() {
        return this.etK;
    }

    public void it(boolean z) {
        this.etK = z;
    }

    public int bea() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.afT;
    }

    public void setSkinType(int i) {
        this.afT = i;
    }

    public boolean beb() {
        return this.etL;
    }

    public void iu(boolean z) {
        this.etL = z;
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

    public String bec() {
        return this.etM;
    }

    public void xx(String str) {
        this.etM = str;
    }

    public String bed() {
        return this.etN;
    }

    public void xy(String str) {
        this.etN = str;
    }

    public String bee() {
        return this.etO;
    }

    public void xz(String str) {
        this.etO = str;
    }
}
