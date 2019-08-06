package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private o cRv;
    private Object cRw;
    private boolean cRx;
    private int cRy;
    private int cdS;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.cRx = false;
    }

    public o aAI() {
        return this.cRv;
    }

    public void a(o oVar) {
        this.cRv = oVar;
    }

    public Object aAJ() {
        return this.cRw;
    }

    public void ak(Object obj) {
        this.cRw = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.cRy;
    }

    public int getSkinType() {
        return this.cdS;
    }

    public void setSkinType(int i) {
        this.cdS = i;
    }
}
