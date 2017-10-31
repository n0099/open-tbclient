package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private BdTypeListView aUn;
    private Map<String, String> aUo;
    private Object aUp;
    private boolean aUq;
    private int aUr;
    private int api;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aUq = false;
    }

    public BdTypeListView getListView() {
        return this.aUn;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aUn = bdTypeListView;
    }

    public Object JU() {
        return this.aUp;
    }

    public void H(Object obj) {
        this.aUp = obj;
    }

    public Map<String, String> JV() {
        return this.aUo;
    }

    public void setParams(Map<String, String> map) {
        this.aUo = map;
    }

    public int JW() {
        return this.aUr;
    }

    public int getSkinType() {
        return this.api;
    }

    public void setSkinType(int i) {
        this.api = i;
    }
}
