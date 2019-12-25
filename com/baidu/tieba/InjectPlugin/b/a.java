package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int MA;
    private o dOM;
    private Object dON;
    private boolean dOO;
    private int maskColor;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.dOO = false;
    }

    public o aSS() {
        return this.dOM;
    }

    public void a(o oVar) {
        this.dOM = oVar;
    }

    public Object aST() {
        return this.dON;
    }

    public void am(Object obj) {
        this.dON = obj;
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
        return this.MA;
    }

    public void setSkinType(int i) {
        this.MA = i;
    }
}
