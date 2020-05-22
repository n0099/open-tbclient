package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int agt;
    private q eIh;
    private Object eIi;
    private boolean eIj;
    private int ewJ;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.eIj = false;
    }

    public q bkd() {
        return this.eIh;
    }

    public void a(q qVar) {
        this.eIh = qVar;
    }

    public Object bke() {
        return this.eIi;
    }

    public void at(Object obj) {
        this.eIi = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.ewJ;
    }

    public int getSkinType() {
        return this.agt;
    }

    public void setSkinType(int i) {
        this.agt = i;
    }
}
