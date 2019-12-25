package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes6.dex */
public class b {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.axx() != null && !StringUtils.isNull(aVar.axx().getTid())) {
            an anVar = new an("c12352");
            bj axx = aVar.axx();
            if (axx.isLinkThread()) {
                anVar.Z("obj_type", 4);
            } else if (axx.isShareThread) {
                anVar.Z("obj_type", 5);
            } else if (axx.ays()) {
                anVar.Z("obj_type", 6);
            } else if (axx.aBA()) {
                anVar.Z("obj_type", 7);
            } else if (axx.aBz()) {
                anVar.Z("obj_type", 8);
            } else if (axx.aBB()) {
                anVar.Z("obj_type", 9);
            } else if (axx.getType() == bj.cMV) {
                anVar.Z("obj_type", 1);
            } else if (axx.aAE()) {
                anVar.Z("obj_type", 2);
            }
            anVar.Z("obj_locate", i);
            anVar.cp("tid", aVar.axx().getTid());
            anVar.s("fid", aVar.axx().getFid());
            anVar.Z("obj_source", 1);
            if (aVar instanceof com.baidu.tieba.card.data.c) {
                anVar.Z("obj_param1", ((com.baidu.tieba.card.data.c) aVar).bsN() ? 2 : 1);
            }
            TiebaStatic.log(anVar);
        }
    }
}
