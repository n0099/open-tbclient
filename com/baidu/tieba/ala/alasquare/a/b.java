package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes9.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId gAw = BdUniqueId.gen();
    public cb gAx;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gAw;
    }

    public cb blp() {
        return this.gAx;
    }

    public ar az(String str, boolean z) {
        cb blp = blp();
        if (blp == null || blp.eUz == null) {
            return null;
        }
        return new ar(str).v("obj_locate", blp.eUz.eNJ);
    }
}
