package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes7.dex */
public class b {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.axQ() != null && !StringUtils.isNull(aVar.axQ().getTid())) {
            an anVar = new an("c12352");
            bj axQ = aVar.axQ();
            if (axQ.isLinkThread()) {
                anVar.Z("obj_type", 4);
            } else if (axQ.isShareThread) {
                anVar.Z("obj_type", 5);
            } else if (axQ.ayL()) {
                anVar.Z("obj_type", 6);
            } else if (axQ.aBT()) {
                anVar.Z("obj_type", 7);
            } else if (axQ.aBS()) {
                anVar.Z("obj_type", 8);
            } else if (axQ.aBU()) {
                anVar.Z("obj_type", 9);
            } else if (axQ.getType() == bj.cNf) {
                anVar.Z("obj_type", 1);
            } else if (axQ.aAX()) {
                anVar.Z("obj_type", 2);
            }
            anVar.Z("obj_locate", i);
            anVar.cp("tid", aVar.axQ().getTid());
            anVar.s("fid", aVar.axQ().getFid());
            anVar.Z("obj_source", 1);
            if (aVar instanceof com.baidu.tieba.card.data.c) {
                anVar.Z("obj_param1", ((com.baidu.tieba.card.data.c) aVar).btP() ? 2 : 1);
            }
            TiebaStatic.log(anVar);
        }
    }
}
