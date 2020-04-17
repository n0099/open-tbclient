package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int afT;
    private int eim;
    private o etD;
    private Object etE;
    private boolean etF;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.etF = false;
    }

    public o bdU() {
        return this.etD;
    }

    public void a(o oVar) {
        this.etD = oVar;
    }

    public Object bdV() {
        return this.etE;
    }

    public void ao(Object obj) {
        this.etE = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.eim;
    }

    public int getSkinType() {
        return this.afT;
    }

    public void setSkinType(int i) {
        this.afT = i;
    }
}
