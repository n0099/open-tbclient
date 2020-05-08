package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class b {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.aIu() != null && !StringUtils.isNull(aVar.aIu().getTid())) {
            an anVar = new an("c12352");
            bj aIu = aVar.aIu();
            if (aIu.isLinkThread()) {
                anVar.af("obj_type", 4);
            } else if (aIu.isShareThread) {
                anVar.af("obj_type", 5);
            } else if (aIu.aJr()) {
                anVar.af("obj_type", 6);
            } else if (aIu.aMw()) {
                anVar.af("obj_type", 7);
            } else if (aIu.aJs()) {
                anVar.af("obj_type", 8);
            } else if (aIu.aMx()) {
                anVar.af("obj_type", 9);
            } else if (aIu.getType() == bj.dqI) {
                anVar.af("obj_type", 1);
            } else if (aIu.aJp()) {
                anVar.af("obj_type", 2);
            }
            anVar.af("obj_locate", i);
            anVar.cI("tid", aVar.aIu().getTid());
            anVar.t("fid", aVar.aIu().getFid());
            anVar.af("obj_source", 1);
            if (aVar instanceof com.baidu.tieba.card.data.c) {
                anVar.af("obj_param1", ((com.baidu.tieba.card.data.c) aVar).bFk() ? 2 : 1);
            }
            if (aVar.aIu().aKC() != null) {
                anVar.cI("uid", aVar.aIu().aKC().getUserId());
            }
            if (aIu.getBaijiahaoData() != null) {
                anVar.cI("obj_id", aIu.getBaijiahaoData().oriUgcNid);
            } else {
                anVar.cI("obj_id", aIu.getTid());
            }
            TiebaStatic.log(anVar);
        }
    }
}
