package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int aMj;
    private int bwA;
    private j bwx;
    private Object bwy;
    private boolean bwz;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bwz = false;
    }

    public j Uq() {
        return this.bwx;
    }

    public void a(j jVar) {
        this.bwx = jVar;
    }

    public Object Ur() {
        return this.bwy;
    }

    public void Q(Object obj) {
        this.bwy = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bwA;
    }

    public int getSkinType() {
        return this.aMj;
    }

    public void setSkinType(int i) {
        this.aMj = i;
    }
}
