package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ewk = BdUniqueId.gen();
    public static final BdUniqueId ewl = BdUniqueId.gen();
    public bj cMR;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return (this.cMR == null || this.cMR.azX() == null || this.cMR.azX().live_type != 1) ? ewk : ewl;
    }
}
