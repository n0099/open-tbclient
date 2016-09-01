package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends cf<com.baidu.tieba.card.data.k> {
    final /* synthetic */ o cFQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.cFQ = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        com.baidu.tieba.card.o oVar;
        com.baidu.tieba.card.o oVar2;
        com.baidu.tieba.card.o oVar3;
        com.baidu.tieba.card.o oVar4;
        com.baidu.tieba.card.o oVar5;
        com.baidu.tieba.card.o oVar6;
        com.baidu.tieba.card.o oVar7;
        com.baidu.tieba.card.o oVar8;
        if (view != null) {
            oVar = this.cFQ.cFO;
            if (oVar != null) {
                oVar2 = this.cFQ.cFO;
                if (oVar2.aYU != null) {
                    oVar3 = this.cFQ.cFO;
                    if (oVar3.aYU.aYZ != null) {
                        oVar4 = this.cFQ.cFO;
                        if (oVar4.aYU.aYX != null) {
                            oVar5 = this.cFQ.cFO;
                            if (oVar5.aYU.getView() != null) {
                                int id = view.getId();
                                oVar6 = this.cFQ.cFO;
                                if (id == oVar6.aYU.aYZ.getId() && (view.getTag() instanceof MetaData)) {
                                    if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                                        TiebaStatic.log(new ay("c10803").s("obj_locate", 6));
                                        return;
                                    }
                                    return;
                                }
                                int id2 = view.getId();
                                oVar7 = this.cFQ.cFO;
                                if (id2 != oVar7.aYU.getView().getId()) {
                                    int id3 = view.getId();
                                    oVar8 = this.cFQ.cFO;
                                    if (id3 != oVar8.aYU.aYX.getId()) {
                                        return;
                                    }
                                }
                                if (view.getTag(t.g.rec_god_item_root) instanceof String) {
                                    TiebaStatic.log(new ay("c11005").ab("obj_id", (String) view.getTag(t.g.rec_god_item_root)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
