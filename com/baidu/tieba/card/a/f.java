package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EcommPersonManagerActivityConfig;
import com.baidu.tbadk.core.data.az;
/* loaded from: classes.dex */
public class f extends c {
    public static final BdUniqueId aVb = BdUniqueId.gen();
    public az aVc;

    public f(az azVar) {
        this.aVc = azVar;
    }

    public static boolean c(az azVar) {
        return azVar != null && azVar.isDeal && azVar.Rl != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aVb;
    }

    @Override // com.baidu.tieba.card.a.c
    public az Ix() {
        return this.aVc;
    }
}
