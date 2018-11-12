package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int aIf;
    private j bsh;
    private Object bsi;
    private boolean bsj;
    private int bsk;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bsj = false;
    }

    public j SM() {
        return this.bsh;
    }

    public void a(j jVar) {
        this.bsh = jVar;
    }

    public Object SN() {
        return this.bsi;
    }

    public void Q(Object obj) {
        this.bsi = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bsk;
    }

    public int getSkinType() {
        return this.aIf;
    }

    public void setSkinType(int i) {
        this.aIf = i;
    }
}
