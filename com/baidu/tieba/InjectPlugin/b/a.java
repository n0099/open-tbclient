package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int ajv;
    private int fAc;
    private s fNq;
    private Object fNr;
    private boolean fNs;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.fNs = false;
    }

    public s bHe() {
        return this.fNq;
    }

    public void a(s sVar) {
        this.fNq = sVar;
    }

    public Object bHf() {
        return this.fNr;
    }

    public void aB(Object obj) {
        this.fNr = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.fAc;
    }

    public int getSkinType() {
        return this.ajv;
    }

    public void setSkinType(int i) {
        this.ajv = i;
    }
}
