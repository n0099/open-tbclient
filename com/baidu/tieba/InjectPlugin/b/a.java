package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private Map<String, String> aTA;
    private Object aTB;
    private boolean aTC;
    private int aTD;
    private BdTypeListView aTz;
    private int apS;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.aTC = false;
    }

    public BdTypeListView getListView() {
        return this.aTz;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.aTz = bdTypeListView;
    }

    public Object JH() {
        return this.aTB;
    }

    public void I(Object obj) {
        this.aTB = obj;
    }

    public Map<String, String> JI() {
        return this.aTA;
    }

    public void setParams(Map<String, String> map) {
        this.aTA = map;
    }

    public int JJ() {
        return this.aTD;
    }

    public int getSkinType() {
        return this.apS;
    }

    public void setSkinType(int i) {
        this.apS = i;
    }
}
