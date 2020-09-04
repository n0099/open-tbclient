package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object ahV;
    private int aiD;
    private int currentPage;
    private List<Object> fkA;
    private boolean fkB;
    private boolean fkC;
    private boolean fkD;
    private String fkE;
    private String fkF;
    private String fkG;
    private List<q> fky;
    private List<q> fkz;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.fkB = false;
        this.fkC = false;
        this.currentPage = 0;
        this.fkD = false;
    }

    public Object tX() {
        return this.ahV;
    }

    public void setExtraData(Object obj) {
        this.ahV = obj;
    }

    public List<q> getThreadList() {
        return this.fky;
    }

    public void bm(List<q> list) {
        this.fky = list;
    }

    public List<Object> bzA() {
        return this.fkA;
    }

    public void bn(List<Object> list) {
        this.fkA = list;
    }

    public List<q> bzB() {
        return this.fkz;
    }

    public void bo(List<q> list) {
        this.fkz = list;
    }

    public boolean bzC() {
        return this.fkB;
    }

    public void kg(boolean z) {
        this.fkB = z;
    }

    public boolean bzD() {
        return this.fkC;
    }

    public void kh(boolean z) {
        this.fkC = z;
    }

    public int bzE() {
        return this.currentPage;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.aiD;
    }

    public void setSkinType(int i) {
        this.aiD = i;
    }

    public boolean bzF() {
        return this.fkD;
    }

    public void ki(boolean z) {
        this.fkD = z;
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

    public String bzG() {
        return this.fkE;
    }

    public void Dc(String str) {
        this.fkE = str;
    }

    public String bzH() {
        return this.fkF;
    }

    public void Dd(String str) {
        this.fkF = str;
    }

    public String bzI() {
        return this.fkG;
    }

    public void De(String str) {
        this.fkG = str;
    }
}
