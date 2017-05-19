package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private BdTypeListView aPZ;
    private Map<String, String> aQa;
    private Object aQb;
    private boolean aQc;
    private int aQd;
    private int ane;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aQc = false;
    }

    public BdTypeListView getListView() {
        return this.aPZ;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aPZ = bdTypeListView;
    }

    public Object IM() {
        return this.aQb;
    }

    public void J(Object obj) {
        this.aQb = obj;
    }

    public Map<String, String> IN() {
        return this.aQa;
    }

    public void setParams(Map<String, String> map) {
        this.aQa = map;
    }

    public int IO() {
        return this.aQd;
    }

    public int getSkinType() {
        return this.ane;
    }

    public void setSkinType(int i) {
        this.ane = i;
    }
}
