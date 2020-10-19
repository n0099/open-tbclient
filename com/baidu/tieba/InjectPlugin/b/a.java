package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int ajp;
    private int fml;
    private s fzC;
    private Object fzD;
    private boolean fzE;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.fzE = false;
    }

    public s bDt() {
        return this.fzC;
    }

    public void a(s sVar) {
        this.fzC = sVar;
    }

    public Object bDu() {
        return this.fzD;
    }

    public void aB(Object obj) {
        this.fzD = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.fml;
    }

    public int getSkinType() {
        return this.ajp;
    }

    public void setSkinType(int i) {
        this.ajp = i;
    }
}
