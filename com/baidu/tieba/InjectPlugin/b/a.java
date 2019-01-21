package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int aMk;
    private boolean bwA;
    private int bwB;
    private j bwy;
    private Object bwz;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bwA = false;
    }

    public j Uq() {
        return this.bwy;
    }

    public void a(j jVar) {
        this.bwy = jVar;
    }

    public Object Ur() {
        return this.bwz;
    }

    public void Q(Object obj) {
        this.bwz = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bwB;
    }

    public int getSkinType() {
        return this.aMk;
    }

    public void setSkinType(int i) {
        this.aMk = i;
    }
}
