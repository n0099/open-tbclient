package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int ahx;
    private int eGc;
    private s eSE;
    private Object eSF;
    private boolean eSG;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.eSG = false;
    }

    public s bmE() {
        return this.eSE;
    }

    public void a(s sVar) {
        this.eSE = sVar;
    }

    public Object bmF() {
        return this.eSF;
    }

    public void au(Object obj) {
        this.eSF = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.eGc;
    }

    public int getSkinType() {
        return this.ahx;
    }

    public void setSkinType(int i) {
        this.ahx = i;
    }
}
