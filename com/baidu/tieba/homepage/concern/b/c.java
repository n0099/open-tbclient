package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes16.dex */
public class c implements q {
    public static final BdUniqueId itr = BdUniqueId.gen();
    public static final BdUniqueId its = BdUniqueId.gen();
    public int itt;
    public boolean itu;
    public boolean itv;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.itt) {
            case 2:
            case 3:
                return its;
            default:
                return itr;
        }
    }
}
