package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int afW;
    private int eir;
    private o etI;
    private Object etJ;
    private boolean etK;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.etK = false;
    }

    public o bdS() {
        return this.etI;
    }

    public void a(o oVar) {
        this.etI = oVar;
    }

    public Object bdT() {
        return this.etJ;
    }

    public void ap(Object obj) {
        this.etJ = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.eir;
    }

    public int getSkinType() {
        return this.afW;
    }

    public void setSkinType(int i) {
        this.afW = i;
    }
}
