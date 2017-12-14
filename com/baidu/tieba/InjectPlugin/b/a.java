package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private Object aXA;
    private boolean aXB;
    private int aXC;
    private BdTypeListView aXy;
    private Map<String, String> aXz;
    private int apD;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aXB = false;
    }

    public BdTypeListView getListView() {
        return this.aXy;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aXy = bdTypeListView;
    }

    public Object KD() {
        return this.aXA;
    }

    public void H(Object obj) {
        this.aXA = obj;
    }

    public Map<String, String> KE() {
        return this.aXz;
    }

    public void setParams(Map<String, String> map) {
        this.aXz = map;
    }

    public int getMaskColor() {
        return this.aXC;
    }

    public int getSkinType() {
        return this.apD;
    }

    public void setSkinType(int i) {
        this.apD = i;
    }
}
