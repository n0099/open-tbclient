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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.n;
import com.baidu.tieba.frs.l;
/* loaded from: classes22.dex */
public class a {
    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, Rect rect) {
        if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null && context != null) {
            bw bjZ = absThreadDataSupport.bjZ();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(bjZ, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bjZ.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(bjZ.bmE());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (absThreadDataSupport.bkc() != null) {
                createFromThreadCfg.addLocateParam(absThreadDataSupport.bkc());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(bjZ)) {
                createFromThreadCfg.setNeedPreLoad(true);
                l.al(bjZ);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            n.IZ(bjZ.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private static boolean w(bw bwVar) {
        if (bwVar == null || bwVar.isShareThread) {
            return false;
        }
        int i = bwVar.threadType;
        if (i == 0 || i == 11 || i == 40) {
            return true;
        }
        return bwVar.blk();
    }

    public static void a(c cVar, int i) {
        aq aI;
        if (cVar != null && cVar.bjZ() != null && (aI = cVar.aI("c13496", true)) != null) {
            aI.al("obj_type", i);
            TiebaStatic.log(aI);
        }
    }

    public static void b(c cVar, int i) {
        aq aI;
        if (cVar != null && cVar.bjZ() != null && m.ab(cVar.exA) && (aI = cVar.aI("c13494", true)) != null) {
            aI.al("obj_type", i);
            TiebaStatic.log(aI);
        }
    }

    public static void c(c cVar, int i) {
        aq aI;
        if (cVar != null && m.ab(cVar.exA) && (aI = cVar.aI("c13495", true)) != null) {
            aI.al("obj_type", i);
            TiebaStatic.log(aI);
        }
    }

    public static void d(c cVar, int i) {
        aq aI;
        if (cVar != null && (aI = cVar.aI("c13488", true)) != null) {
            if (cVar.bjZ() != null) {
                bw bjZ = cVar.bjZ();
                aI.al("obj_name", bjZ.bod() != null && (bjZ.bod().dKb() != null || bjZ.bod().bFQ() != null) ? 1 : 0);
                if (bjZ.bmA() != null) {
                    aI.al(TiebaInitialize.Params.AB_TYPE, bjZ.bmA().hadConcerned() ? 1 : 0);
                }
            }
            aI.al("obj_type", i);
            TiebaStatic.log(aI);
        }
    }
}
