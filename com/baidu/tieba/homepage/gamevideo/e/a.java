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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.i;
/* loaded from: classes9.dex */
public class a {
    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, Rect rect) {
        if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && context != null) {
            bk aOi = absThreadDataSupport.aOi();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(aOi, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(aOi.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(aOi.aQC());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (absThreadDataSupport.aOl() != null) {
                createFromThreadCfg.addLocateParam(absThreadDataSupport.aOl());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && u(aOi)) {
                createFromThreadCfg.setNeedPreLoad(true);
                i.an(aOi);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            m.Dn(aOi.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private static boolean u(bk bkVar) {
        if (bkVar == null || bkVar.isShareThread) {
            return false;
        }
        int i = bkVar.threadType;
        if (i == 0 || i == 11 || i == 40) {
            return true;
        }
        return bkVar.aSx();
    }

    public static void a(c cVar, int i) {
        an ay;
        if (cVar != null && cVar.aOi() != null && (ay = cVar.ay("c13496", true)) != null) {
            ay.ag("obj_type", i);
            TiebaStatic.log(ay);
        }
    }

    public static void b(c cVar, int i) {
        an ay;
        if (cVar != null && cVar.aOi() != null && l.ac(cVar.dEA) && (ay = cVar.ay("c13494", true)) != null) {
            ay.ag("obj_type", i);
            TiebaStatic.log(ay);
        }
    }

    public static void c(c cVar, int i) {
        an ay;
        if (cVar != null && l.ac(cVar.dEA) && (ay = cVar.ay("c13495", true)) != null) {
            ay.ag("obj_type", i);
            TiebaStatic.log(ay);
        }
    }

    public static void d(c cVar, int i) {
        an ay;
        if (cVar != null && (ay = cVar.ay("c13488", true)) != null) {
            if (cVar.aOi() != null) {
                bk aOi = cVar.aOi();
                ay.ag("obj_name", aOi.aSb() != null && (aOi.aSb().ddw() != null || aOi.aSb().biy() != null) ? 1 : 0);
                if (aOi.aQx() != null) {
                    ay.ag(TiebaInitialize.Params.AB_TYPE, aOi.aQx().hadConcerned() ? 1 : 0);
                }
            }
            ay.ag("obj_type", i);
            TiebaStatic.log(ay);
        }
    }
}
