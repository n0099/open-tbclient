package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends cf<com.baidu.tieba.card.data.j> {
    final /* synthetic */ q cyg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cyg = qVar;
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
            mVar = this.cyg.cye;
            if (mVar != null) {
                mVar2 = this.cyg.cye;
                if (mVar2.blq != null) {
                    mVar3 = this.cyg.cye;
                    if (mVar3.blq.blw != null) {
                        mVar4 = this.cyg.cye;
                        if (mVar4.blq.blt != null) {
                            mVar5 = this.cyg.cye;
                            if (mVar5.blq.getView() != null) {
                                int id = view.getId();
                                mVar6 = this.cyg.cye;
                                if (id == mVar6.blq.blw.getId() && (view.getTag() instanceof MetaData)) {
                                    if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                                        TiebaStatic.log(new ar("c10803").s("obj_locate", 6));
                                        return;
                                    }
                                    return;
                                }
                                int id2 = view.getId();
                                mVar7 = this.cyg.cye;
                                if (id2 != mVar7.blq.getView().getId()) {
                                    int id3 = view.getId();
                                    mVar8 = this.cyg.cye;
                                    if (id3 != mVar8.blq.blt.getId()) {
                                        return;
                                    }
                                }
                                if (view.getTag(r.h.rec_god_item_root) instanceof String) {
                                    TiebaStatic.log(new ar("c11005").ab("obj_id", (String) view.getTag(r.h.rec_god_item_root)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
