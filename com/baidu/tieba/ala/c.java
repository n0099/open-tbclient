package com.baidu.tieba.ala;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private static c fgi;
    private List<ao> eXh;

    public static c brT() {
        if (fgi == null) {
            synchronized (c.class) {
                if (fgi == null) {
                    fgi = new c();
                }
            }
        }
        return fgi;
    }

    public void e(ao aoVar) {
        if (aoVar != null) {
            if (this.eXh == null) {
                this.eXh = new ArrayList();
            }
            if (this.eXh != null) {
                this.eXh.add(aoVar);
            }
        }
    }

    public void brU() {
        if (w.getCount(this.eXh) != 0) {
            for (ao aoVar : this.eXh) {
                if (aoVar != null) {
                    TiebaStatic.log(aoVar);
                }
            }
            this.eXh.clear();
        }
    }
}
