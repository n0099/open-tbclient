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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.data.b;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.l;
/* loaded from: classes2.dex */
public class a {
    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z, Rect rect) {
        if (aVar != null && aVar.boP() != null && context != null) {
            bz boP = aVar.boP();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(boP, null, "video_tab", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(boP.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
            createFromThreadCfg.setForumName(boP.brv());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (aVar.boS() != null) {
                createFromThreadCfg.addLocateParam(aVar.boS());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(boP)) {
                createFromThreadCfg.setNeedPreLoad(true);
                l.an(boP);
            }
            createFromThreadCfg.setVideo_source("video_tab");
            createFromThreadCfg.setJumpGodReply(z);
            m.Jn(boP.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private static boolean w(bz bzVar) {
        if (bzVar == null || bzVar.isShareThread) {
            return false;
        }
        int i = bzVar.threadType;
        if (i == 0 || i == 11 || i == 40) {
            return true;
        }
        return bzVar.bqa();
    }

    public static void n(b bVar) {
        aq aA;
        if (bVar != null && (aA = bVar.aA("c13583", true)) != null) {
            a(bVar, aA);
            TiebaStatic.log(aA);
        }
    }

    public static void o(b bVar) {
        aq aA;
        if (bVar != null && (aA = bVar.aA("c13584", true)) != null) {
            a(bVar, aA);
            aA.an("obj_floor", bVar.position + 1);
            TiebaStatic.log(aA);
        }
    }

    public static void p(b bVar) {
        aq aA;
        if (bVar != null && (aA = bVar.aA("c13585", true)) != null) {
            a(bVar, aA);
            TiebaStatic.log(aA);
        }
    }

    public static void q(b bVar) {
        aq aA;
        if (bVar != null && (aA = bVar.aA("c13586", true)) != null) {
            a(bVar, aA);
            TiebaStatic.log(aA);
        }
    }

    public static void r(b bVar) {
        aq aA;
        if (bVar != null && (aA = bVar.aA("c13587", true)) != null) {
            a(bVar, aA);
            TiebaStatic.log(aA);
        }
    }

    private static void a(b bVar, aq aqVar) {
        if (bVar != null && bVar.boP() != null && aqVar != null) {
            if (bVar.boP().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = bVar.boP().getBaijiahaoData();
                aqVar.an("obj_param5", 3);
                aqVar.dX("obj_param4", baijiahaoData.oriUgcNid);
                aqVar.dX("obj_param6", baijiahaoData.oriUgcVid);
                return;
            }
            aqVar.an("obj_param5", 1);
        }
    }
}
