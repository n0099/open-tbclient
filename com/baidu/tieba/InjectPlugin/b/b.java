package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int aiX;
    private Object aiq;
    private int currentPage;
    private List<q> fnr;
    private List<q> fns;
    private List<Object> fnt;
    private boolean fnu;
    private boolean fnv;
    private boolean fnw;
    private String fnx;
    private String fny;
    private String fnz;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.fnu = false;
        this.fnv = false;
        this.currentPage = 0;
        this.fnw = false;
    }

    public Object ud() {
        return this.aiq;
    }

    public void setExtraData(Object obj) {
        this.aiq = obj;
    }

    public List<q> getThreadList() {
        return this.fnr;
    }

    public void br(List<q> list) {
        this.fnr = list;
    }

    public List<Object> bAJ() {
        return this.fnt;
    }

    public void bs(List<Object> list) {
        this.fnt = list;
    }

    public List<q> bAK() {
        return this.fns;
    }

    public void bt(List<q> list) {
        this.fns = list;
    }

    public boolean bAL() {
        return this.fnu;
    }

    public void kh(boolean z) {
        this.fnu = z;
    }

    public boolean bAM() {
        return this.fnv;
    }

    public void ki(boolean z) {
        this.fnv = z;
    }

    public int bAN() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.aiX;
    }

    public void setSkinType(int i) {
        this.aiX = i;
    }

    public boolean bAO() {
        return this.fnw;
    }

    public void kj(boolean z) {
        this.fnw = z;
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

    public String bAP() {
        return this.fnx;
    }

    public void Dz(String str) {
        this.fnx = str;
    }

    public String bAQ() {
        return this.fny;
    }

    public void DA(String str) {
        this.fny = str;
    }

    public String bAR() {
        return this.fnz;
    }

    public void DB(String str) {
        this.fnz = str;
    }
}
