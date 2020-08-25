package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends g {
    private Object ahT;
    private int aiB;
    private int currentPage;
    private String fkA;
    private String fkB;
    private String fkC;
    private List<q> fku;
    private List<q> fkv;
    private List<Object> fkw;
    private boolean fkx;
    private boolean fky;
    private boolean fkz;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.fkx = false;
        this.fky = false;
        this.currentPage = 0;
        this.fkz = false;
    }

    public Object tX() {
        return this.ahT;
    }

    public void setExtraData(Object obj) {
        this.ahT = obj;
    }

    public List<q> getThreadList() {
        return this.fku;
    }

    public void bm(List<q> list) {
        this.fku = list;
    }

    public List<Object> bzz() {
        return this.fkw;
    }

    public void bn(List<Object> list) {
        this.fkw = list;
    }

    public List<q> bzA() {
        return this.fkv;
    }

    public void bo(List<q> list) {
        this.fkv = list;
    }

    public boolean bzB() {
        return this.fkx;
    }

    public void ke(boolean z) {
        this.fkx = z;
    }

    public boolean bzC() {
        return this.fky;
    }

    public void kf(boolean z) {
        this.fky = z;
    }

    public int bzD() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.aiB;
    }

    public void setSkinType(int i) {
        this.aiB = i;
    }

    public boolean bzE() {
        return this.fkz;
    }

    public void kg(boolean z) {
        this.fkz = z;
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

    public String bzF() {
        return this.fkA;
    }

    public void Db(String str) {
        this.fkA = str;
    }

    public String bzG() {
        return this.fkB;
    }

    public void Dc(String str) {
        this.fkB = str;
    }

    public String bzH() {
        return this.fkC;
    }

    public void Dd(String str) {
        this.fkC = str;
    }
}
