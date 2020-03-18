package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class b {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.aAj() != null && !StringUtils.isNull(aVar.aAj().getTid())) {
            an anVar = new an("c12352");
            bj aAj = aVar.aAj();
            if (aAj.isLinkThread()) {
                anVar.X("obj_type", 4);
            } else if (aAj.isShareThread) {
                anVar.X("obj_type", 5);
            } else if (aAj.aBg()) {
                anVar.X("obj_type", 6);
            } else if (aAj.aEk()) {
                anVar.X("obj_type", 7);
            } else if (aAj.aBh()) {
                anVar.X("obj_type", 8);
            } else if (aAj.aEl()) {
                anVar.X("obj_type", 9);
            } else if (aAj.getType() == bj.cRx) {
                anVar.X("obj_type", 1);
            } else if (aAj.aBe()) {
                anVar.X("obj_type", 2);
            }
            anVar.X("obj_locate", i);
            anVar.cx("tid", aVar.aAj().getTid());
            anVar.s("fid", aVar.aAj().getFid());
            anVar.X("obj_source", 1);
            if (aVar instanceof com.baidu.tieba.card.data.c) {
                anVar.X("obj_param1", ((com.baidu.tieba.card.data.c) aVar).bvB() ? 2 : 1);
            }
            TiebaStatic.log(anVar);
        }
    }
}
