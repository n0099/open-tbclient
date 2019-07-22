package com.baidu.tieba.homepage.gamevideo.e;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.n;
/* loaded from: classes4.dex */
public class a {
    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z) {
        if (aVar != null && aVar.acx() != null && context != null) {
            bg acx = aVar.acx();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(acx, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(acx.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(acx.aeC());
            createFromThreadCfg.setStartFrom(i);
            if (aVar.acA() != null) {
                createFromThreadCfg.addLocateParam(aVar.acA());
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            n.vw(acx.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void a(c cVar, int i) {
        an W;
        if (cVar != null && cVar.acx() != null && (W = cVar.W("c13496", true)) != null) {
            W.P("obj_type", i);
            TiebaStatic.log(W);
        }
    }

    public static void b(c cVar, int i) {
        an W;
        if (cVar != null && cVar.acx() != null && l.V(cVar.threadData) && (W = cVar.W("c13494", true)) != null) {
            W.P("obj_type", i);
            TiebaStatic.log(W);
        }
    }

    public static void c(c cVar, int i) {
        an W;
        if (cVar != null && l.V(cVar.threadData) && (W = cVar.W("c13495", true)) != null) {
            W.P("obj_type", i);
            TiebaStatic.log(W);
        }
    }

    public static void d(c cVar, int i) {
        an W;
        if (cVar != null && (W = cVar.W("c13488", true)) != null) {
            if (cVar.acx() != null) {
                bg acx = cVar.acx();
                W.P("obj_name", acx.afV() != null && (acx.afV().cpr() != null || acx.afV().ayU() != null) ? 1 : 0);
                if (acx.aex() != null) {
                    W.P("ab_type", acx.aex().hadConcerned() ? 1 : 0);
                }
            }
            W.P("obj_type", i);
            TiebaStatic.log(W);
        }
    }
}
