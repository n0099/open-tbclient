package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
/* loaded from: classes.dex */
public class a implements f {
    public static final BdUniqueId dnt = BdUniqueId.gen();
    public static final BdUniqueId dnu = BdUniqueId.gen();
    public String ajK;
    public int dnv;
    public boolean dnw;
    public boolean dnx;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        switch (this.dnv) {
            case 2:
            case 3:
                return dnu;
            default:
                return dnt;
        }
    }
}
