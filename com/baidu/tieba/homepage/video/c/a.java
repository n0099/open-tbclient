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
/* loaded from: classes21.dex */
public class a {
    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, Rect rect) {
        if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null && context != null) {
            bw bcY = absThreadDataSupport.bcY();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(bcY, null, "video_tab", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bcY.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
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
            createFromThreadCfg.setVideo_source("video_tab");
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

    public static void n(c cVar) {
        aq aC;
        if (cVar != null && (aC = cVar.aC("c13583", true)) != null) {
            a(cVar, aC);
            TiebaStatic.log(aC);
        }
    }

    public static void o(c cVar) {
        aq aC;
        if (cVar != null && (aC = cVar.aC("c13584", true)) != null) {
            a(cVar, aC);
            aC.ai("obj_floor", cVar.position + 1);
            TiebaStatic.log(aC);
        }
    }

    public static void p(c cVar) {
        aq aC;
        if (cVar != null && (aC = cVar.aC("c13585", true)) != null) {
            a(cVar, aC);
            TiebaStatic.log(aC);
        }
    }

    public static void q(c cVar) {
        aq aC;
        if (cVar != null && (aC = cVar.aC("c13586", true)) != null) {
            a(cVar, aC);
            TiebaStatic.log(aC);
        }
    }

    public static void r(c cVar) {
        aq aC;
        if (cVar != null && (aC = cVar.aC("c13587", true)) != null) {
            a(cVar, aC);
            TiebaStatic.log(aC);
        }
    }

    private static void a(c cVar, aq aqVar) {
        if (cVar != null && cVar.bcY() != null && aqVar != null) {
            if (cVar.bcY().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = cVar.bcY().getBaijiahaoData();
                aqVar.ai("obj_param5", 3);
                aqVar.dF("obj_param4", baijiahaoData.oriUgcNid);
                aqVar.dF("obj_param6", baijiahaoData.oriUgcVid);
                return;
            }
            aqVar.ai("obj_param5", 1);
        }
    }
}
