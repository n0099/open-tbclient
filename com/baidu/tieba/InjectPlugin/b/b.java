package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aPJ;
    private List<v> aPK;
    private List<v> aPL;
    private List<Object> aPM;
    private boolean aPN;
    private boolean aPO;
    private int aPP;
    private boolean aPQ;
    private String aPR;
    private String aPS;
    private String aPT;
    private int amZ;
    private String forumId;
    private int pageNum;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aPN = false;
        this.aPO = false;
        this.aPP = 0;
        this.aPQ = false;
    }

    public Object JB() {
        return this.aPJ;
    }

    public void K(Object obj) {
        this.aPJ = obj;
    }

    public List<v> getThreadList() {
        return this.aPK;
    }

    public void G(List<v> list) {
        this.aPK = list;
    }

    public List<Object> JC() {
        return this.aPM;
    }

    public void H(List<Object> list) {
        this.aPM = list;
    }

    public List<v> JD() {
        return this.aPL;
    }

    public void I(List<v> list) {
        this.aPL = list;
    }

    public boolean JE() {
        return this.aPN;
    }

    public void cf(boolean z) {
        this.aPN = z;
    }

    public boolean JF() {
        return this.aPO;
    }

    public void cg(boolean z) {
        this.aPO = z;
    }

    public int JG() {
        return this.aPP;
    }

    public void bX(int i) {
        this.aPP = i;
    }

    public int getSkinType() {
        return this.amZ;
    }

    public void setSkinType(int i) {
        this.amZ = i;
    }

    public boolean JH() {
        return this.aPQ;
    }

    public void ch(boolean z) {
        this.aPQ = z;
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

    public String JI() {
        return this.aPR;
    }

    public void gw(String str) {
        this.aPR = str;
    }

    public String JJ() {
        return this.aPS;
    }

    public void gx(String str) {
        this.aPS = str;
    }

    public String JK() {
        return this.aPT;
    }

    public void gy(String str) {
        this.aPT = str;
    }
}
