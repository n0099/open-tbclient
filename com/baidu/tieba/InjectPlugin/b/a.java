package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int Ni;
    private o dTb;
    private Object dTc;
    private boolean dTd;
    private int maskColor;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.dTd = false;
    }

    public o aVF() {
        return this.dTb;
    }

    public void a(o oVar) {
        this.dTb = oVar;
    }

    public Object aVG() {
        return this.dTc;
    }

    public void ao(Object obj) {
        this.dTc = obj;
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
