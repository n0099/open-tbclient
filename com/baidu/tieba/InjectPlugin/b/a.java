package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private o cPR;
    private Object cPS;
    private boolean cPT;
    private int cPU;
    private int ccI;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.cPT = false;
    }

    public o azs() {
        return this.cPR;
    }

    public void a(o oVar) {
        this.cPR = oVar;
    }

    public Object azt() {
        return this.cPS;
    }

    public void ak(Object obj) {
        this.cPS = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.cPU;
    }

    public int getSkinType() {
        return this.ccI;
    }

    public void setSkinType(int i) {
        this.ccI = i;
    }
}
