package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends bz<com.baidu.tieba.card.data.k> {
    final /* synthetic */ o cLP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.cLP = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bz
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
            mVar = this.cLP.cLN;
            if (mVar != null) {
                mVar2 = this.cLP.cLN;
                if (mVar2.bcx != null) {
                    mVar3 = this.cLP.cLN;
                    if (mVar3.bcx.bcC != null) {
                        mVar4 = this.cLP.cLN;
                        if (mVar4.bcx.bcA != null) {
                            mVar5 = this.cLP.cLN;
                            if (mVar5.bcx.getView() != null) {
                                int id = view.getId();
                                mVar6 = this.cLP.cLN;
                                if (id == mVar6.bcx.bcC.getId() && (view.getTag() instanceof MetaData)) {
                                    if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                                        TiebaStatic.log(new av("c10803").s("obj_locate", 6));
                                        return;
                                    }
                                    return;
                                }
                                int id2 = view.getId();
                                mVar7 = this.cLP.cLN;
                                if (id2 != mVar7.bcx.getView().getId()) {
                                    int id3 = view.getId();
                                    mVar8 = this.cLP.cLN;
                                    if (id3 != mVar8.bcx.bcA.getId()) {
                                        return;
                                    }
                                }
                                if (view.getTag(r.g.rec_god_item_root) instanceof String) {
                                    TiebaStatic.log(new av("c11005").ab("obj_id", (String) view.getTag(r.g.rec_god_item_root)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
