package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int ayX;
    private j bfH;
    private Object bfI;
    private boolean bfJ;
    private int bfK;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bfJ = false;
    }

    public j Or() {
        return this.bfH;
    }

    public void a(j jVar) {
        this.bfH = jVar;
    }

    public Object Os() {
        return this.bfI;
    }

    public void K(Object obj) {
        this.bfI = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bfK;
    }

    public int getSkinType() {
        return this.ayX;
    }

    public void setSkinType(int i) {
        this.ayX = i;
    }
}
