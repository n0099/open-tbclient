package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.p;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int akW;
    private int fRt;
    private p geH;
    private Object geI;
    private boolean geJ;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.geJ = false;
    }

    public p bMW() {
        return this.geH;
    }

    public void a(p pVar) {
        this.geH = pVar;
    }

    public Object bMX() {
        return this.geI;
    }

    public void aD(Object obj) {
        this.geI = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.fRt;
    }

    public int getSkinType() {
        return this.akW;
    }

    public void setSkinType(int i) {
        this.akW = i;
    }
}
