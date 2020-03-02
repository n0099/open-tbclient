package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class b {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.aAg() != null && !StringUtils.isNull(aVar.aAg().getTid())) {
            an anVar = new an("c12352");
            bj aAg = aVar.aAg();
            if (aAg.isLinkThread()) {
                anVar.X("obj_type", 4);
            } else if (aAg.isShareThread) {
                anVar.X("obj_type", 5);
            } else if (aAg.aBd()) {
                anVar.X("obj_type", 6);
            } else if (aAg.aEg()) {
                anVar.X("obj_type", 7);
            } else if (aAg.aBe()) {
                anVar.X("obj_type", 8);
            } else if (aAg.aEh()) {
                anVar.X("obj_type", 9);
            } else if (aAg.getType() == bj.cRj) {
                anVar.X("obj_type", 1);
            } else if (aAg.aBb()) {
                anVar.X("obj_type", 2);
            }
            anVar.X("obj_locate", i);
            anVar.cy("tid", aVar.aAg().getTid());
            anVar.s("fid", aVar.aAg().getFid());
            anVar.X("obj_source", 1);
            if (aVar instanceof com.baidu.tieba.card.data.c) {
                anVar.X("obj_param1", ((com.baidu.tieba.card.data.c) aVar).bvv() ? 2 : 1);
            }
            TiebaStatic.log(anVar);
        }
    }
}
