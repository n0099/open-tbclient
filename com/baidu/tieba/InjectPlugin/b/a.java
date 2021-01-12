package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.p;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int akf;
    private int fMM;
    private p fZX;
    private Object fZY;
    private boolean fZZ;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.fZZ = false;
    }

    public p bJf() {
        return this.fZX;
    }

    public void a(p pVar) {
        this.fZX = pVar;
    }

    public Object bJg() {
        return this.fZY;
    }

    public void aD(Object obj) {
        this.fZY = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.fMM;
    }

    public int getSkinType() {
        return this.akf;
    }

    public void setSkinType(int i) {
        this.akf = i;
    }
}
