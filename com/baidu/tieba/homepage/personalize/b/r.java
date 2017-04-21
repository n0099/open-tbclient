package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends cf<com.baidu.tieba.card.data.j> {
    final /* synthetic */ q cAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cAt = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.j jVar) {
        com.baidu.tieba.card.m mVar;
        com.baidu.tieba.card.m mVar2;
        com.baidu.tieba.card.m mVar3;
        com.baidu.tieba.card.m mVar4;
        com.baidu.tieba.card.m mVar5;
        com.baidu.tieba.card.m mVar6;
        com.baidu.tieba.card.m mVar7;
        com.baidu.tieba.card.m mVar8;
        if (view != null) {
            mVar = this.cAt.cAr;
            if (mVar != null) {
                mVar2 = this.cAt.cAr;
                if (mVar2.but != null) {
                    mVar3 = this.cAt.cAr;
                    if (mVar3.but.buA != null) {
                        mVar4 = this.cAt.cAr;
                        if (mVar4.but.buw != null) {
                            mVar5 = this.cAt.cAr;
                            if (mVar5.but.getView() != null) {
                                int id = view.getId();
                                mVar6 = this.cAt.cAr;
                                if (id == mVar6.but.buA.getId() && (view.getTag() instanceof MetaData)) {
                                    if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                                        TiebaStatic.log(new as("c10803").s("obj_locate", 6));
                                        return;
                                    }
                                    return;
                                }
                                int id2 = view.getId();
                                mVar7 = this.cAt.cAr;
                                if (id2 != mVar7.but.getView().getId()) {
                                    int id3 = view.getId();
                                    mVar8 = this.cAt.cAr;
                                    if (id3 != mVar8.but.buw.getId()) {
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
