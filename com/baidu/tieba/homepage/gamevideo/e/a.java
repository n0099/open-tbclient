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
        if (absThreadDataSupport != null && absThreadDataSupport.bhz() != null && context != null) {
            bw bhz = absThreadDataSupport.bhz();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(bhz, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bhz.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(bhz.bke());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (absThreadDataSupport.bhC() != null) {
                createFromThreadCfg.addLocateParam(absThreadDataSupport.bhC());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(bhz)) {
                createFromThreadCfg.setNeedPreLoad(true);
                l.al(bhz);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            n.II(bhz.getTid());
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
        return bwVar.biK();
    }

    public static void a(c cVar, int i) {
        aq aI;
        if (cVar != null && cVar.bhz() != null && (aI = cVar.aI("c13496", true)) != null) {
            aI.aj("obj_type", i);
            TiebaStatic.log(aI);
        }
    }

    public static void b(c cVar, int i) {
        aq aI;
        if (cVar != null && cVar.bhz() != null && m.ab(cVar.erH) && (aI = cVar.aI("c13494", true)) != null) {
            aI.aj("obj_type", i);
            TiebaStatic.log(aI);
        }
    }

    public static void c(c cVar, int i) {
        aq aI;
        if (cVar != null && m.ab(cVar.erH) && (aI = cVar.aI("c13495", true)) != null) {
            aI.aj("obj_type", i);
            TiebaStatic.log(aI);
        }
    }

    public static void d(c cVar, int i) {
        aq aI;
        if (cVar != null && (aI = cVar.aI("c13488", true)) != null) {
            if (cVar.bhz() != null) {
                bw bhz = cVar.bhz();
                aI.aj("obj_name", bhz.blD() != null && (bhz.blD().dHz() != null || bhz.blD().bDr() != null) ? 1 : 0);
                if (bhz.bka() != null) {
                    aI.aj(TiebaInitialize.Params.AB_TYPE, bhz.bka().hadConcerned() ? 1 : 0);
                }
            }
            aI.aj("obj_type", i);
            TiebaStatic.log(aI);
        }
    }
}
