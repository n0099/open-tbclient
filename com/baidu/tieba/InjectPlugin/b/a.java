package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private BdTypeListView aSB;
    private Map<String, String> aSC;
    private Object aSD;
    private boolean aSE;
    private int aSF;
    private int aoR;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aSE = false;
    }

    public BdTypeListView getListView() {
        return this.aSB;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aSB = bdTypeListView;
    }

    public Object Js() {
        return this.aSD;
    }

    public void J(Object obj) {
        this.aSD = obj;
    }

    public Map<String, String> Jt() {
        return this.aSC;
    }

    public void setParams(Map<String, String> map) {
        this.aSC = map;
    }

    public int Ju() {
        return this.aSF;
    }

    public int getSkinType() {
        return this.aoR;
    }

    public void setSkinType(int i) {
        this.aoR = i;
    }
}
