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
/* loaded from: classes16.dex */
public class a {
    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, Rect rect) {
        if (absThreadDataSupport != null && absThreadDataSupport.bce() != null && context != null) {
            bw bce = absThreadDataSupport.bce();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(bce, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bce.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(bce.beI());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (absThreadDataSupport.bch() != null) {
                createFromThreadCfg.addLocateParam(absThreadDataSupport.bch());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && v(bce)) {
                createFromThreadCfg.setNeedPreLoad(true);
                l.ak(bce);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            m.GZ(bce.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private static boolean v(bw bwVar) {
        if (bwVar == null || bwVar.isShareThread) {
            return false;
        }
        int i = bwVar.threadType;
        if (i == 0 || i == 11 || i == 40) {
            return true;
        }
        return bwVar.bdo();
    }

    public static void a(c cVar, int i) {
        aq aC;
        if (cVar != null && cVar.bce() != null && (aC = cVar.aC("c13496", true)) != null) {
            aC.ai("obj_type", i);
            TiebaStatic.log(aC);
        }
    }

    public static void b(c cVar, int i) {
        aq aC;
        if (cVar != null && cVar.bce() != null && com.baidu.tieba.card.data.m.aa(cVar.dUW) && (aC = cVar.aC("c13494", true)) != null) {
            aC.ai("obj_type", i);
            TiebaStatic.log(aC);
        }
    }

    public static void c(c cVar, int i) {
        aq aC;
        if (cVar != null && com.baidu.tieba.card.data.m.aa(cVar.dUW) && (aC = cVar.aC("c13495", true)) != null) {
            aC.ai("obj_type", i);
            TiebaStatic.log(aC);
        }
    }

    public static void d(c cVar, int i) {
        aq aC;
        if (cVar != null && (aC = cVar.aC("c13488", true)) != null) {
            if (cVar.bce() != null) {
                bw bce = cVar.bce();
                aC.ai("obj_name", bce.bgh() != null && (bce.bgh().dwM() != null || bce.bgh().bxF() != null) ? 1 : 0);
                if (bce.beE() != null) {
                    aC.ai(TiebaInitialize.Params.AB_TYPE, bce.beE().hadConcerned() ? 1 : 0);
                }
            }
            aC.ai("obj_type", i);
            TiebaStatic.log(aC);
        }
    }
}
