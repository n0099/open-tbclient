package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private k bLH;
    private Object bLI;
    private boolean bLJ;
    private int bLK;
    private int bdS;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bLJ = false;
    }

    public k RS() {
        return this.bLH;
    }

    public void a(k kVar) {
        this.bLH = kVar;
    }

    public Object RT() {
        return this.bLI;
    }

    public void aM(Object obj) {
        this.bLI = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bLK;
    }

    public int getSkinType() {
        return this.bdS;
    }

    public void setSkinType(int i) {
        this.bdS = i;
    }
}
