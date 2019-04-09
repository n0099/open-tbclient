package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int bUN;
    private o cHI;
    private Object cHJ;
    private boolean cHK;
    private int cHL;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.cHK = false;
    }

    public o aum() {
        return this.cHI;
    }

    public void a(o oVar) {
        this.cHI = oVar;
    }

    public Object aun() {
        return this.cHJ;
    }

    public void ai(Object obj) {
        this.cHJ = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.cHL;
    }

    public int getSkinType() {
        return this.bUN;
    }

    public void setSkinType(int i) {
        this.bUN = i;
    }
}
