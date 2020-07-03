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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.k;
/* loaded from: classes9.dex */
public class a {
    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, Rect rect) {
        if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null && context != null) {
            bu aPS = absThreadDataSupport.aPS();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(aPS, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(aPS.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(aPS.aSt());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (absThreadDataSupport.aPV() != null) {
                createFromThreadCfg.addLocateParam(absThreadDataSupport.aPV());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && u(aPS)) {
                createFromThreadCfg.setNeedPreLoad(true);
                k.an(aPS);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            m.DO(aPS.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private static boolean u(bu buVar) {
        if (buVar == null || buVar.isShareThread) {
            return false;
        }
        int i = buVar.threadType;
        if (i == 0 || i == 11 || i == 40) {
            return true;
        }
        return buVar.aQZ();
    }

    public static void a(c cVar, int i) {
        ao aA;
        if (cVar != null && cVar.aPS() != null && (aA = cVar.aA("c13496", true)) != null) {
            aA.ag("obj_type", i);
            TiebaStatic.log(aA);
        }
    }

    public static void b(c cVar, int i) {
        ao aA;
        if (cVar != null && cVar.aPS() != null && l.ad(cVar.dLi) && (aA = cVar.aA("c13494", true)) != null) {
            aA.ag("obj_type", i);
            TiebaStatic.log(aA);
        }
    }

    public static void c(c cVar, int i) {
        ao aA;
        if (cVar != null && l.ad(cVar.dLi) && (aA = cVar.aA("c13495", true)) != null) {
            aA.ag("obj_type", i);
            TiebaStatic.log(aA);
        }
    }

    public static void d(c cVar, int i) {
        ao aA;
        if (cVar != null && (aA = cVar.aA("c13488", true)) != null) {
            if (cVar.aPS() != null) {
                bu aPS = cVar.aPS();
                aA.ag("obj_name", aPS.aTS() != null && (aPS.aTS().dia() != null || aPS.aTS().bkW() != null) ? 1 : 0);
                if (aPS.aSp() != null) {
                    aA.ag(TiebaInitialize.Params.AB_TYPE, aPS.aSp().hadConcerned() ? 1 : 0);
                }
            }
            aA.ag("obj_type", i);
            TiebaStatic.log(aA);
        }
    }
}
