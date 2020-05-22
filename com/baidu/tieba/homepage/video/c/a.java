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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.i;
/* loaded from: classes9.dex */
public class a {
    public static void a(AbsThreadDataSupport absThreadDataSupport, Context context, int i, boolean z, Rect rect) {
        if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && context != null) {
            bk aOi = absThreadDataSupport.aOi();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(aOi, null, "video_tab", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(aOi.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
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
            createFromThreadCfg.setVideo_source("video_tab");
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

    public static void k(c cVar) {
        an ay;
        if (cVar != null && (ay = cVar.ay("c13583", true)) != null) {
            a(cVar, ay);
            TiebaStatic.log(ay);
        }
    }

    public static void l(c cVar) {
        an ay;
        if (cVar != null && (ay = cVar.ay("c13584", true)) != null) {
            a(cVar, ay);
            ay.ag("obj_floor", cVar.position + 1);
            TiebaStatic.log(ay);
        }
    }

    public static void m(c cVar) {
        an ay;
        if (cVar != null && (ay = cVar.ay("c13585", true)) != null) {
            a(cVar, ay);
            TiebaStatic.log(ay);
        }
    }

    public static void n(c cVar) {
        an ay;
        if (cVar != null && (ay = cVar.ay("c13586", true)) != null) {
            a(cVar, ay);
            TiebaStatic.log(ay);
        }
    }

    public static void o(c cVar) {
        an ay;
        if (cVar != null) {
            if ((TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE || (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF && TbSingleton.getInstance().isVideoEnterMiddlePage())) && (ay = cVar.ay("c13587", true)) != null) {
                a(cVar, ay);
                TiebaStatic.log(ay);
            }
        }
    }

    private static void a(c cVar, an anVar) {
        if (cVar != null && cVar.aOi() != null && anVar != null) {
            if (cVar.aOi().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = cVar.aOi().getBaijiahaoData();
                anVar.ag("obj_param5", 3);
                anVar.dh("obj_param4", baijiahaoData.oriUgcNid);
                anVar.dh("obj_param6", baijiahaoData.oriUgcVid);
                return;
            }
            anVar.ag("obj_param5", 1);
        }
    }
}
