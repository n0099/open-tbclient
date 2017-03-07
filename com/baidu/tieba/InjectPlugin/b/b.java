package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private boolean aPA;
    private String aPB;
    private String aPC;
    private String aPD;
    private Object aPt;
    private List<v> aPu;
    private List<v> aPv;
    private List<Object> aPw;
    private boolean aPx;
    private boolean aPy;
    private int aPz;
    private int amL;
    private String forumId;
    private int pageNum;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aPx = false;
        this.aPy = false;
        this.aPz = 0;
        this.aPA = false;
    }

    public Object Jb() {
        return this.aPt;
    }

    public void K(Object obj) {
        this.aPt = obj;
    }

    public List<v> getThreadList() {
        return this.aPu;
    }

    public void G(List<v> list) {
        this.aPu = list;
    }

    public List<Object> Jc() {
        return this.aPw;
    }

    public void H(List<Object> list) {
        this.aPw = list;
    }

    public List<v> Jd() {
        return this.aPv;
    }

    public void I(List<v> list) {
        this.aPv = list;
    }

    public boolean Je() {
        return this.aPx;
    }

    public void cd(boolean z) {
        this.aPx = z;
    }

    public boolean Jf() {
        return this.aPy;
    }

    public void ce(boolean z) {
        this.aPy = z;
    }

    public int Jg() {
        return this.aPz;
    }

    public void bU(int i) {
        this.aPz = i;
    }

    public int getSkinType() {
        return this.amL;
    }

    public void setSkinType(int i) {
        this.amL = i;
    }

    public boolean Jh() {
        return this.aPA;
    }

    public void cf(boolean z) {
        this.aPA = z;
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

    public String Ji() {
        return this.aPB;
    }

    public void gq(String str) {
        this.aPB = str;
    }

    public String Jj() {
        return this.aPC;
    }

    public void gr(String str) {
        this.aPC = str;
    }

    public String Jk() {
        return this.aPD;
    }

    public void gs(String str) {
        this.aPD = str;
    }
}
