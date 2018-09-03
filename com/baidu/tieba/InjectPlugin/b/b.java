package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int azF;
    private Object bhF;
    private List<h> bhG;
    private List<h> bhH;
    private List<Object> bhI;
    private boolean bhJ;
    private boolean bhK;
    private boolean bhL;
    private String bhM;
    private String bhN;
    private String bhO;
    private int currentPage;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bhJ = false;
        this.bhK = false;
        this.currentPage = 0;
        this.bhL = false;
    }

    public Object OR() {
        return this.bhF;
    }

    public void setExtraData(Object obj) {
        this.bhF = obj;
    }

    public List<h> getThreadList() {
        return this.bhG;
    }

    public void R(List<h> list) {
        this.bhG = list;
    }

    public List<Object> OS() {
        return this.bhI;
    }

    public void S(List<Object> list) {
        this.bhI = list;
    }

    public List<h> OT() {
        return this.bhH;
    }

    public void T(List<h> list) {
        this.bhH = list;
    }

    public boolean OU() {
        return this.bhJ;
    }

    public void cp(boolean z) {
        this.bhJ = z;
    }

    public boolean isRefresh() {
        return this.bhK;
    }

    public void cq(boolean z) {
        this.bhK = z;
    }

    public int OV() {
        return this.currentPage;
    }

    public void ca(int i) {
        this.currentPage = i;
    }

    public int getSkinType() {
        return this.azF;
    }

    public void setSkinType(int i) {
        this.azF = i;
    }

    public boolean OW() {
        return this.bhL;
    }

    public void cr(boolean z) {
        this.bhL = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void gj(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String OX() {
        return this.bhM;
    }

    public void hW(String str) {
        this.bhM = str;
    }

    public String OY() {
        return this.bhN;
    }

    public void hX(String str) {
        this.bhN = str;
    }

    public String OZ() {
        return this.bhO;
    }

    public void hY(String str) {
        this.bhO = str;
    }
}
