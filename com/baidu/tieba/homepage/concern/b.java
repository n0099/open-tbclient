package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes16.dex */
public class b {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, int i) {
        if (view != null && absThreadDataSupport != null && absThreadDataSupport.bce() != null && !StringUtils.isNull(absThreadDataSupport.bce().getTid())) {
            aq aqVar = new aq("c12352");
            bw bce = absThreadDataSupport.bce();
            if (bce.isLinkThread()) {
                aqVar.ai("obj_type", 4);
            } else if (bce.isShareThread) {
                aqVar.ai("obj_type", 5);
            } else if (bce.bdm()) {
                aqVar.ai("obj_type", 6);
            } else if (bce.bgz()) {
                aqVar.ai("obj_type", 7);
            } else if (bce.bdn()) {
                aqVar.ai("obj_type", 8);
            } else if (bce.bgA()) {
                aqVar.ai("obj_type", 9);
            } else if (bce.getType() == bw.eaW) {
                aqVar.ai("obj_type", 1);
            } else if (bce.bdk()) {
                aqVar.ai("obj_type", 2);
            }
            aqVar.ai("obj_locate", i);
            aqVar.dD("tid", absThreadDataSupport.bce().getTid());
            aqVar.u("fid", absThreadDataSupport.bce().getFid());
            aqVar.ai("obj_source", 1);
            if (absThreadDataSupport instanceof com.baidu.tieba.card.data.c) {
                aqVar.ai("obj_param1", ((com.baidu.tieba.card.data.c) absThreadDataSupport).ccp() ? 2 : 1);
            }
            if (absThreadDataSupport.bce().beE() != null) {
                aqVar.dD("uid", absThreadDataSupport.bce().beE().getUserId());
            }
            if (bce.getBaijiahaoData() != null) {
                aqVar.dD("obj_id", bce.getBaijiahaoData().oriUgcNid);
            } else {
                aqVar.dD("obj_id", bce.getTid());
            }
            TiebaStatic.log(aqVar);
            d(bce, i);
        }
    }

    private static void d(bw bwVar, int i) {
        aq aqVar = null;
        switch (i) {
            case 1:
                aqVar = com.baidu.tieba.s.a.a("c13692", bwVar, 3);
                break;
        }
        TiebaStatic.log(aqVar);
    }
}
