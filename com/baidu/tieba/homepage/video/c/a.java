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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.k;
/* loaded from: classes16.dex */
public class a {
    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, Rect rect) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null && context != null) {
            bv aTN = absThreadDataSupport.aTN();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(aTN, null, "video_tab", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(aTN.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
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
            createFromThreadCfg.setVideo_source("video_tab");
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

    public static void n(c cVar) {
        ap ay;
        if (cVar != null && (ay = cVar.ay("c13583", true)) != null) {
            a(cVar, ay);
            TiebaStatic.log(ay);
        }
    }

    public static void o(c cVar) {
        ap ay;
        if (cVar != null && (ay = cVar.ay("c13584", true)) != null) {
            a(cVar, ay);
            ay.ah("obj_floor", cVar.position + 1);
            TiebaStatic.log(ay);
        }
    }

    public static void p(c cVar) {
        ap ay;
        if (cVar != null && (ay = cVar.ay("c13585", true)) != null) {
            a(cVar, ay);
            TiebaStatic.log(ay);
        }
    }

    public static void q(c cVar) {
        ap ay;
        if (cVar != null && (ay = cVar.ay("c13586", true)) != null) {
            a(cVar, ay);
            TiebaStatic.log(ay);
        }
    }

    public static void r(c cVar) {
        ap ay;
        if (cVar != null && (ay = cVar.ay("c13587", true)) != null) {
            a(cVar, ay);
            TiebaStatic.log(ay);
        }
    }

    private static void a(c cVar, ap apVar) {
        if (cVar != null && cVar.aTN() != null && apVar != null) {
            if (cVar.aTN().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = cVar.aTN().getBaijiahaoData();
                apVar.ah("obj_param5", 3);
                apVar.dn("obj_param4", baijiahaoData.oriUgcNid);
                apVar.dn("obj_param6", baijiahaoData.oriUgcVid);
                return;
            }
            apVar.ah("obj_param5", 1);
        }
    }
}
