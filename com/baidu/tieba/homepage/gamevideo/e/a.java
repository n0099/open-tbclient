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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.k;
/* loaded from: classes16.dex */
public class a {
    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, Rect rect) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null && context != null) {
            bv aTN = absThreadDataSupport.aTN();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(aTN, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(aTN.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(aTN.aWp());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (absThreadDataSupport.aTQ() != null) {
                createFromThreadCfg.addLocateParam(absThreadDataSupport.aTQ());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && v(aTN)) {
                createFromThreadCfg.setNeedPreLoad(true);
                k.ak(aTN);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            m.Ez(aTN.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private static boolean v(bv bvVar) {
        if (bvVar == null || bvVar.isShareThread) {
            return false;
        }
        int i = bvVar.threadType;
        if (i == 0 || i == 11 || i == 40) {
            return true;
        }
        return bvVar.aUV();
    }

    public static void a(c cVar, int i) {
        ap ay;
        if (cVar != null && cVar.aTN() != null && (ay = cVar.ay("c13496", true)) != null) {
            ay.ah("obj_type", i);
            TiebaStatic.log(ay);
        }
    }

    public static void b(c cVar, int i) {
        ap ay;
        if (cVar != null && cVar.aTN() != null && l.aa(cVar.dLK) && (ay = cVar.ay("c13494", true)) != null) {
            ay.ah("obj_type", i);
            TiebaStatic.log(ay);
        }
    }

    public static void c(c cVar, int i) {
        ap ay;
        if (cVar != null && l.aa(cVar.dLK) && (ay = cVar.ay("c13495", true)) != null) {
            ay.ah("obj_type", i);
            TiebaStatic.log(ay);
        }
    }

    public static void d(c cVar, int i) {
        ap ay;
        if (cVar != null && (ay = cVar.ay("c13488", true)) != null) {
            if (cVar.aTN() != null) {
                bv aTN = cVar.aTN();
                ay.ah("obj_name", aTN.aXO() != null && (aTN.aXO().dlk() != null || aTN.aXO().boR() != null) ? 1 : 0);
                if (aTN.aWl() != null) {
                    ay.ah(TiebaInitialize.Params.AB_TYPE, aTN.aWl().hadConcerned() ? 1 : 0);
                }
            }
            ay.ah("obj_type", i);
            TiebaStatic.log(ay);
        }
    }
}
