package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes9.dex */
public class c implements m {
    public static final BdUniqueId hJw = BdUniqueId.gen();
    public static final BdUniqueId hJx = BdUniqueId.gen();
    public boolean hJA;
    public int hJy;
    public boolean hJz;
    public String tipString;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        switch (this.hJy) {
            case 2:
            case 3:
                return hJx;
            default:
                return hJw;
        }
    }
}
