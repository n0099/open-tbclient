package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private BdTypeListView aPo;
    private Map<String, String> aPp;
    private Object aPq;
    private boolean aPr;
    private int aPs;
    private int amL;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aPr = false;
    }

    public BdTypeListView getListView() {
        return this.aPo;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aPo = bdTypeListView;
    }

    public Object IY() {
        return this.aPq;
    }

    public void J(Object obj) {
        this.aPq = obj;
    }

    public Map<String, String> IZ() {
        return this.aPp;
    }

    public void setParams(Map<String, String> map) {
        this.aPp = map;
    }

    public void cc(boolean z) {
        this.aPr = z;
    }

    public int Ja() {
        return this.aPs;
    }

    public void setMaskColor(int i) {
        this.aPs = i;
    }

    public int getSkinType() {
        return this.amL;
    }

    public void setSkinType(int i) {
        this.amL = i;
    }
}
