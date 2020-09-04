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
/* loaded from: classes16.dex */
public class a {
    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, Rect rect) {
        if (absThreadDataSupport != null && absThreadDataSupport.bce() != null && context != null) {
            bw bce = absThreadDataSupport.bce();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(bce, null, "video_tab", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bce.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
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
            createFromThreadCfg.setVideo_source("video_tab");
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
        if (cVar != null && cVar.bce() != null && aqVar != null) {
            if (cVar.bce().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = cVar.bce().getBaijiahaoData();
                aqVar.ai("obj_param5", 3);
                aqVar.dD("obj_param4", baijiahaoData.oriUgcNid);
                aqVar.dD("obj_param6", baijiahaoData.oriUgcVid);
                return;
            }
            aqVar.ai("obj_param5", 1);
        }
    }
}
