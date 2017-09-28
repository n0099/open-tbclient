package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private BdTypeListView aUv;
    private Map<String, String> aUw;
    private Object aUx;
    private boolean aUy;
    private int aUz;
    private int aoZ;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aUy = false;
    }

    public BdTypeListView getListView() {
        return this.aUv;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aUv = bdTypeListView;
    }

    public Object JQ() {
        return this.aUx;
    }

    public void H(Object obj) {
        this.aUx = obj;
    }

    public Map<String, String> JR() {
        return this.aUw;
    }

    public void setParams(Map<String, String> map) {
        this.aUw = map;
    }

    public int JS() {
        return this.aUz;
    }

    public int getSkinType() {
        return this.aoZ;
    }

    public void setSkinType(int i) {
        this.aoZ = i;
    }
}
