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
import com.baidu.tieba.card.n;
import com.baidu.tieba.frs.l;
/* loaded from: classes22.dex */
public class a {
    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, Rect rect) {
        if (absThreadDataSupport != null && absThreadDataSupport.bhz() != null && context != null) {
            bw bhz = absThreadDataSupport.bhz();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(bhz, null, "video_tab", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bhz.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
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
            createFromThreadCfg.setVideo_source("video_tab");
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

    public static void n(c cVar) {
        aq aI;
        if (cVar != null && (aI = cVar.aI("c13583", true)) != null) {
            a(cVar, aI);
            TiebaStatic.log(aI);
        }
    }

    public static void o(c cVar) {
        aq aI;
        if (cVar != null && (aI = cVar.aI("c13584", true)) != null) {
            a(cVar, aI);
            aI.aj("obj_floor", cVar.position + 1);
            TiebaStatic.log(aI);
        }
    }

    public static void p(c cVar) {
        aq aI;
        if (cVar != null && (aI = cVar.aI("c13585", true)) != null) {
            a(cVar, aI);
            TiebaStatic.log(aI);
        }
    }

    public static void q(c cVar) {
        aq aI;
        if (cVar != null && (aI = cVar.aI("c13586", true)) != null) {
            a(cVar, aI);
            TiebaStatic.log(aI);
        }
    }

    public static void r(c cVar) {
        aq aI;
        if (cVar != null && (aI = cVar.aI("c13587", true)) != null) {
            a(cVar, aI);
            TiebaStatic.log(aI);
        }
    }

    private static void a(c cVar, aq aqVar) {
        if (cVar != null && cVar.bhz() != null && aqVar != null) {
            if (cVar.bhz().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = cVar.bhz().getBaijiahaoData();
                aqVar.aj("obj_param5", 3);
                aqVar.dR("obj_param4", baijiahaoData.oriUgcNid);
                aqVar.dR("obj_param6", baijiahaoData.oriUgcVid);
                return;
            }
            aqVar.aj("obj_param5", 1);
        }
    }
}
