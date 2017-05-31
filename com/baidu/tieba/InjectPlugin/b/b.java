package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.List;
/* loaded from: classes.dex */
public class b extends g {
    private Object aQf;
    private List<v> aQg;
    private List<v> aQh;
    private List<Object> aQi;
    private boolean aQj;
    private boolean aQk;
    private int aQl;
    private boolean aQm;
    private String aQn;
    private String aQo;
    private String aQp;
    private int ana;
    private String forumId;
    private int pageNum;

    public b(com.baidu.tieba.InjectPlugin.a.b bVar, int i) {
        super(bVar, i);
        this.aQj = false;
        this.aQk = false;
        this.aQl = 0;
        this.aQm = false;
    }

    public Object IL() {
        return this.aQf;
    }

    public void setExtraData(Object obj) {
        this.aQf = obj;
    }

    public List<v> getThreadList() {
        return this.aQg;
    }

    public void setThreadList(List<v> list) {
        this.aQg = list;
    }

    public List<Object> IM() {
        return this.aQi;
    }

    public void I(List<Object> list) {
        this.aQi = list;
    }

    public List<v> IN() {
        return this.aQh;
    }

    public void J(List<v> list) {
        this.aQh = list;
    }

    public boolean IO() {
        return this.aQj;
    }

    public void ce(boolean z) {
        this.aQj = z;
    }

    public boolean IP() {
        return this.aQk;
    }

    public void cf(boolean z) {
        this.aQk = z;
    }

    public int IQ() {
        return this.aQl;
    }

    public void bW(int i) {
        this.aQl = i;
    }

    public int getSkinType() {
        return this.ana;
    }

    public void setSkinType(int i) {
        this.ana = i;
    }

    public boolean IR() {
        return this.aQm;
    }

    public void cg(boolean z) {
        this.aQm = z;
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

    public String IS() {
        return this.aQn;
    }

    public void gt(String str) {
        this.aQn = str;
    }

    public String IT() {
        return this.aQo;
    }

    public void gu(String str) {
        this.aQo = str;
    }

    public String IU() {
        return this.aQp;
    }

    public void gv(String str) {
        this.aQp = str;
    }
}
