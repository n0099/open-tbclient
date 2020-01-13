package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int MH;
    private o dOU;
    private Object dOV;
    private boolean dOW;
    private int maskColor;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.dOW = false;
    }

    public o aTm() {
        return this.dOU;
    }

    public void a(o oVar) {
        this.dOU = oVar;
    }

    public Object aTn() {
        return this.dOV;
    }

    public void am(Object obj) {
        this.dOV = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.maskColor;
    }

    public int getSkinType() {
        return this.MH;
    }

    public void setSkinType(int i) {
        this.MH = i;
    }
}
