package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int ajq;
    private int fAC;
    private s fNN;
    private Object fNO;
    private boolean fNP;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.fNP = false;
    }

    public s bHL() {
        return this.fNN;
    }

    public void a(s sVar) {
        this.fNN = sVar;
    }

    public Object bHM() {
        return this.fNO;
    }

    public void aB(Object obj) {
        this.fNO = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.fAC;
    }

    public int getSkinType() {
        return this.ajq;
    }

    public void setSkinType(int i) {
        this.ajq = i;
    }
}
