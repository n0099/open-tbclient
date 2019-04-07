package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int bUM;
    private o cHH;
    private Object cHI;
    private boolean cHJ;
    private int cHK;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.cHJ = false;
    }

    public o aum() {
        return this.cHH;
    }

    public void a(o oVar) {
        this.cHH = oVar;
    }

    public Object aun() {
        return this.cHI;
    }

    public void ai(Object obj) {
        this.cHI = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.cHK;
    }

    public int getSkinType() {
        return this.bUM;
    }

    public void setSkinType(int i) {
        this.bUM = i;
    }
}
