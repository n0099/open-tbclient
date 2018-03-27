package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private k bNB;
    private Object bNC;
    private boolean bND;
    private int bNE;
    private int bfC;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bND = false;
    }

    public k Sw() {
        return this.bNB;
    }

    public void a(k kVar) {
        this.bNB = kVar;
    }

    public Object Sx() {
        return this.bNC;
    }

    public void aM(Object obj) {
        this.bNC = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bNE;
    }

    public int getSkinType() {
        return this.bfC;
    }

    public void setSkinType(int i) {
        this.bfC = i;
    }
}
