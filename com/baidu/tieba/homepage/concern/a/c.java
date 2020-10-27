package com.baidu.tieba.homepage.concern.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes22.dex */
public class c implements q {
    public static final BdUniqueId jqW = BdUniqueId.gen();
    public static final BdUniqueId jqX = BdUniqueId.gen();
    public int jqY;
    public boolean jqZ;
    public boolean jra;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.jqY) {
            case 2:
            case 3:
                return jqX;
            default:
                return jqW;
        }
    }
}
