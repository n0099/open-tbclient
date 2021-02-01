package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.p;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int ajU;
    private int fOZ;
    private p gcp;
    private Object gcq;
    private boolean gcr;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.gcr = false;
    }

    public p bJz() {
        return this.gcp;
    }

    public void a(p pVar) {
        this.gcp = pVar;
    }

    public Object bJA() {
        return this.gcq;
    }

    public void aD(Object obj) {
        this.gcq = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.fOZ;
    }

    public int getSkinType() {
        return this.ajU;
    }

    public void setSkinType(int i) {
        this.ajU = i;
    }
}
