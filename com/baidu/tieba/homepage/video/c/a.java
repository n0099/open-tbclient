package com.baidu.tieba.homepage.video.c;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.b;
import com.baidu.tieba.card.n;
import com.baidu.tieba.frs.l;
/* loaded from: classes21.dex */
public class a {
    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z, Rect rect) {
        if (aVar != null && aVar.bjd() != null && context != null) {
            bx bjd = aVar.bjd();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(bjd, null, "video_tab", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bjd.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
            createFromThreadCfg.setForumName(bjd.blG());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (aVar.bjg() != null) {
                createFromThreadCfg.addLocateParam(aVar.bjg());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(bjd)) {
                createFromThreadCfg.setNeedPreLoad(true);
                l.an(bjd);
            }
            createFromThreadCfg.setVideo_source("video_tab");
            createFromThreadCfg.setJumpGodReply(z);
            n.IA(bjd.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private static boolean w(bx bxVar) {
        if (bxVar == null || bxVar.isShareThread) {
            return false;
        }
        int i = bxVar.threadType;
        if (i == 0 || i == 11 || i == 40) {
            return true;
        }
        return bxVar.bkm();
    }

    public static void n(b bVar) {
        ar aI;
        if (bVar != null && (aI = bVar.aI("c13583", true)) != null) {
            a(bVar, aI);
            TiebaStatic.log(aI);
        }
    }

    public static void o(b bVar) {
        ar aI;
        if (bVar != null && (aI = bVar.aI("c13584", true)) != null) {
            a(bVar, aI);
            aI.ak("obj_floor", bVar.position + 1);
            TiebaStatic.log(aI);
        }
    }

    public static void p(b bVar) {
        ar aI;
        if (bVar != null && (aI = bVar.aI("c13585", true)) != null) {
            a(bVar, aI);
            TiebaStatic.log(aI);
        }
    }

    public static void q(b bVar) {
        ar aI;
        if (bVar != null && (aI = bVar.aI("c13586", true)) != null) {
            a(bVar, aI);
            TiebaStatic.log(aI);
        }
    }

    public static void r(b bVar) {
        ar aI;
        if (bVar != null && (aI = bVar.aI("c13587", true)) != null) {
            a(bVar, aI);
            TiebaStatic.log(aI);
        }
    }

    private static void a(b bVar, ar arVar) {
        if (bVar != null && bVar.bjd() != null && arVar != null) {
            if (bVar.bjd().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = bVar.bjd().getBaijiahaoData();
                arVar.ak("obj_param5", 3);
                arVar.dR("obj_param4", baijiahaoData.oriUgcNid);
                arVar.dR("obj_param6", baijiahaoData.oriUgcVid);
                return;
            }
            arVar.ak("obj_param5", 1);
        }
    }
}
