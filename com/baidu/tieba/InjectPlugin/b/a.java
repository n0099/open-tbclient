package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int ajq;
    private s fHX;
    private Object fHY;
    private boolean fHZ;
    private int fuM;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.fHZ = false;
    }

    public s bFm() {
        return this.fHX;
    }

    public void a(s sVar) {
        this.fHX = sVar;
    }

    public Object bFn() {
        return this.fHY;
    }

    public void aB(Object obj) {
        this.fHY = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.fuM;
    }

    public int getSkinType() {
        return this.ajq;
    }

    public void setSkinType(int i) {
        this.ajq = i;
    }
}
