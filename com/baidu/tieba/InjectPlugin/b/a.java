package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int Ni;
    private o dTa;
    private Object dTb;
    private boolean dTc;
    private int maskColor;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.dTc = false;
    }

    public o aVD() {
        return this.dTa;
    }

    public void a(o oVar) {
        this.dTa = oVar;
    }

    public Object aVE() {
        return this.dTb;
    }

    public void ao(Object obj) {
        this.dTb = obj;
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
