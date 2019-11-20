package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int csg;
    private o daR;
    private Object daS;
    private boolean daT;
    private int daU;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.daT = false;
    }

    public o aBe() {
        return this.daR;
    }

    public void a(o oVar) {
        this.daR = oVar;
    }

    public Object aBf() {
        return this.daS;
    }

    public void ag(Object obj) {
        this.daS = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.daU;
    }

    public int getSkinType() {
        return this.csg;
    }

    public void setSkinType(int i) {
        this.csg = i;
    }
}
