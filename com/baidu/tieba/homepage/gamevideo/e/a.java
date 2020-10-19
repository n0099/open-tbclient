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
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.l;
/* loaded from: classes22.dex */
public class a {
    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, Rect rect) {
        if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null && context != null) {
            bw bfG = absThreadDataSupport.bfG();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(bfG, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bfG.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(bfG.bil());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (absThreadDataSupport.bfJ() != null) {
                createFromThreadCfg.addLocateParam(absThreadDataSupport.bfJ());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(bfG)) {
                createFromThreadCfg.setNeedPreLoad(true);
                l.al(bfG);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            m.Ij(bfG.getTid());
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
        return bwVar.bgR();
    }

    public static void a(c cVar, int i) {
        aq aG;
        if (cVar != null && cVar.bfG() != null && (aG = cVar.aG("c13496", true)) != null) {
            aG.aj("obj_type", i);
            TiebaStatic.log(aG);
        }
    }

    public static void b(c cVar, int i) {
        aq aG;
        if (cVar != null && cVar.bfG() != null && com.baidu.tieba.card.data.m.ab(cVar.eji) && (aG = cVar.aG("c13494", true)) != null) {
            aG.aj("obj_type", i);
            TiebaStatic.log(aG);
        }
    }

    public static void c(c cVar, int i) {
        aq aG;
        if (cVar != null && com.baidu.tieba.card.data.m.ab(cVar.eji) && (aG = cVar.aG("c13495", true)) != null) {
            aG.aj("obj_type", i);
            TiebaStatic.log(aG);
        }
    }

    public static void d(c cVar, int i) {
        aq aG;
        if (cVar != null && (aG = cVar.aG("c13488", true)) != null) {
            if (cVar.bfG() != null) {
                bw bfG = cVar.bfG();
                aG.aj("obj_name", bfG.bjK() != null && (bfG.bjK().dEr() != null || bfG.bjK().bBy() != null) ? 1 : 0);
                if (bfG.bih() != null) {
                    aG.aj(TiebaInitialize.Params.AB_TYPE, bfG.bih().hadConcerned() ? 1 : 0);
                }
            }
            aG.aj("obj_type", i);
            TiebaStatic.log(aG);
        }
    }
}
