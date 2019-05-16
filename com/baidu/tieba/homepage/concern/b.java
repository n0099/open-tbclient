package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.data.l;
/* loaded from: classes4.dex */
public class b {
    public static void a(View view, com.baidu.tieba.card.data.c cVar, boolean z) {
        if (view != null && cVar != null && cVar.abv() != null && !StringUtils.isNull(cVar.abv().getTid())) {
            am amVar = new am("c12352");
            if (z) {
                amVar.P("obj_locate", 1);
            } else {
                amVar.P("obj_locate", 2);
            }
            if (cVar instanceof l) {
                amVar.P("obj_type", 2);
            } else {
                amVar.bT("obj_type", cVar.aXY());
            }
            amVar.bT("tid", cVar.threadData.getTid());
            amVar.l("fid", cVar.threadData.getFid());
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            amVar.P("obj_param1", cVar.aYb() ? 2 : 1);
            TiebaStatic.log(amVar);
        }
    }
}
