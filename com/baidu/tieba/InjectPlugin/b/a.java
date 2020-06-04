package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int agt;
    private q eIs;
    private Object eIt;
    private boolean eIu;
    private int ewU;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.eIu = false;
    }

    public q bkf() {
        return this.eIs;
    }

    public void a(q qVar) {
        this.eIs = qVar;
    }

    public Object bkg() {
        return this.eIt;
    }

    public void at(Object obj) {
        this.eIt = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.ewU;
    }

    public int getSkinType() {
        return this.agt;
    }

    public void setSkinType(int i) {
        this.agt = i;
    }
}
