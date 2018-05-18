package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private j aXA;
    private Object aXB;
    private boolean aXC;
    private int aXD;
    private int aqQ;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aXC = false;
    }

    public j KS() {
        return this.aXA;
    }

    public void a(j jVar) {
        this.aXA = jVar;
    }

    public Object KT() {
        return this.aXB;
    }

    public void H(Object obj) {
        this.aXB = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.aXD;
    }

    public int getSkinType() {
        return this.aqQ;
    }

    public void setSkinType(int i) {
        this.aqQ = i;
    }
}
