package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int Ni;
    private o dTo;
    private Object dTp;
    private boolean dTq;
    private int maskColor;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.dTq = false;
    }

    public o aVG() {
        return this.dTo;
    }

    public void a(o oVar) {
        this.dTo = oVar;
    }

    public Object aVH() {
        return this.dTp;
    }

    public void ao(Object obj) {
        this.dTp = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.maskColor;
    }

    public int getSkinType() {
        return this.Ni;
    }

    public void setSkinType(int i) {
        this.Ni = i;
    }
}
