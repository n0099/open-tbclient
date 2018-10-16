package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int aHp;
    private j brv;
    private Object brw;
    private boolean brx;
    private int bry;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.brx = false;
    }

    public j SD() {
        return this.brv;
    }

    public void a(j jVar) {
        this.brv = jVar;
    }

    public Object SE() {
        return this.brw;
    }

    public void R(Object obj) {
        this.brw = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bry;
    }

    public int getSkinType() {
        return this.aHp;
    }

    public void setSkinType(int i) {
        this.aHp = i;
    }
}
