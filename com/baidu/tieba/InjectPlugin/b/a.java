package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private boolean bNA;
    private int bNB;
    private k bNy;
    private Object bNz;
    private int bfz;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bNA = false;
    }

    public k Sv() {
        return this.bNy;
    }

    public void a(k kVar) {
        this.bNy = kVar;
    }

    public Object Sw() {
        return this.bNz;
    }

    public void aM(Object obj) {
        this.bNz = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bNB;
    }

    public int getSkinType() {
        return this.bfz;
    }

    public void setSkinType(int i) {
        this.bfz = i;
    }
}
