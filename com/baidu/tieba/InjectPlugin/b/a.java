package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private BdTypeListView aXC;
    private Map<String, String> aXD;
    private Object aXE;
    private boolean aXF;
    private int aXG;
    private int apG;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aXF = false;
    }

    public BdTypeListView getListView() {
        return this.aXC;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aXC = bdTypeListView;
    }

    public Object KD() {
        return this.aXE;
    }

    public void H(Object obj) {
        this.aXE = obj;
    }

    public Map<String, String> KE() {
        return this.aXD;
    }

    public void setParams(Map<String, String> map) {
        this.aXD = map;
    }

    public int getMaskColor() {
        return this.aXG;
    }

    public int getSkinType() {
        return this.apG;
    }

    public void setSkinType(int i) {
        this.apG = i;
    }
}
