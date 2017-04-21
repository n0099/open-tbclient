package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aPL;
    private List<v> aPM;
    private List<v> aPN;
    private List<Object> aPO;
    private boolean aPP;
    private boolean aPQ;
    private int aPR;
    private boolean aPS;
    private String aPT;
    private String aPU;
    private String aPV;
    private int amZ;
    private String forumId;
    private int pageNum;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aPP = false;
        this.aPQ = false;
        this.aPR = 0;
        this.aPS = false;
    }

    public Object JB() {
        return this.aPL;
    }

    public void setExtraData(Object obj) {
        this.aPL = obj;
    }

    public List<v> getThreadList() {
        return this.aPM;
    }

    public void G(List<v> list) {
        this.aPM = list;
    }

    public List<Object> JC() {
        return this.aPO;
    }

    public void H(List<Object> list) {
        this.aPO = list;
    }

    public List<v> JD() {
        return this.aPN;
    }

    public void I(List<v> list) {
        this.aPN = list;
    }

    public boolean JE() {
        return this.aPP;
    }

    public void cf(boolean z) {
        this.aPP = z;
    }

    public boolean JF() {
        return this.aPQ;
    }

    public void cg(boolean z) {
        this.aPQ = z;
    }

    public int JG() {
        return this.aPR;
    }

    public void bX(int i) {
        this.aPR = i;
    }

    public int getSkinType() {
        return this.amZ;
    }

    public void setSkinType(int i) {
        this.amZ = i;
    }

    public boolean JH() {
        return this.aPS;
    }

    public void ch(boolean z) {
        this.aPS = z;
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
        return this.aPT;
    }

    public void gw(String str) {
        this.aPT = str;
    }

    public String JJ() {
        return this.aPU;
    }

    public void gx(String str) {
        this.aPU = str;
    }

    public String JK() {
        return this.aPV;
    }

    public void gy(String str) {
        this.aPV = str;
    }
}
