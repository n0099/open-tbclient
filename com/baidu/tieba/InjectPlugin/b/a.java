package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int aiX;
    private int eZZ;
    private s fno;
    private Object fnp;
    private boolean fnq;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.fnq = false;
    }

    public s bAH() {
        return this.fno;
    }

    public void a(s sVar) {
        this.fno = sVar;
    }

    public Object bAI() {
        return this.fnp;
    }

    public void ay(Object obj) {
        this.fnp = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.eZZ;
    }

    public int getSkinType() {
        return this.aiX;
    }

    public void setSkinType(int i) {
        this.aiX = i;
    }
}
