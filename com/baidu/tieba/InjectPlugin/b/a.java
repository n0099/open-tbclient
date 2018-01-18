package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private Object bLA;
    private boolean bLB;
    private int bLC;
    private k bLz;
    private int bdK;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bLB = false;
    }

    public k RQ() {
        return this.bLz;
    }

    public void a(k kVar) {
        this.bLz = kVar;
    }

    public Object RR() {
        return this.bLA;
    }

    public void aM(Object obj) {
        this.bLA = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bLC;
    }

    public int getSkinType() {
        return this.bdK;
    }

    public void setSkinType(int i) {
        this.bdK = i;
    }
}
