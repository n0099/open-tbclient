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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.b;
import com.baidu.tieba.card.n;
import com.baidu.tieba.frs.l;
/* loaded from: classes22.dex */
public class a {
    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z, Rect rect) {
        if (aVar != null && aVar.bmn() != null && context != null) {
            by bmn = aVar.bmn();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(bmn, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bmn.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(bmn.boT());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (aVar.bmq() != null) {
                createFromThreadCfg.addLocateParam(aVar.bmq());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(bmn)) {
                createFromThreadCfg.setNeedPreLoad(true);
                l.an(bmn);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            n.Jq(bmn.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private static boolean w(by byVar) {
        if (byVar == null || byVar.isShareThread) {
            return false;
        }
        int i = byVar.threadType;
        if (i == 0 || i == 11 || i == 40) {
            return true;
        }
        return byVar.bnz();
    }

    public static void a(b bVar, int i) {
        ar aJ;
        if (bVar != null && bVar.bmn() != null && (aJ = bVar.aJ("c13496", true)) != null) {
            aJ.al("obj_type", i);
            TiebaStatic.log(aJ);
        }
    }

    public static void b(b bVar, int i) {
        ar aJ;
        if (bVar != null && bVar.bmn() != null && com.baidu.tieba.card.data.l.ad(bVar.eCR) && (aJ = bVar.aJ("c13494", true)) != null) {
            aJ.al("obj_type", i);
            TiebaStatic.log(aJ);
        }
    }

    public static void c(b bVar, int i) {
        ar aJ;
        if (bVar != null && com.baidu.tieba.card.data.l.ad(bVar.eCR) && (aJ = bVar.aJ("c13495", true)) != null) {
            aJ.al("obj_type", i);
            TiebaStatic.log(aJ);
        }
    }

    public static void d(b bVar, int i) {
        ar aJ;
        if (bVar != null && (aJ = bVar.aJ("c13488", true)) != null) {
            if (bVar.bmn() != null) {
                by bmn = bVar.bmn();
                aJ.al("obj_name", bmn.bqu() != null && (bmn.bqu().dPi() != null || bmn.bqu().bIK() != null) ? 1 : 0);
                if (bmn.boP() != null) {
                    aJ.al(TiebaInitialize.Params.AB_TYPE, bmn.boP().hadConcerned() ? 1 : 0);
                }
            }
            aJ.al("obj_type", i);
            TiebaStatic.log(aJ);
        }
    }
}
