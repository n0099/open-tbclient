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
/* loaded from: classes7.dex */
public class a {
    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z, Rect rect) {
        if (aVar != null && aVar.axQ() != null && context != null) {
            bj axQ = aVar.axQ();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(axQ, null, ImageViewerConfig.FROM_GAME_VIDEO, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(axQ.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_GAME_VIDEO);
            createFromThreadCfg.setForumName(axQ.aAc());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (aVar.axT() != null) {
                createFromThreadCfg.addLocateParam(aVar.axT());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && t(axQ)) {
                createFromThreadCfg.setNeedPreLoad(true);
                i.ai(axQ);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            l.zC(axQ.getTid());
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
        return bjVar.aBV();
    }

    public static void a(c cVar, int i) {
        an af;
        if (cVar != null && cVar.axQ() != null && (af = cVar.af("c13496", true)) != null) {
            af.Z("obj_type", i);
            TiebaStatic.log(af);
        }
    }

    public static void b(c cVar, int i) {
        an af;
        if (cVar != null && cVar.axQ() != null && com.baidu.tieba.card.data.l.Z(cVar.cNb) && (af = cVar.af("c13494", true)) != null) {
            af.Z("obj_type", i);
            TiebaStatic.log(af);
        }
    }

    public static void c(c cVar, int i) {
        an af;
        if (cVar != null && com.baidu.tieba.card.data.l.Z(cVar.cNb) && (af = cVar.af("c13495", true)) != null) {
            af.Z("obj_type", i);
            TiebaStatic.log(af);
        }
    }

    public static void d(c cVar, int i) {
        an af;
        if (cVar != null && (af = cVar.af("c13488", true)) != null) {
            if (cVar.axQ() != null) {
                bj axQ = cVar.axQ();
                af.Z("obj_name", axQ.aBx() != null && (axQ.aBx().cJz() != null || axQ.aBx().aRH() != null) ? 1 : 0);
                if (axQ.azX() != null) {
                    af.Z(TiebaInitialize.Params.AB_TYPE, axQ.azX().hadConcerned() ? 1 : 0);
                }
            }
            af.Z("obj_type", i);
            TiebaStatic.log(af);
        }
    }
}
