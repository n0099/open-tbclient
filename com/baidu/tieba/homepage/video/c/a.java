package com.baidu.tieba.homepage.video.c;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.BaijiahaoData;
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
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(bfG, null, "video_tab", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bfG.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
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
            createFromThreadCfg.setVideo_source("video_tab");
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

    public static void n(c cVar) {
        aq aG;
        if (cVar != null && (aG = cVar.aG("c13583", true)) != null) {
            a(cVar, aG);
            TiebaStatic.log(aG);
        }
    }

    public static void o(c cVar) {
        aq aG;
        if (cVar != null && (aG = cVar.aG("c13584", true)) != null) {
            a(cVar, aG);
            aG.aj("obj_floor", cVar.position + 1);
            TiebaStatic.log(aG);
        }
    }

    public static void p(c cVar) {
        aq aG;
        if (cVar != null && (aG = cVar.aG("c13585", true)) != null) {
            a(cVar, aG);
            TiebaStatic.log(aG);
        }
    }

    public static void q(c cVar) {
        aq aG;
        if (cVar != null && (aG = cVar.aG("c13586", true)) != null) {
            a(cVar, aG);
            TiebaStatic.log(aG);
        }
    }

    public static void r(c cVar) {
        aq aG;
        if (cVar != null && (aG = cVar.aG("c13587", true)) != null) {
            a(cVar, aG);
            TiebaStatic.log(aG);
        }
    }

    private static void a(c cVar, aq aqVar) {
        if (cVar != null && cVar.bfG() != null && aqVar != null) {
            if (cVar.bfG().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = cVar.bfG().getBaijiahaoData();
                aqVar.aj("obj_param5", 3);
                aqVar.dK("obj_param4", baijiahaoData.oriUgcNid);
                aqVar.dK("obj_param6", baijiahaoData.oriUgcVid);
                return;
            }
            aqVar.aj("obj_param5", 1);
        }
    }
}
