package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes2.dex */
public class a implements i {
    public static final BdUniqueId egq = BdUniqueId.gen();
    public static final BdUniqueId egr = BdUniqueId.gen();
    public String aZx;
    public int egs;
    public boolean egt;
    public boolean egu;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        switch (this.egs) {
            case 2:
            case 3:
                return egr;
            default:
                return egq;
        }
    }
}
