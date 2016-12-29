package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends cb<com.baidu.tieba.card.data.j> {
    final /* synthetic */ o crc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.crc = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cb
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
            mVar = this.crc.cra;
            if (mVar != null) {
                mVar2 = this.crc.cra;
                if (mVar2.bbD != null) {
                    mVar3 = this.crc.cra;
                    if (mVar3.bbD.bbJ != null) {
                        mVar4 = this.crc.cra;
                        if (mVar4.bbD.bbG != null) {
                            mVar5 = this.crc.cra;
                            if (mVar5.bbD.getView() != null) {
                                int id = view.getId();
                                mVar6 = this.crc.cra;
                                if (id == mVar6.bbD.bbJ.getId() && (view.getTag() instanceof MetaData)) {
                                    if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                                        TiebaStatic.log(new at("c10803").s("obj_locate", 6));
                                        return;
                                    }
                                    return;
                                }
                                int id2 = view.getId();
                                mVar7 = this.crc.cra;
                                if (id2 != mVar7.bbD.getView().getId()) {
                                    int id3 = view.getId();
                                    mVar8 = this.crc.cra;
                                    if (id3 != mVar8.bbD.bbG.getId()) {
                                        return;
                                    }
                                }
                                if (view.getTag(r.g.rec_god_item_root) instanceof String) {
                                    TiebaStatic.log(new at("c11005").ab("obj_id", (String) view.getTag(r.g.rec_god_item_root)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
