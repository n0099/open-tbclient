package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EcommPersonManagerActivityConfig;
import com.baidu.tbadk.core.data.be;
/* loaded from: classes.dex */
public class f extends c {
    public static final BdUniqueId aVZ = BdUniqueId.gen();
    public be aWa;

    public f(be beVar) {
        this.aWa = beVar;
    }

    public static boolean c(be beVar) {
        return beVar != null && beVar.isDeal && beVar.RO != null && TbadkCoreApplication.m10getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aVZ;
    }

    @Override // com.baidu.tieba.card.a.c
    public be Iw() {
        return this.aWa;
    }
}
