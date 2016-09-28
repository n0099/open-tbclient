package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends cd<com.baidu.tieba.card.data.k> {
    final /* synthetic */ o cGE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.cGE = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        com.baidu.tieba.card.m mVar;
        com.baidu.tieba.card.m mVar2;
        com.baidu.tieba.card.m mVar3;
        com.baidu.tieba.card.m mVar4;
        com.baidu.tieba.card.m mVar5;
        com.baidu.tieba.card.m mVar6;
        com.baidu.tieba.card.m mVar7;
        com.baidu.tieba.card.m mVar8;
        if (view != null) {
            mVar = this.cGE.cGC;
            if (mVar != null) {
                mVar2 = this.cGE.cGC;
                if (mVar2.aZo != null) {
                    mVar3 = this.cGE.cGC;
                    if (mVar3.aZo.aZt != null) {
                        mVar4 = this.cGE.cGC;
                        if (mVar4.aZo.aZr != null) {
                            mVar5 = this.cGE.cGC;
                            if (mVar5.aZo.getView() != null) {
                                int id = view.getId();
                                mVar6 = this.cGE.cGC;
                                if (id == mVar6.aZo.aZt.getId() && (view.getTag() instanceof MetaData)) {
                                    if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                                        TiebaStatic.log(new ax("c10803").s("obj_locate", 6));
                                        return;
                                    }
                                    return;
                                }
                                int id2 = view.getId();
                                mVar7 = this.cGE.cGC;
                                if (id2 != mVar7.aZo.getView().getId()) {
                                    int id3 = view.getId();
                                    mVar8 = this.cGE.cGC;
                                    if (id3 != mVar8.aZo.aZr.getId()) {
                                        return;
                                    }
                                }
                                if (view.getTag(r.g.rec_god_item_root) instanceof String) {
                                    TiebaStatic.log(new ax("c11005").ab("obj_id", (String) view.getTag(r.g.rec_god_item_root)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
