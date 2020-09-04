package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int aiD;
    private int eXi;
    private s fkv;
    private Object fkw;
    private boolean fkx;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.fkx = false;
    }

    public s bzy() {
        return this.fkv;
    }

    public void a(s sVar) {
        this.fkv = sVar;
    }

    public Object bzz() {
        return this.fkw;
    }

    public void aw(Object obj) {
        this.fkw = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.eXi;
    }

    public int getSkinType() {
        return this.aiD;
    }

    public void setSkinType(int i) {
        this.aiD = i;
    }
}
