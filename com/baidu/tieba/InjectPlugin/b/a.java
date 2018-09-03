package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int azF;
    private j bhB;
    private Object bhC;
    private boolean bhD;
    private int bhE;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bhD = false;
    }

    public j OP() {
        return this.bhB;
    }

    public void a(j jVar) {
        this.bhB = jVar;
    }

    public Object OQ() {
        return this.bhC;
    }

    public void K(Object obj) {
        this.bhC = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bhE;
    }

    public int getSkinType() {
        return this.azF;
    }

    public void setSkinType(int i) {
        this.azF = i;
    }
}
