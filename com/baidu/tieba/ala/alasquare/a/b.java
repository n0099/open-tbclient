package com.baidu.tieba.ala.alasquare.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId gyz = BdUniqueId.gen();
    public cb gyA;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return gyz;
    }

    public cb bln() {
        return this.gyA;
    }

    public ar az(String str, boolean z) {
        cb bln = bln();
        if (bln == null || bln.eSY == null) {
            return null;
        }
        return new ar(str).v("obj_locate", bln.eSY.eMi);
    }
}
