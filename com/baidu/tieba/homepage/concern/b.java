package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class b {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.aIw() != null && !StringUtils.isNull(aVar.aIw().getTid())) {
            an anVar = new an("c12352");
            bj aIw = aVar.aIw();
            if (aIw.isLinkThread()) {
                anVar.af("obj_type", 4);
            } else if (aIw.isShareThread) {
                anVar.af("obj_type", 5);
            } else if (aIw.aJt()) {
                anVar.af("obj_type", 6);
            } else if (aIw.aMy()) {
                anVar.af("obj_type", 7);
            } else if (aIw.aJu()) {
                anVar.af("obj_type", 8);
            } else if (aIw.aMz()) {
                anVar.af("obj_type", 9);
            } else if (aIw.getType() == bj.dqE) {
                anVar.af("obj_type", 1);
            } else if (aIw.aJr()) {
                anVar.af("obj_type", 2);
            }
            anVar.af("obj_locate", i);
            anVar.cI("tid", aVar.aIw().getTid());
            anVar.t("fid", aVar.aIw().getFid());
            anVar.af("obj_source", 1);
            if (aVar instanceof com.baidu.tieba.card.data.c) {
                anVar.af("obj_param1", ((com.baidu.tieba.card.data.c) aVar).bFm() ? 2 : 1);
            }
            if (aVar.aIw().aKE() != null) {
                anVar.cI("uid", aVar.aIw().aKE().getUserId());
            }
            if (aIw.getBaijiahaoData() != null) {
                anVar.cI("obj_id", aIw.getBaijiahaoData().oriUgcNid);
            } else {
                anVar.cI("obj_id", aIw.getTid());
            }
            TiebaStatic.log(anVar);
        }
    }
}
