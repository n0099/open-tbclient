package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int azP;
    private Object bgZ;
    private List<h> bha;
    private List<h> bhb;
    private List<Object> bhc;
    private boolean bhd;
    private boolean bhe;
    private boolean bhf;
    private String bhg;
    private String bhh;
    private String bhi;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bhd = false;
        this.bhe = false;
        this.currentPage = 0;
        this.bhf = false;
    }

    public Object OM() {
        return this.bgZ;
    }

    public void setExtraData(Object obj) {
        this.bgZ = obj;
    }

    public List<h> getThreadList() {
        return this.bha;
    }

    public void S(List<h> list) {
        this.bha = list;
    }

    public List<Object> ON() {
        return this.bhc;
    }

    public void T(List<Object> list) {
        this.bhc = list;
    }

    public List<h> OO() {
        return this.bhb;
    }

    public void U(List<h> list) {
        this.bhb = list;
    }

    public boolean OP() {
        return this.bhd;
    }

    public void co(boolean z) {
        this.bhd = z;
    }

    public boolean isRefresh() {
        return this.bhe;
    }

    public void cp(boolean z) {
        this.bhe = z;
    }

    public int OQ() {
        return this.currentPage;
    }

    public void bY(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.azP;
    }

    public void setSkinType(int i) {
        this.azP = i;
    }

    public boolean OR() {
        return this.bhf;
    }

    public void cq(boolean z) {
        this.bhf = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void gf(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String OS() {
        return this.bhg;
    }

    public void hY(String str) {
        this.bhg = str;
    }

    public String OT() {
        return this.bhh;
    }

    public void hZ(String str) {
        this.bhh = str;
    }

    public String OU() {
        return this.bhi;
    }

    public void ia(String str) {
        this.bhi = str;
    }
}
