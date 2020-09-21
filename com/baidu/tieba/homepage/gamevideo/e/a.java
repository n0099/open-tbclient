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
/* loaded from: classes21.dex */
public class a {
    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, Rect rect) {
        if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null && context != null) {
            bw bcY = absThreadDataSupport.bcY();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(bcY, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bcY.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(bcY.bfC());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (absThreadDataSupport.bdb() != null) {
                createFromThreadCfg.addLocateParam(absThreadDataSupport.bdb());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(bcY)) {
                createFromThreadCfg.setNeedPreLoad(true);
                l.al(bcY);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            m.Hw(bcY.getTid());
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
        return bwVar.bei();
    }

    public static void a(c cVar, int i) {
        aq aC;
        if (cVar != null && cVar.bcY() != null && (aC = cVar.aC("c13496", true)) != null) {
            aC.ai("obj_type", i);
            TiebaStatic.log(aC);
        }
    }

    public static void b(c cVar, int i) {
        aq aC;
        if (cVar != null && cVar.bcY() != null && com.baidu.tieba.card.data.m.ab(cVar.dXg) && (aC = cVar.aC("c13494", true)) != null) {
            aC.ai("obj_type", i);
            TiebaStatic.log(aC);
        }
    }

    public static void c(c cVar, int i) {
        aq aC;
        if (cVar != null && com.baidu.tieba.card.data.m.ab(cVar.dXg) && (aC = cVar.aC("c13495", true)) != null) {
            aC.ai("obj_type", i);
            TiebaStatic.log(aC);
        }
    }

    public static void d(c cVar, int i) {
        aq aC;
        if (cVar != null && (aC = cVar.aC("c13488", true)) != null) {
            if (cVar.bcY() != null) {
                bw bcY = cVar.bcY();
                aC.ai("obj_name", bcY.bhb() != null && (bcY.bhb().dAF() != null || bcY.bhb().byO() != null) ? 1 : 0);
                if (bcY.bfy() != null) {
                    aC.ai(TiebaInitialize.Params.AB_TYPE, bcY.bfy().hadConcerned() ? 1 : 0);
                }
            }
            aC.ai("obj_type", i);
            TiebaStatic.log(aC);
        }
    }
}
