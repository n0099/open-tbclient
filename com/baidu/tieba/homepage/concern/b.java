package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class b {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, int i) {
        if (view != null && aVar != null && aVar.aAe() != null && !StringUtils.isNull(aVar.aAe().getTid())) {
            an anVar = new an("c12352");
            bj aAe = aVar.aAe();
            if (aAe.isLinkThread()) {
                anVar.X("obj_type", 4);
            } else if (aAe.isShareThread) {
                anVar.X("obj_type", 5);
            } else if (aAe.aBb()) {
                anVar.X("obj_type", 6);
            } else if (aAe.aEe()) {
                anVar.X("obj_type", 7);
            } else if (aAe.aBc()) {
                anVar.X("obj_type", 8);
            } else if (aAe.aEf()) {
                anVar.X("obj_type", 9);
            } else if (aAe.getType() == bj.cRi) {
                anVar.X("obj_type", 1);
            } else if (aAe.aAZ()) {
                anVar.X("obj_type", 2);
            }
            anVar.X("obj_locate", i);
            anVar.cy("tid", aVar.aAe().getTid());
            anVar.s("fid", aVar.aAe().getFid());
            anVar.X("obj_source", 1);
            if (aVar instanceof com.baidu.tieba.card.data.c) {
                anVar.X("obj_param1", ((com.baidu.tieba.card.data.c) aVar).bvt() ? 2 : 1);
            }
            TiebaStatic.log(anVar);
        }
    }
}
