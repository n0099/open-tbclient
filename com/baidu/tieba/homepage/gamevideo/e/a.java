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
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(blp, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(blp.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
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
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
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

    public static void a(b bVar, int i) {
        ar az;
        if (bVar != null && bVar.blp() != null && (az = bVar.az("c13496", true)) != null) {
            az.aq("obj_type", i);
            TiebaStatic.log(az);
        }
    }

    public static void b(b bVar, int i) {
        ar az;
        if (bVar != null && bVar.blp() != null && com.baidu.tieba.card.data.l.ae(bVar.eLr) && (az = bVar.az("c13494", true)) != null) {
            az.aq("obj_type", i);
            TiebaStatic.log(az);
        }
    }

    public static void c(b bVar, int i) {
        ar az;
        if (bVar != null && com.baidu.tieba.card.data.l.ae(bVar.eLr) && (az = bVar.az("c13495", true)) != null) {
            az.aq("obj_type", i);
            TiebaStatic.log(az);
        }
    }

    public static void d(b bVar, int i) {
        ar az;
        if (bVar != null && (az = bVar.az("c13488", true)) != null) {
            if (bVar.blp() != null) {
                cb blp = bVar.blp();
                az.aq("obj_name", blp.bpx() != null && (blp.bpx().dNQ() != null || blp.bpx().bHL() != null) ? 1 : 0);
                if (blp.bnS() != null) {
                    az.aq(TiebaInitialize.Params.AB_TYPE, blp.bnS().hadConcerned() ? 1 : 0);
                }
            }
            az.aq("obj_type", i);
            TiebaStatic.log(az);
        }
    }
}
