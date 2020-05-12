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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.l;
import com.baidu.tieba.frs.i;
/* loaded from: classes9.dex */
public class a {
    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z, Rect rect) {
        if (aVar != null && aVar.aIu() != null && context != null) {
            bj aIu = aVar.aIu();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(aIu, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(aIu.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(aIu.aKH());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (aVar.aIx() != null) {
                createFromThreadCfg.addLocateParam(aVar.aIx());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && t(aIu)) {
                createFromThreadCfg.setNeedPreLoad(true);
                i.am(aIu);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            l.BE(aIu.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    private static boolean t(bj bjVar) {
        if (bjVar == null || bjVar.isShareThread) {
            return false;
        }
        int i = bjVar.threadType;
        if (i == 0 || i == 11 || i == 40) {
            return true;
        }
        return bjVar.aMy();
    }

    public static void a(c cVar, int i) {
        an al;
        if (cVar != null && cVar.aIu() != null && (al = cVar.al("c13496", true)) != null) {
            al.af("obj_type", i);
            TiebaStatic.log(al);
        }
    }

    public static void b(c cVar, int i) {
        an al;
        if (cVar != null && cVar.aIu() != null && com.baidu.tieba.card.data.l.ab(cVar.dqE) && (al = cVar.al("c13494", true)) != null) {
            al.af("obj_type", i);
            TiebaStatic.log(al);
        }
    }

    public static void c(c cVar, int i) {
        an al;
        if (cVar != null && com.baidu.tieba.card.data.l.ab(cVar.dqE) && (al = cVar.al("c13495", true)) != null) {
            al.af("obj_type", i);
            TiebaStatic.log(al);
        }
    }

    public static void d(c cVar, int i) {
        an al;
        if (cVar != null && (al = cVar.al("c13488", true)) != null) {
            if (cVar.aIu() != null) {
                bj aIu = cVar.aIu();
                al.af("obj_name", aIu.aMc() != null && (aIu.aMc().cWr() != null || aIu.aMc().bcn() != null) ? 1 : 0);
                if (aIu.aKC() != null) {
                    al.af(TiebaInitialize.Params.AB_TYPE, aIu.aKC().hadConcerned() ? 1 : 0);
                }
            }
            al.af("obj_type", i);
            TiebaStatic.log(al);
        }
    }
}
