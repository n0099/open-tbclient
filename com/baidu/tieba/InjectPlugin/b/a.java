package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private BdTypeListView aRs;
    private Map<String, String> aRt;
    private Object aRu;
    private boolean aRv;
    private int aRw;
    private int aoa;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aRv = false;
    }

    public BdTypeListView getListView() {
        return this.aRs;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aRs = bdTypeListView;
    }

    public Object Jg() {
        return this.aRu;
    }

    public void J(Object obj) {
        this.aRu = obj;
    }

    public Map<String, String> Jh() {
        return this.aRt;
    }

    public void setParams(Map<String, String> map) {
        this.aRt = map;
    }

    public int Ji() {
        return this.aRw;
    }

    public int getSkinType() {
        return this.aoa;
    }

    public void setSkinType(int i) {
        this.aoa = i;
    }
}
