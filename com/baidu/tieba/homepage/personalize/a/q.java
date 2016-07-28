package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends bx<com.baidu.tieba.card.a.k> {
    final /* synthetic */ p cum;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.cum = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bx
    public void a(View view, com.baidu.tieba.card.a.k kVar) {
        com.baidu.tieba.card.u uVar;
        com.baidu.tieba.card.u uVar2;
        com.baidu.tieba.card.u uVar3;
        com.baidu.tieba.card.u uVar4;
        com.baidu.tieba.card.u uVar5;
        com.baidu.tieba.card.u uVar6;
        com.baidu.tieba.card.u uVar7;
        com.baidu.tieba.card.u uVar8;
        if (view != null) {
            uVar = this.cum.cuk;
            if (uVar != null) {
                uVar2 = this.cum.cuk;
                if (uVar2.aTM != null) {
                    uVar3 = this.cum.cuk;
                    if (uVar3.aTM.aTR != null) {
                        uVar4 = this.cum.cuk;
                        if (uVar4.aTM.aTP != null) {
                            uVar5 = this.cum.cuk;
                            if (uVar5.aTM.getView() != null) {
                                int id = view.getId();
                                uVar6 = this.cum.cuk;
                                if (id == uVar6.aTM.aTR.getId() && (view.getTag() instanceof MetaData)) {
                                    if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                                        TiebaStatic.log(new ay("c10803").s("obj_locate", 6));
                                        return;
                                    }
                                    return;
                                }
                                int id2 = view.getId();
                                uVar7 = this.cum.cuk;
                                if (id2 != uVar7.aTM.getView().getId()) {
                                    int id3 = view.getId();
                                    uVar8 = this.cum.cuk;
                                    if (id3 != uVar8.aTM.aTP.getId()) {
                                        return;
                                    }
                                }
                                if (view.getTag(u.g.rec_god_item_root) instanceof String) {
                                    TiebaStatic.log(new ay("c11005").ab("obj_id", (String) view.getTag(u.g.rec_god_item_root)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
