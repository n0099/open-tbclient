package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends ci<com.baidu.tieba.card.data.h> {
    final /* synthetic */ s cJU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cJU = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, com.baidu.tieba.card.data.h hVar) {
        com.baidu.tieba.card.m mVar;
        com.baidu.tieba.card.m mVar2;
        com.baidu.tieba.card.m mVar3;
        com.baidu.tieba.card.m mVar4;
        com.baidu.tieba.card.m mVar5;
        com.baidu.tieba.card.m mVar6;
        com.baidu.tieba.card.m mVar7;
        com.baidu.tieba.card.m mVar8;
        if (view != null) {
            mVar = this.cJU.cJS;
            if (mVar != null) {
                mVar2 = this.cJU.cJS;
                if (mVar2.bAW != null) {
                    mVar3 = this.cJU.cJS;
                    if (mVar3.bAW.bBc != null) {
                        mVar4 = this.cJU.cJS;
                        if (mVar4.bAW.bAZ != null) {
                            mVar5 = this.cJU.cJS;
                            if (mVar5.bAW.getView() != null) {
                                int id = view.getId();
                                mVar6 = this.cJU.cJS;
                                if (id == mVar6.bAW.bBc.getId() && (view.getTag() instanceof MetaData)) {
                                    if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                                        TiebaStatic.log(new au("c10803").r("obj_locate", 6));
                                        return;
                                    }
                                    return;
                                }
                                int id2 = view.getId();
                                mVar7 = this.cJU.cJS;
                                if (id2 != mVar7.bAW.getView().getId()) {
                                    int id3 = view.getId();
                                    mVar8 = this.cJU.cJS;
                                    if (id3 != mVar8.bAW.bAZ.getId()) {
                                        return;
                                    }
                                }
                                if (view.getTag(w.h.rec_god_item_root) instanceof String) {
                                    TiebaStatic.log(new au("c11005").Z("obj_id", (String) view.getTag(w.h.rec_god_item_root)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
