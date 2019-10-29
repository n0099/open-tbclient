package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int csX;
    private o dbI;
    private Object dbJ;
    private boolean dbK;
    private int dbL;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.dbK = false;
    }

    public o aBg() {
        return this.dbI;
    }

    public void a(o oVar) {
        this.dbI = oVar;
    }

    public Object aBh() {
        return this.dbJ;
    }

    public void ag(Object obj) {
        this.dbJ = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.dbL;
    }

    public int getSkinType() {
        return this.csX;
    }

    public void setSkinType(int i) {
        this.csX = i;
    }
}
