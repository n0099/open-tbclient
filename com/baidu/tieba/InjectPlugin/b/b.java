package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aQe;
    private List<v> aQf;
    private List<v> aQg;
    private List<Object> aQh;
    private boolean aQi;
    private boolean aQj;
    private int aQk;
    private boolean aQl;
    private String aQm;
    private String aQn;
    private String aQo;
    private int ane;
    private String forumId;
    private int pageNum;

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aQi = false;
        this.aQj = false;
        this.aQk = 0;
        this.aQl = false;
    }

    public Object IP() {
        return this.aQe;
    }

    public void setExtraData(Object obj) {
        this.aQe = obj;
    }

    public List<v> getThreadList() {
        return this.aQf;
    }

    public void I(List<v> list) {
        this.aQf = list;
    }

    public List<Object> IQ() {
        return this.aQh;
    }

    public void J(List<Object> list) {
        this.aQh = list;
    }

    public List<v> IR() {
        return this.aQg;
    }

    public void K(List<v> list) {
        this.aQg = list;
    }

    public boolean IS() {
        return this.aQi;
    }

    public void ch(boolean z) {
        this.aQi = z;
    }

    public boolean IT() {
        return this.aQj;
    }

    public void ci(boolean z) {
        this.aQj = z;
    }

    public int IU() {
        return this.aQk;
    }

    public void bV(int i) {
        this.aQk = i;
    }

    public int getSkinType() {
        return this.ane;
    }

    public void setSkinType(int i) {
        this.ane = i;
    }

    public boolean IV() {
        return this.aQl;
    }

    public void cj(boolean z) {
        this.aQl = z;
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

    public String IW() {
        return this.aQm;
    }

    public void gu(String str) {
        this.aQm = str;
    }

    public String IX() {
        return this.aQn;
    }

    public void gv(String str) {
        this.aQn = str;
    }

    public String IY() {
        return this.aQo;
    }

    public void gw(String str) {
        this.aQo = str;
    }
}
