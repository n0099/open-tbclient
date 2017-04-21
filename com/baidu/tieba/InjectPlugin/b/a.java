package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private BdTypeListView aPG;
    private Map<String, String> aPH;
    private Object aPI;
    private boolean aPJ;
    private int aPK;
    private int amZ;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aPJ = false;
    }

    public BdTypeListView getListView() {
        return this.aPG;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aPG = bdTypeListView;
    }

    public Object Jy() {
        return this.aPI;
    }

    public void J(Object obj) {
        this.aPI = obj;
    }

    public Map<String, String> Jz() {
        return this.aPH;
    }

    public void setParams(Map<String, String> map) {
        this.aPH = map;
    }

    public void ce(boolean z) {
        this.aPJ = z;
    }

    public int JA() {
        return this.aPK;
    }

    public void setMaskColor(int i) {
        this.aPK = i;
    }

    public int getSkinType() {
        return this.amZ;
    }

    public void setSkinType(int i) {
        this.amZ = i;
    }
}
