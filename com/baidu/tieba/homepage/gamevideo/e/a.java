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
        if (aVar != null && aVar.boP() != null && context != null) {
            bz boP = aVar.boP();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(boP, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(boP.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
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
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
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

    public static void a(b bVar, int i) {
        aq aA;
        if (bVar != null && bVar.boP() != null && (aA = bVar.aA("c13496", true)) != null) {
            aA.an("obj_type", i);
            TiebaStatic.log(aA);
        }
    }

    public static void b(b bVar, int i) {
        aq aA;
        if (bVar != null && bVar.boP() != null && com.baidu.tieba.card.data.l.ad(bVar.eMv) && (aA = bVar.aA("c13494", true)) != null) {
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
            if (bVar.boP() != null) {
                bz boP = bVar.boP();
                aA.an("obj_name", boP.bsX() != null && (boP.bsX().dPg() != null || boP.bsX().bLf() != null) ? 1 : 0);
                if (boP.brr() != null) {
                    aA.an(TiebaInitialize.Params.AB_TYPE, boP.brr().hadConcerned() ? 1 : 0);
                }
            }
            aA.an("obj_type", i);
            TiebaStatic.log(aA);
        }
    }
}
