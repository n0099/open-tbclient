package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int azI;
    private Object bhE;
    private List<h> bhF;
    private List<h> bhG;
    private List<Object> bhH;
    private boolean bhI;
    private boolean bhJ;
    private int bhK;
    private boolean bhL;
    private String bhM;
    private String bhN;
    private String bhO;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.bhI = false;
        this.bhJ = false;
        this.bhK = 0;
        this.bhL = false;
    }

    public Object OS() {
        return this.bhE;
    }

    public void setExtraData(Object obj) {
        this.bhE = obj;
    }

    public List<h> getThreadList() {
        return this.bhF;
    }

    public void R(List<h> list) {
        this.bhF = list;
    }

    public List<Object> OT() {
        return this.bhH;
    }

    public void S(List<Object> list) {
        this.bhH = list;
    }

    public List<h> OU() {
        return this.bhG;
    }

    public void T(List<h> list) {
        this.bhG = list;
    }

    public boolean OV() {
        return this.bhI;
    }

    public void co(boolean z) {
        this.bhI = z;
    }

    public boolean isRefresh() {
        return this.bhJ;
    }

    public void cp(boolean z) {
        this.bhJ = z;
    }

    public int OW() {
        return this.bhK;
    }

    public void ca(int i) {
        this.bhK = i;
    }

    public int getSkinType() {
        return this.azI;
    }

    public void setSkinType(int i) {
        this.azI = i;
    }

    public boolean OX() {
        return this.bhL;
    }

    public void cq(boolean z) {
        this.bhL = z;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void gk(int i) {
        this.pageNum = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String OY() {
        return this.bhM;
    }

    public void hV(String str) {
        this.bhM = str;
    }

    public String OZ() {
        return this.bhN;
    }

    public void hW(String str) {
        this.bhN = str;
    }

    public String Pa() {
        return this.bhO;
    }

    public void hX(String str) {
        this.bhO = str;
    }
}
