package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private o cPS;
    private Object cPT;
    private boolean cPU;
    private int cPV;
    private int ccJ;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.cPU = false;
    }

    public o azs() {
        return this.cPS;
    }

    public void a(o oVar) {
        this.cPS = oVar;
    }

    public Object azt() {
        return this.cPT;
    }

    public void ak(Object obj) {
        this.cPT = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.cPV;
    }

    public int getSkinType() {
        return this.ccJ;
    }

    public void setSkinType(int i) {
        this.ccJ = i;
    }
}
