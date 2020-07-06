package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object agT;
    private int ahx;
    private int currentPage;
    private List<q> eSH;
    private List<q> eSI;
    private List<Object> eSJ;
    private boolean eSK;
    private boolean eSL;
    private boolean eSM;
    private String eSN;
    private String eSO;
    private String eSP;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.eSK = false;
        this.eSL = false;
        this.currentPage = 0;
        this.eSM = false;
    }

    public Object sk() {
        return this.agT;
    }

    public void setExtraData(Object obj) {
        this.agT = obj;
    }

    public List<q> getThreadList() {
        return this.eSH;
    }

    public void bi(List<q> list) {
        this.eSH = list;
    }

    public List<Object> bmH() {
        return this.eSJ;
    }

    public void bj(List<Object> list) {
        this.eSJ = list;
    }

    public List<q> bmI() {
        return this.eSI;
    }

    public void bk(List<q> list) {
        this.eSI = list;
    }

    public boolean bmJ() {
        return this.eSK;
    }

    public void jb(boolean z) {
        this.eSK = z;
    }

    public boolean bmK() {
        return this.eSL;
    }

    public void jc(boolean z) {
        this.eSL = z;
    }

    public int bmL() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.ahx;
    }

    public void setSkinType(int i) {
        this.ahx = i;
    }

    public boolean bmM() {
        return this.eSM;
    }

    public void jd(boolean z) {
        this.eSM = z;
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

    public String bmN() {
        return this.eSN;
    }

    public void zz(String str) {
        this.eSN = str;
    }

    public String bmO() {
        return this.eSO;
    }

    public void zA(String str) {
        this.eSO = str;
    }

    public String bmP() {
        return this.eSP;
    }

    public void zB(String str) {
        this.eSP = str;
    }
}
