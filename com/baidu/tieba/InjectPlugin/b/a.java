package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes2.dex */
public class a extends g {
    private int aiB;
    private int eXe;
    private s fkr;
    private Object fks;
    private boolean fkt;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.fkt = false;
    }

    public s bzx() {
        return this.fkr;
    }

    public void a(s sVar) {
        this.fkr = sVar;
    }

    public Object bzy() {
        return this.fks;
    }

    public void aw(Object obj) {
        this.fks = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.eXe;
    }

    public int getSkinType() {
        return this.aiB;
    }

    public void setSkinType(int i) {
        this.aiB = i;
    }
}
