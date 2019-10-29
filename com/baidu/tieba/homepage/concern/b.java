package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.data.l;
/* loaded from: classes4.dex */
public class b {
    public static void a(View view, com.baidu.tieba.card.data.c cVar, boolean z) {
        if (view != null && cVar != null && cVar.agI() != null && !StringUtils.isNull(cVar.agI().getTid())) {
            an anVar = new an("c12352");
            if (z) {
                anVar.O("obj_locate", 1);
            } else {
                anVar.O("obj_locate", 2);
            }
            if (cVar instanceof l) {
                anVar.O("obj_type", 2);
            } else {
                anVar.bS("obj_type", cVar.baI());
            }
            anVar.bS("tid", cVar.cbq.getTid());
            anVar.p("fid", cVar.cbq.getFid());
            anVar.bS("obj_source", "1");
            anVar.O("obj_param1", cVar.baL() ? 2 : 1);
            TiebaStatic.log(anVar);
        }
    }
}
