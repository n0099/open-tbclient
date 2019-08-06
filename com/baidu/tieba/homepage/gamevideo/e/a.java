package com.baidu.tieba.homepage.gamevideo.e;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.n;
/* loaded from: classes4.dex */
public class a {
    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z) {
        if (aVar != null && aVar.acy() != null && context != null) {
            bh acy = aVar.acy();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(acy, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(acy.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(acy.aeD());
            createFromThreadCfg.setStartFrom(i);
            if (aVar.acB() != null) {
                createFromThreadCfg.addLocateParam(aVar.acB());
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            n.vx(acy.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void a(c cVar, int i) {
        an W;
        if (cVar != null && cVar.acy() != null && (W = cVar.W("c13496", true)) != null) {
            W.P("obj_type", i);
            TiebaStatic.log(W);
        }
    }

    public static void b(c cVar, int i) {
        an W;
        if (cVar != null && cVar.acy() != null && l.W(cVar.threadData) && (W = cVar.W("c13494", true)) != null) {
            W.P("obj_type", i);
            TiebaStatic.log(W);
        }
    }

    public static void c(c cVar, int i) {
        an W;
        if (cVar != null && l.W(cVar.threadData) && (W = cVar.W("c13495", true)) != null) {
            W.P("obj_type", i);
            TiebaStatic.log(W);
        }
    }

    public static void d(c cVar, int i) {
        an W;
        if (cVar != null && (W = cVar.W("c13488", true)) != null) {
            if (cVar.acy() != null) {
                bh acy = cVar.acy();
                W.P("obj_name", acy.afW() != null && (acy.afW().cpN() != null || acy.afW().ayW() != null) ? 1 : 0);
                if (acy.aey() != null) {
                    W.P("ab_type", acy.aey().hadConcerned() ? 1 : 0);
                }
            }
            W.P("obj_type", i);
            TiebaStatic.log(W);
        }
    }
}
