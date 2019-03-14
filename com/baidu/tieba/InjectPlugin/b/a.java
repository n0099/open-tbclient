package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int bUK;
    private o cHF;
    private Object cHG;
    private boolean cHH;
    private int cHI;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.cHH = false;
    }

    public o aup() {
        return this.cHF;
    }

    public void a(o oVar) {
        this.cHF = oVar;
    }

    public Object auq() {
        return this.cHG;
    }

    public void ak(Object obj) {
        this.cHG = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.cHI;
    }

    public int getSkinType() {
        return this.bUK;
    }

    public void setSkinType(int i) {
        this.bUK = i;
    }
}
