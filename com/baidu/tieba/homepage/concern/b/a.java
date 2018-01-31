package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes2.dex */
public class a implements i {
    public static final BdUniqueId ecq = BdUniqueId.gen();
    public static final BdUniqueId ecr = BdUniqueId.gen();
    public String aYa;
    public int ecs;
    public boolean ect;
    public boolean ecu;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        switch (this.ecs) {
            case 2:
            case 3:
                return ecr;
            default:
                return ecq;
        }
    }
}
