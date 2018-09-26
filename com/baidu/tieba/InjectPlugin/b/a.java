package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int aCJ;
    private j bnt;
    private Object bnu;
    private boolean bnv;
    private int bnw;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bnv = false;
    }

    public j QJ() {
        return this.bnt;
    }

    public void a(j jVar) {
        this.bnt = jVar;
    }

    public Object QK() {
        return this.bnu;
    }

    public void N(Object obj) {
        this.bnu = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bnw;
    }

    public int getSkinType() {
        return this.aCJ;
    }

    public void setSkinType(int i) {
        this.aCJ = i;
    }
}
