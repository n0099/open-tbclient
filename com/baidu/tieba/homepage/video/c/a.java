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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.b;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.l;
/* loaded from: classes2.dex */
public class a {
    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z, Rect rect) {
        if (aVar != null && aVar.blp() != null && context != null) {
            cb blp = aVar.blp();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(blp, null, "video_tab", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(blp.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
            createFromThreadCfg.setForumName(blp.bnW());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (aVar.bls() != null) {
                createFromThreadCfg.addLocateParam(aVar.bls());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(blp)) {
                createFromThreadCfg.setNeedPreLoad(true);
                l.ao(blp);
            }
            createFromThreadCfg.setVideo_source("video_tab");
            createFromThreadCfg.setJumpGodReply(z);
            m.IW(blp.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private static boolean w(cb cbVar) {
        if (cbVar == null || cbVar.isShareThread) {
            return false;
        }
        int i = cbVar.threadType;
        if (i == 0 || i == 11 || i == 40) {
            return true;
        }
        return cbVar.bmB();
    }

    public static void n(b bVar) {
        ar az;
        if (bVar != null && (az = bVar.az("c13583", true)) != null) {
            a(bVar, az);
            TiebaStatic.log(az);
        }
    }

    public static void o(b bVar) {
        ar az;
        if (bVar != null && (az = bVar.az("c13584", true)) != null) {
            a(bVar, az);
            az.aq("obj_floor", bVar.position + 1);
            TiebaStatic.log(az);
        }
    }

    public static void p(b bVar) {
        ar az;
        if (bVar != null && (az = bVar.az("c13585", true)) != null) {
            a(bVar, az);
            TiebaStatic.log(az);
        }
    }

    public static void q(b bVar) {
        ar az;
        if (bVar != null && (az = bVar.az("c13586", true)) != null) {
            a(bVar, az);
            TiebaStatic.log(az);
        }
    }

    public static void r(b bVar) {
        ar az;
        if (bVar != null && (az = bVar.az("c13587", true)) != null) {
            a(bVar, az);
            TiebaStatic.log(az);
        }
    }

    private static void a(b bVar, ar arVar) {
        if (bVar != null && bVar.blp() != null && arVar != null) {
            if (bVar.blp().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = bVar.blp().getBaijiahaoData();
                arVar.aq("obj_param5", 3);
                arVar.dR("obj_param4", baijiahaoData.oriUgcNid);
                arVar.dR("obj_param6", baijiahaoData.oriUgcVid);
                return;
            }
            arVar.aq("obj_param5", 1);
        }
    }
}
