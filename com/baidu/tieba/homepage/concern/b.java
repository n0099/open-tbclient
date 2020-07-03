package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes9.dex */
public class b {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, int i) {
        if (view != null && absThreadDataSupport != null && absThreadDataSupport.aPS() != null && !StringUtils.isNull(absThreadDataSupport.aPS().getTid())) {
            ao aoVar = new ao("c12352");
            bu aPS = absThreadDataSupport.aPS();
            if (aPS.isLinkThread()) {
                aoVar.ag("obj_type", 4);
            } else if (aPS.isShareThread) {
                aoVar.ag("obj_type", 5);
            } else if (aPS.aQX()) {
                aoVar.ag("obj_type", 6);
            } else if (aPS.aUl()) {
                aoVar.ag("obj_type", 7);
            } else if (aPS.aQY()) {
                aoVar.ag("obj_type", 8);
            } else if (aPS.aUm()) {
                aoVar.ag("obj_type", 9);
            } else if (aPS.getType() == bu.dLm) {
                aoVar.ag("obj_type", 1);
            } else if (aPS.aQV()) {
                aoVar.ag("obj_type", 2);
            }
            aoVar.ag("obj_locate", i);
            aoVar.dk("tid", absThreadDataSupport.aPS().getTid());
            aoVar.s("fid", absThreadDataSupport.aPS().getFid());
            aoVar.ag("obj_source", 1);
            if (absThreadDataSupport instanceof com.baidu.tieba.card.data.c) {
                aoVar.ag("obj_param1", ((com.baidu.tieba.card.data.c) absThreadDataSupport).bOQ() ? 2 : 1);
            }
            if (absThreadDataSupport.aPS().aSp() != null) {
                aoVar.dk("uid", absThreadDataSupport.aPS().aSp().getUserId());
            }
            if (aPS.getBaijiahaoData() != null) {
                aoVar.dk("obj_id", aPS.getBaijiahaoData().oriUgcNid);
            } else {
                aoVar.dk("obj_id", aPS.getTid());
            }
            TiebaStatic.log(aoVar);
            d(aPS, i);
        }
    }

    private static void d(bu buVar, int i) {
        ao aoVar = null;
        switch (i) {
            case 1:
                aoVar = com.baidu.tieba.s.a.a("c13692", buVar, 3);
                break;
        }
        TiebaStatic.log(aoVar);
    }
}
