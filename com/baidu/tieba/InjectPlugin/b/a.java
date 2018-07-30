package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int azI;
    private j bhA;
    private Object bhB;
    private boolean bhC;
    private int bhD;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bhC = false;
    }

    public j OQ() {
        return this.bhA;
    }

    public void a(j jVar) {
        this.bhA = jVar;
    }

    public Object OR() {
        return this.bhB;
    }

    public void K(Object obj) {
        this.bhB = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bhD;
    }

    public int getSkinType() {
        return this.azI;
    }

    public void setSkinType(int i) {
        this.azI = i;
    }
}
