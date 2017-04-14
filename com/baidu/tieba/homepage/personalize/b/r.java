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
    final /* synthetic */ q cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cyc = qVar;
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
            mVar = this.cyc.cya;
            if (mVar != null) {
                mVar2 = this.cyc.cya;
                if (mVar2.bsb != null) {
                    mVar3 = this.cyc.cya;
                    if (mVar3.bsb.bsh != null) {
                        mVar4 = this.cyc.cya;
                        if (mVar4.bsb.bse != null) {
                            mVar5 = this.cyc.cya;
                            if (mVar5.bsb.getView() != null) {
                                int id = view.getId();
                                mVar6 = this.cyc.cya;
                                if (id == mVar6.bsb.bsh.getId() && (view.getTag() instanceof MetaData)) {
                                    if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                                        TiebaStatic.log(new as("c10803").s("obj_locate", 6));
                                        return;
                                    }
                                    return;
                                }
                                int id2 = view.getId();
                                mVar7 = this.cyc.cya;
                                if (id2 != mVar7.bsb.getView().getId()) {
                                    int id3 = view.getId();
                                    mVar8 = this.cyc.cya;
                                    if (id3 != mVar8.bsb.bse.getId()) {
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
