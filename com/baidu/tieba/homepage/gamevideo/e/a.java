package com.baidu.tieba.homepage.gamevideo.e;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.b;
import com.baidu.tieba.card.n;
import com.baidu.tieba.frs.l;
/* loaded from: classes21.dex */
public class a {
    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z, Rect rect) {
        if (aVar != null && aVar.bjd() != null && context != null) {
            bx bjd = aVar.bjd();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(bjd, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bjd.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(bjd.blG());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (aVar.bjg() != null) {
                createFromThreadCfg.addLocateParam(aVar.bjg());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(bjd)) {
                createFromThreadCfg.setNeedPreLoad(true);
                l.an(bjd);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            n.IA(bjd.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private static boolean w(bx bxVar) {
        if (bxVar == null || bxVar.isShareThread) {
            return false;
        }
        int i = bxVar.threadType;
        if (i == 0 || i == 11 || i == 40) {
            return true;
        }
        return bxVar.bkm();
    }

    public static void a(b bVar, int i) {
        ar aI;
        if (bVar != null && bVar.bjd() != null && (aI = bVar.aI("c13496", true)) != null) {
            aI.ak("obj_type", i);
            TiebaStatic.log(aI);
        }
    }

    public static void b(b bVar, int i) {
        ar aI;
        if (bVar != null && bVar.bjd() != null && com.baidu.tieba.card.data.l.ad(bVar.evQ) && (aI = bVar.aI("c13494", true)) != null) {
            aI.ak("obj_type", i);
            TiebaStatic.log(aI);
        }
    }

    public static void c(b bVar, int i) {
        ar aI;
        if (bVar != null && com.baidu.tieba.card.data.l.ad(bVar.evQ) && (aI = bVar.aI("c13495", true)) != null) {
            aI.ak("obj_type", i);
            TiebaStatic.log(aI);
        }
    }

    public static void d(b bVar, int i) {
        ar aI;
        if (bVar != null && (aI = bVar.aI("c13488", true)) != null) {
            if (bVar.bjd() != null) {
                bx bjd = bVar.bjd();
                aI.ak("obj_name", bjd.bnh() != null && (bjd.bnh().dJS() != null || bjd.bnh().bFj() != null) ? 1 : 0);
                if (bjd.blC() != null) {
                    aI.ak(TiebaInitialize.Params.AB_TYPE, bjd.blC().hadConcerned() ? 1 : 0);
                }
            }
            aI.ak("obj_type", i);
            TiebaStatic.log(aI);
        }
    }
}
