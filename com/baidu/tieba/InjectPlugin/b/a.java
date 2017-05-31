package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private BdTypeListView aQa;
    private Map<String, String> aQb;
    private Object aQc;
    private boolean aQd;
    private int aQe;
    private int ana;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aQd = false;
    }

    public BdTypeListView getListView() {
        return this.aQa;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aQa = bdTypeListView;
    }

    public Object II() {
        return this.aQc;
    }

    public void J(Object obj) {
        this.aQc = obj;
    }

    public Map<String, String> IJ() {
        return this.aQb;
    }

    public void setParams(Map<String, String> map) {
        this.aQb = map;
    }

    public int IK() {
        return this.aQe;
    }

    public int getSkinType() {
        return this.ana;
    }

    public void setSkinType(int i) {
        this.ana = i;
    }
}
