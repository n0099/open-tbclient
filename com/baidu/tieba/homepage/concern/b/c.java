package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes9.dex */
public class c implements q {
    public static final BdUniqueId ino = BdUniqueId.gen();
    public static final BdUniqueId inp = BdUniqueId.gen();
    public int inq;
    public boolean inr;

    /* renamed from: int  reason: not valid java name */
    public boolean f7int;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        switch (this.inq) {
            case 2:
            case 3:
                return inp;
            default:
                return ino;
        }
    }
}
