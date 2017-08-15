package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private BdTypeListView aTO;
    private Map<String, String> aTP;
    private Object aTQ;
    private boolean aTR;
    private int aTS;
    private int aqm;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aTR = false;
    }

    public BdTypeListView getListView() {
        return this.aTO;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aTO = bdTypeListView;
    }

    public Object Jz() {
        return this.aTQ;
    }

    public void J(Object obj) {
        this.aTQ = obj;
    }

    public Map<String, String> getParams() {
        return this.aTP;
    }

    public void setParams(Map<String, String> map) {
        this.aTP = map;
    }

    public int JA() {
        return this.aTS;
    }

    public int getSkinType() {
        return this.aqm;
    }

    public void setSkinType(int i) {
        this.aqm = i;
    }
}
