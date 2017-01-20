package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private int Gs;
    private Object aJK;
    private List<v> aJL;
    private List<v> aJM;
    private boolean aJN;
    private boolean aJO;
    private boolean aJP;
    private String aJQ;
    private String aJR;
    private String aJS;
    private List<Object> adList;
    private int ahp;
    private String forumId;
    private int pageNum;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aJN = false;
        this.aJO = false;
        this.Gs = 0;
        this.aJP = false;
    }

    public Object Iz() {
        return this.aJK;
    }

    public void K(Object obj) {
        this.aJK = obj;
    }

    public List<v> getThreadList() {
        return this.aJL;
    }

    public void J(List<v> list) {
        this.aJL = list;
    }

    public List<Object> getAdList() {
        return this.adList;
    }

    public void K(List<Object> list) {
        this.adList = list;
    }

    public List<v> IA() {
        return this.aJM;
    }

    public void L(List<v> list) {
        this.aJM = list;
    }

    public boolean IB() {
        return this.aJN;
    }

    public void ce(boolean z) {
        this.aJN = z;
    }

    public boolean IC() {
        return this.aJO;
    }

    public void cf(boolean z) {
        this.aJO = z;
    }

    public int ma() {
        return this.Gs;
    }

    public void aW(int i) {
        this.Gs = i;
    }

    public int getSkinType() {
        return this.ahp;
    }

    public void setSkinType(int i) {
        this.ahp = i;
    }

    public boolean ID() {
        return this.aJP;
    }

    public void cg(boolean z) {
        this.aJP = z;
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

    public String IE() {
        return this.aJQ;
    }

    public void gB(String str) {
        this.aJQ = str;
    }

    public String IF() {
        return this.aJR;
    }

    public void gC(String str) {
        this.aJR = str;
    }

    public String IG() {
        return this.aJS;
    }

    public void gD(String str) {
        this.aJS = str;
    }
}
