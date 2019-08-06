package com.baidu.tieba.homepage.concern;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.data.l;
/* loaded from: classes4.dex */
public class b {
    public static void a(View view, com.baidu.tieba.card.data.c cVar, boolean z) {
        if (view != null && cVar != null && cVar.acy() != null && !StringUtils.isNull(cVar.acy().getTid())) {
            an anVar = new an("c12352");
            if (z) {
                anVar.P("obj_locate", 1);
            } else {
                anVar.P("obj_locate", 2);
            }
            if (cVar instanceof l) {
                anVar.P("obj_type", 2);
            } else {
                anVar.bT("obj_type", cVar.bab());
            }
            anVar.bT("tid", cVar.threadData.getTid());
            anVar.l("fid", cVar.threadData.getFid());
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            anVar.P("obj_param1", cVar.baf() ? 2 : 1);
            TiebaStatic.log(anVar);
        }
    }
}
