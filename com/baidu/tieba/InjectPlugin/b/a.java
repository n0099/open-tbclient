package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private o cSo;
    private Object cSp;
    private boolean cSq;
    private int cSr;
    private int ceL;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.cSq = false;
    }

    public o aAW() {
        return this.cSo;
    }

    public void a(o oVar) {
        this.cSo = oVar;
    }

    public Object aAX() {
        return this.cSp;
    }

    public void ak(Object obj) {
        this.cSp = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.cSr;
    }

    public int getSkinType() {
        return this.ceL;
    }

    public void setSkinType(int i) {
        this.ceL = i;
    }
}
