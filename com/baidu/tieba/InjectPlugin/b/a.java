package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private BdTypeListView aUi;
    private Map<String, String> aUj;
    private Object aUk;
    private boolean aUl;
    private int aUm;
    private int aoN;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aUl = false;
    }

    public BdTypeListView getListView() {
        return this.aUi;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aUi = bdTypeListView;
    }

    public Object JK() {
        return this.aUk;
    }

    public void H(Object obj) {
        this.aUk = obj;
    }

    public Map<String, String> JL() {
        return this.aUj;
    }

    public void setParams(Map<String, String> map) {
        this.aUj = map;
    }

    public int JM() {
        return this.aUm;
    }

    public int getSkinType() {
        return this.aoN;
    }

    public void setSkinType(int i) {
        this.aoN = i;
    }
}
