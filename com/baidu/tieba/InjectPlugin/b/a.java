package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private Object aXA;
    private boolean aXB;
    private int aXC;
    private j aXz;
    private int aqQ;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aXB = false;
    }

    public j KU() {
        return this.aXz;
    }

    public void a(j jVar) {
        this.aXz = jVar;
    }

    public Object KV() {
        return this.aXA;
    }

    public void H(Object obj) {
        this.aXA = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.aXC;
    }

    public int getSkinType() {
        return this.aqQ;
    }

    public void setSkinType(int i) {
        this.aqQ = i;
    }
}
