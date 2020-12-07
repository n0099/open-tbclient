package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int aku;
    private int fHR;
    private s fVb;
    private Object fVc;
    private boolean fVd;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.fVd = false;
    }

    public s bKE() {
        return this.fVb;
    }

    public void a(s sVar) {
        this.fVb = sVar;
    }

    public Object bKF() {
        return this.fVc;
    }

    public void aB(Object obj) {
        this.fVc = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.fHR;
    }

    public int getSkinType() {
        return this.aku;
    }

    public void setSkinType(int i) {
        this.aku = i;
    }
}
