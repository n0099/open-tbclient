package com.baidu.tieba.ala.frsgamelive.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dHY = BdUniqueId.gen();
    public static final BdUniqueId dHZ = BdUniqueId.gen();
    public bh caz;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return (this.caz == null || this.caz.aiX() == null || this.caz.aiX().live_type != 1) ? dHY : dHZ;
    }
}
