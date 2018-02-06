package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private k bNL;
    private Object bNM;
    private boolean bNN;
    private int bNO;
    private int bfL;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.bNN = false;
    }

    public k Sw() {
        return this.bNL;
    }

    public void a(k kVar) {
        this.bNL = kVar;
    }

    public Object Sx() {
        return this.bNM;
    }

    public void aM(Object obj) {
        this.bNM = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.bNO;
    }

    public int getSkinType() {
        return this.bfL;
    }

    public void setSkinType(int i) {
        this.bfL = i;
    }
}
