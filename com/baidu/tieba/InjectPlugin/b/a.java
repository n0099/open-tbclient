package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private BdTypeListView aTN;
    private Map<String, String> aTO;
    private Object aTP;
    private boolean aTQ;
    private int aTR;
    private int aql;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aTQ = false;
    }

    public BdTypeListView getListView() {
        return this.aTN;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aTN = bdTypeListView;
    }

    public Object Jz() {
        return this.aTP;
    }

    public void J(Object obj) {
        this.aTP = obj;
    }

    public Map<String, String> getParams() {
        return this.aTO;
    }

    public void setParams(Map<String, String> map) {
        this.aTO = map;
    }

    public int JA() {
        return this.aTR;
    }

    public int getSkinType() {
        return this.aql;
    }

    public void setSkinType(int i) {
        this.aql = i;
    }
}
