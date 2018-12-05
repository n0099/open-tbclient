package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int aLF;
    private j bvG;
    private Object bvH;
    private boolean bvI;
    private int bvJ;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bvI = false;
    }

    public j TS() {
        return this.bvG;
    }

    public void a(j jVar) {
        this.bvG = jVar;
    }

    public Object TT() {
        return this.bvH;
    }

    public void Q(Object obj) {
        this.bvH = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bvJ;
    }

    public int getSkinType() {
        return this.aLF;
    }

    public void setSkinType(int i) {
        this.aLF = i;
    }
}
