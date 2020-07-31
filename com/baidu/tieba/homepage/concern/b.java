package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes16.dex */
public class b {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, int i) {
        if (view != null && absThreadDataSupport != null && absThreadDataSupport.aTN() != null && !StringUtils.isNull(absThreadDataSupport.aTN().getTid())) {
            ap apVar = new ap("c12352");
            bv aTN = absThreadDataSupport.aTN();
            if (aTN.isLinkThread()) {
                apVar.ah("obj_type", 4);
            } else if (aTN.isShareThread) {
                apVar.ah("obj_type", 5);
            } else if (aTN.aUT()) {
                apVar.ah("obj_type", 6);
            } else if (aTN.aYg()) {
                apVar.ah("obj_type", 7);
            } else if (aTN.aUU()) {
                apVar.ah("obj_type", 8);
            } else if (aTN.aYh()) {
                apVar.ah("obj_type", 9);
            } else if (aTN.getType() == bv.dRx) {
                apVar.ah("obj_type", 1);
            } else if (aTN.aUR()) {
                apVar.ah("obj_type", 2);
            }
            apVar.ah("obj_locate", i);
            apVar.dn("tid", absThreadDataSupport.aTN().getTid());
            apVar.t("fid", absThreadDataSupport.aTN().getFid());
            apVar.ah("obj_source", 1);
            if (absThreadDataSupport instanceof com.baidu.tieba.card.data.c) {
                apVar.ah("obj_param1", ((com.baidu.tieba.card.data.c) absThreadDataSupport).bSc() ? 2 : 1);
            }
            if (absThreadDataSupport.aTN().aWl() != null) {
                apVar.dn("uid", absThreadDataSupport.aTN().aWl().getUserId());
            }
            if (aTN.getBaijiahaoData() != null) {
                apVar.dn("obj_id", aTN.getBaijiahaoData().oriUgcNid);
            } else {
                apVar.dn("obj_id", aTN.getTid());
            }
            TiebaStatic.log(apVar);
            d(aTN, i);
        }
    }

    private static void d(bv bvVar, int i) {
        ap apVar = null;
        switch (i) {
            case 1:
                apVar = com.baidu.tieba.s.a.a("c13692", bvVar, 3);
                break;
        }
        TiebaStatic.log(apVar);
    }
}
