package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int azP;
    private j bgV;
    private Object bgW;
    private boolean bgX;
    private int bgY;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bgX = false;
    }

    public j OK() {
        return this.bgV;
    }

    public void a(j jVar) {
        this.bgV = jVar;
    }

    public Object OL() {
        return this.bgW;
    }

    public void K(Object obj) {
        this.bgW = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bgY;
    }

    public int getSkinType() {
        return this.azP;
    }

    public void setSkinType(int i) {
        this.azP = i;
    }
}
