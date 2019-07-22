package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private o cRo;
    private Object cRp;
    private boolean cRq;
    private int cRr;
    private int cdL;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.cRq = false;
    }

    public o aAG() {
        return this.cRo;
    }

    public void a(o oVar) {
        this.cRo = oVar;
    }

    public Object aAH() {
        return this.cRp;
    }

    public void ak(Object obj) {
        this.cRp = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.cRr;
    }

    public int getSkinType() {
        return this.cdL;
    }

    public void setSkinType(int i) {
        this.cdL = i;
    }
}
