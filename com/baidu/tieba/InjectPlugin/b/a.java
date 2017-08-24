package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private BdTypeListView aTP;
    private Map<String, String> aTQ;
    private Object aTR;
    private boolean aTS;
    private int aTT;
    private int aqm;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aTS = false;
    }

    public BdTypeListView getListView() {
        return this.aTP;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aTP = bdTypeListView;
    }

    public Object Jz() {
        return this.aTR;
    }

    public void J(Object obj) {
        this.aTR = obj;
    }

    public Map<String, String> getParams() {
        return this.aTQ;
    }

    public void setParams(Map<String, String> map) {
        this.aTQ = map;
    }

    public int JA() {
        return this.aTT;
    }

    public int getSkinType() {
        return this.aqm;
    }

    public void setSkinType(int i) {
        this.aqm = i;
    }
}
