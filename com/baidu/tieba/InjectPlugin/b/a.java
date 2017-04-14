package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private BdTypeListView aPE;
    private Map<String, String> aPF;
    private Object aPG;
    private boolean aPH;
    private int aPI;
    private int amZ;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aPH = false;
    }

    public BdTypeListView getListView() {
        return this.aPE;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aPE = bdTypeListView;
    }

    public Object Jy() {
        return this.aPG;
    }

    public void J(Object obj) {
        this.aPG = obj;
    }

    public Map<String, String> Jz() {
        return this.aPF;
    }

    public void setParams(Map<String, String> map) {
        this.aPF = map;
    }

    public void ce(boolean z) {
        this.aPH = z;
    }

    public int JA() {
        return this.aPI;
    }

    public void setMaskColor(int i) {
        this.aPI = i;
    }

    public int getSkinType() {
        return this.amZ;
    }

    public void setSkinType(int i) {
        this.amZ = i;
    }
}
