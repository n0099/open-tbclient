package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends cd<com.baidu.tieba.card.data.h> {
    final /* synthetic */ q cvD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cvD = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, com.baidu.tieba.card.data.h hVar) {
        com.baidu.tieba.card.i iVar;
        com.baidu.tieba.card.i iVar2;
        com.baidu.tieba.card.i iVar3;
        com.baidu.tieba.card.i iVar4;
        com.baidu.tieba.card.i iVar5;
        com.baidu.tieba.card.i iVar6;
        com.baidu.tieba.card.i iVar7;
        com.baidu.tieba.card.i iVar8;
        if (view != null) {
            iVar = this.cvD.cvB;
            if (iVar != null) {
                iVar2 = this.cvD.cvB;
                if (iVar2.bup != null) {
                    iVar3 = this.cvD.cvB;
                    if (iVar3.bup.buv != null) {
                        iVar4 = this.cvD.cvB;
                        if (iVar4.bup.bus != null) {
                            iVar5 = this.cvD.cvB;
                            if (iVar5.bup.getView() != null) {
                                int id = view.getId();
                                iVar6 = this.cvD.cvB;
                                if (id == iVar6.bup.buv.getId() && (view.getTag() instanceof MetaData)) {
                                    if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                                        TiebaStatic.log(new as("c10803").s("obj_locate", 6));
                                        return;
                                    }
                                    return;
                                }
                                int id2 = view.getId();
                                iVar7 = this.cvD.cvB;
                                if (id2 != iVar7.bup.getView().getId()) {
                                    int id3 = view.getId();
                                    iVar8 = this.cvD.cvB;
                                    if (id3 != iVar8.bup.bus.getId()) {
                                        return;
                                    }
                                }
                                if (view.getTag(w.h.rec_god_item_root) instanceof String) {
                                    TiebaStatic.log(new as("c11005").aa("obj_id", (String) view.getTag(w.h.rec_god_item_root)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
