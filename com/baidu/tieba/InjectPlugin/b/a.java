package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int aXA;
    private BdTypeListView aXw;
    private Map<String, String> aXx;
    private Object aXy;
    private boolean aXz;
    private int apA;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aXz = false;
    }

    public BdTypeListView getListView() {
        return this.aXw;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aXw = bdTypeListView;
    }

    public Object KC() {
        return this.aXy;
    }

    public void H(Object obj) {
        this.aXy = obj;
    }

    public Map<String, String> KD() {
        return this.aXx;
    }

    public void setParams(Map<String, String> map) {
        this.aXx = map;
    }

    public int KE() {
        return this.aXA;
    }

    public int getSkinType() {
        return this.apA;
    }

    public void setSkinType(int i) {
        this.apA = i;
    }
}
