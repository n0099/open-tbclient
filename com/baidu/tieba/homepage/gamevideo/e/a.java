package com.baidu.tieba.homepage.gamevideo.e;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.data.b;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.l;
/* loaded from: classes2.dex */
public class a {
    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z, Rect rect) {
        if (aVar != null && aVar.boO() != null && context != null) {
            bz boO = aVar.boO();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(boO, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(boO.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(boO.bru());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (aVar.boR() != null) {
                createFromThreadCfg.addLocateParam(aVar.boR());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(boO)) {
                createFromThreadCfg.setNeedPreLoad(true);
                l.an(boO);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            m.Jo(boO.getTid());
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
        return bzVar.bpZ();
    }

    public static void a(b bVar, int i) {
        aq aA;
        if (bVar != null && bVar.boO() != null && (aA = bVar.aA("c13496", true)) != null) {
            aA.an("obj_type", i);
            TiebaStatic.log(aA);
        }
    }

    public static void b(b bVar, int i) {
        aq aA;
        if (bVar != null && bVar.boO() != null && com.baidu.tieba.card.data.l.ad(bVar.eMv) && (aA = bVar.aA("c13494", true)) != null) {
            aA.an("obj_type", i);
            TiebaStatic.log(aA);
        }
    }

    public static void c(b bVar, int i) {
        aq aA;
        if (bVar != null && com.baidu.tieba.card.data.l.ad(bVar.eMv) && (aA = bVar.aA("c13495", true)) != null) {
            aA.an("obj_type", i);
            TiebaStatic.log(aA);
        }
    }

    public static void d(b bVar, int i) {
        aq aA;
        if (bVar != null && (aA = bVar.aA("c13488", true)) != null) {
            if (bVar.boO() != null) {
                bz boO = bVar.boO();
                aA.an("obj_name", boO.bsW() != null && (boO.bsW().dPf() != null || boO.bsW().bLe() != null) ? 1 : 0);
                if (boO.brq() != null) {
                    aA.an(TiebaInitialize.Params.AB_TYPE, boO.brq().hadConcerned() ? 1 : 0);
                }
            }
            aA.an("obj_type", i);
            TiebaStatic.log(aA);
        }
    }
}
