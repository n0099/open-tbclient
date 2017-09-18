package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int aTA;
    private BdTypeListView aTw;
    private Map<String, String> aTx;
    private Object aTy;
    private boolean aTz;
    private int apQ;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aTz = false;
    }

    public BdTypeListView getListView() {
        return this.aTw;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aTw = bdTypeListView;
    }

    public Object JH() {
        return this.aTy;
    }

    public void I(Object obj) {
        this.aTy = obj;
    }

    public Map<String, String> JI() {
        return this.aTx;
    }

    public void setParams(Map<String, String> map) {
        this.aTx = map;
    }

    public int JJ() {
        return this.aTA;
    }

    public int getSkinType() {
        return this.apQ;
    }

    public void setSkinType(int i) {
        this.apQ = i;
    }
}
