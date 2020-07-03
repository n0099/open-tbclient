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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.k;
/* loaded from: classes9.dex */
public class a {
    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, Rect rect) {
        if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null && context != null) {
            bu aPS = absThreadDataSupport.aPS();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(aPS, null, "video_tab", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(aPS.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
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
            createFromThreadCfg.setVideo_source("video_tab");
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

    public static void n(c cVar) {
        ao aA;
        if (cVar != null && (aA = cVar.aA("c13583", true)) != null) {
            a(cVar, aA);
            TiebaStatic.log(aA);
        }
    }

    public static void o(c cVar) {
        ao aA;
        if (cVar != null && (aA = cVar.aA("c13584", true)) != null) {
            a(cVar, aA);
            aA.ag("obj_floor", cVar.position + 1);
            TiebaStatic.log(aA);
        }
    }

    public static void p(c cVar) {
        ao aA;
        if (cVar != null && (aA = cVar.aA("c13585", true)) != null) {
            a(cVar, aA);
            TiebaStatic.log(aA);
        }
    }

    public static void q(c cVar) {
        ao aA;
        if (cVar != null && (aA = cVar.aA("c13586", true)) != null) {
            a(cVar, aA);
            TiebaStatic.log(aA);
        }
    }

    public static void r(c cVar) {
        ao aA;
        if (cVar != null && (aA = cVar.aA("c13587", true)) != null) {
            a(cVar, aA);
            TiebaStatic.log(aA);
        }
    }

    private static void a(c cVar, ao aoVar) {
        if (cVar != null && cVar.aPS() != null && aoVar != null) {
            if (cVar.aPS().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = cVar.aPS().getBaijiahaoData();
                aoVar.ag("obj_param5", 3);
                aoVar.dk("obj_param4", baijiahaoData.oriUgcNid);
                aoVar.dk("obj_param6", baijiahaoData.oriUgcVid);
                return;
            }
            aoVar.ag("obj_param5", 1);
        }
    }
}
