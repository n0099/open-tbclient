package com.baidu.tieba.InjectPlugin.b;

import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a.g;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends g {
    private int aho;
    private int eMy;
    private s eYZ;
    private Object eZa;
    private boolean eZb;
    private Map<String, String> params;

    public a(TbPageContext tbPageContext, int i) {
        super(tbPageContext, i);
        this.eZb = false;
    }

    public s bqz() {
        return this.eYZ;
    }

    public void a(s sVar) {
        this.eYZ = sVar;
    }

    public Object bqA() {
        return this.eZa;
    }

    public void au(Object obj) {
        this.eZa = obj;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public int getMaskColor() {
        return this.eMy;
    }

    public int getSkinType() {
        return this.aho;
    }

    public void setSkinType(int i) {
        this.aho = i;
    }
}
