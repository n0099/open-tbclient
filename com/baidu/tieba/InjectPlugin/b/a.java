package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.p;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int aln;
    private int fQz;
    private p gdV;
    private Object gdW;
    private boolean gdX;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.gdX = false;
    }

    public p bJI() {
        return this.gdV;
    }

    public void a(p pVar) {
        this.gdV = pVar;
    }

    public Object bJJ() {
        return this.gdW;
    }

    public void aF(Object obj) {
        this.gdW = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.fQz;
    }

    public int getSkinType() {
        return this.aln;
    }

    public void setSkinType(int i) {
        this.aln = i;
    }
}
