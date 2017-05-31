package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends ci<com.baidu.tieba.card.data.h> {
    final /* synthetic */ s cBX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cBX = sVar;
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
            mVar = this.cBX.cBV;
            if (mVar != null) {
                mVar2 = this.cBX.cBV;
                if (mVar2.bAd != null) {
                    mVar3 = this.cBX.cBV;
                    if (mVar3.bAd.bAj != null) {
                        mVar4 = this.cBX.cBV;
                        if (mVar4.bAd.bAg != null) {
                            mVar5 = this.cBX.cBV;
                            if (mVar5.bAd.getView() != null) {
                                int id = view.getId();
                                mVar6 = this.cBX.cBV;
                                if (id == mVar6.bAd.bAj.getId() && (view.getTag() instanceof MetaData)) {
                                    if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                                        TiebaStatic.log(new as("c10803").r("obj_locate", 6));
                                        return;
                                    }
                                    return;
                                }
                                int id2 = view.getId();
                                mVar7 = this.cBX.cBV;
                                if (id2 != mVar7.bAd.getView().getId()) {
                                    int id3 = view.getId();
                                    mVar8 = this.cBX.cBV;
                                    if (id3 != mVar8.bAd.bAg.getId()) {
                                        return;
                                    }
                                }
                                if (view.getTag(w.h.rec_god_item_root) instanceof String) {
                                    TiebaStatic.log(new as("c11005").Z("obj_id", (String) view.getTag(w.h.rec_god_item_root)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
