package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes6.dex */
public class a implements h {
    public static final BdUniqueId ekd = BdUniqueId.gen();
    public static final BdUniqueId eke = BdUniqueId.gen();
    public String aCg;
    public int ekf;
    public boolean ekg;
    public boolean ekh;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        switch (this.ekf) {
            case 2:
            case 3:
                return eke;
            default:
                return ekd;
        }
    }
}
