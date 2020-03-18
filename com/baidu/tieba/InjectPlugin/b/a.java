package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int Nj;
    private o dTE;
    private Object dTF;
    private boolean dTG;
    private int maskColor;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.dTG = false;
    }

    public o aVK() {
        return this.dTE;
    }

    public void a(o oVar) {
        this.dTE = oVar;
    }

    public Object aVL() {
        return this.dTF;
    }

    public void ao(Object obj) {
        this.dTF = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.maskColor;
    }

    public int getSkinType() {
        return this.Nj;
    }

    public void setSkinType(int i) {
        this.Nj = i;
    }
}
