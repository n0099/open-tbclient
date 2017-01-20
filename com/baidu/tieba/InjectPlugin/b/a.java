package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private BdTypeListView aJF;
    private Map<String, String> aJG;
    private Object aJH;
    private boolean aJI;
    private int aJJ;
    private int ahp;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aJI = false;
    }

    public BdTypeListView Iv() {
        return this.aJF;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aJF = bdTypeListView;
    }

    public Object Iw() {
        return this.aJH;
    }

    public void J(Object obj) {
        this.aJH = obj;
    }

    public Map<String, String> Ix() {
        return this.aJG;
    }

    public void setParams(Map<String, String> map) {
        this.aJG = map;
    }

    public void cd(boolean z) {
        this.aJI = z;
    }

    public int Iy() {
        return this.aJJ;
    }

    public void setMaskColor(int i) {
        this.aJJ = i;
    }

    public int getSkinType() {
        return this.ahp;
    }

    public void setSkinType(int i) {
        this.ahp = i;
    }
}
