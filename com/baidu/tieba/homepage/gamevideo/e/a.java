package com.baidu.tieba.homepage.gamevideo.e;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
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
        if (aVar != null && aVar.agG() != null && context != null) {
            bh agG = aVar.agG();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(agG, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(agG.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(agG.aiJ());
            createFromThreadCfg.setStartFrom(i);
            if (aVar.agJ() != null) {
                createFromThreadCfg.addLocateParam(aVar.agJ());
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            n.uz(agG.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public static void a(c cVar, int i) {
        an ab;
        if (cVar != null && cVar.agG() != null && (ab = cVar.ab("c13496", true)) != null) {
            ab.O("obj_type", i);
            TiebaStatic.log(ab);
        }
    }

    public static void b(c cVar, int i) {
        an ab;
        if (cVar != null && cVar.agG() != null && l.V(cVar.caz) && (ab = cVar.ab("c13494", true)) != null) {
            ab.O("obj_type", i);
            TiebaStatic.log(ab);
        }
    }

    public static void c(c cVar, int i) {
        an ab;
        if (cVar != null && l.V(cVar.caz) && (ab = cVar.ab("c13495", true)) != null) {
            ab.O("obj_type", i);
            TiebaStatic.log(ab);
        }
    }

    public static void d(c cVar, int i) {
        an ab;
        if (cVar != null && (ab = cVar.ab("c13488", true)) != null) {
            if (cVar.agG() != null) {
                bh agG = cVar.agG();
                ab.O("obj_name", agG.akb() != null && (agG.akb().cop() != null || agG.akb().azp() != null) ? 1 : 0);
                if (agG.aiE() != null) {
                    ab.O(TiebaInitialize.Params.AB_TYPE, agG.aiE().hadConcerned() ? 1 : 0);
                }
            }
            ab.O("obj_type", i);
            TiebaStatic.log(ab);
        }
    }
}
