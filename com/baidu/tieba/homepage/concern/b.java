package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class b {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, int i) {
        if (view != null && absThreadDataSupport != null && absThreadDataSupport.aOi() != null && !StringUtils.isNull(absThreadDataSupport.aOi().getTid())) {
            an anVar = new an("c12352");
            bk aOi = absThreadDataSupport.aOi();
            if (aOi.isLinkThread()) {
                anVar.ag("obj_type", 4);
            } else if (aOi.isShareThread) {
                anVar.ag("obj_type", 5);
            } else if (aOi.aPm()) {
                anVar.ag("obj_type", 6);
            } else if (aOi.aSv()) {
                anVar.ag("obj_type", 7);
            } else if (aOi.aPn()) {
                anVar.ag("obj_type", 8);
            } else if (aOi.aSw()) {
                anVar.ag("obj_type", 9);
            } else if (aOi.getType() == bk.dEE) {
                anVar.ag("obj_type", 1);
            } else if (aOi.aPk()) {
                anVar.ag("obj_type", 2);
            }
            anVar.ag("obj_locate", i);
            anVar.dh("tid", absThreadDataSupport.aOi().getTid());
            anVar.s("fid", absThreadDataSupport.aOi().getFid());
            anVar.ag("obj_source", 1);
            if (absThreadDataSupport instanceof com.baidu.tieba.card.data.c) {
                anVar.ag("obj_param1", ((com.baidu.tieba.card.data.c) absThreadDataSupport).bLE() ? 2 : 1);
            }
            if (absThreadDataSupport.aOi().aQx() != null) {
                anVar.dh("uid", absThreadDataSupport.aOi().aQx().getUserId());
            }
            if (aOi.getBaijiahaoData() != null) {
                anVar.dh("obj_id", aOi.getBaijiahaoData().oriUgcNid);
            } else {
                anVar.dh("obj_id", aOi.getTid());
            }
            TiebaStatic.log(anVar);
            d(aOi, i);
        }
    }

    private static void d(bk bkVar, int i) {
        an anVar = null;
        switch (i) {
            case 1:
                anVar = com.baidu.tieba.s.a.a("c13692", bkVar, 3);
                break;
        }
        TiebaStatic.log(anVar);
    }
}
