package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int aLH;
    private j bvJ;
    private Object bvK;
    private boolean bvL;
    private int bvM;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bvL = false;
    }

    public j TU() {
        return this.bvJ;
    }

    public void a(j jVar) {
        this.bvJ = jVar;
    }

    public Object TV() {
        return this.bvK;
    }

    public void Q(Object obj) {
        this.bvK = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bvM;
    }

    public int getSkinType() {
        return this.aLH;
    }

    public void setSkinType(int i) {
        this.aLH = i;
    }
}
