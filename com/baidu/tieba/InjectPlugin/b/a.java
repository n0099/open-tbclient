package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private k bLr;
    private Object bLs;
    private boolean bLt;
    private int bLu;
    private int bdE;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bLt = false;
    }

    public k Sc() {
        return this.bLr;
    }

    public void a(k kVar) {
        this.bLr = kVar;
    }

    public Object Sd() {
        return this.bLs;
    }

    public void aM(Object obj) {
        this.bLs = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bLu;
    }

    public int getSkinType() {
        return this.bdE;
    }

    public void setSkinType(int i) {
        this.bdE = i;
    }
}
