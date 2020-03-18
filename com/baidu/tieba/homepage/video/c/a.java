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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.l;
import com.baidu.tieba.frs.i;
/* loaded from: classes9.dex */
public class a {
    public static void a(com.baidu.tbadk.core.data.a aVar, Context context, int i, boolean z, Rect rect) {
        if (aVar != null && aVar.aAj() != null && context != null) {
            bj aAj = aVar.aAj();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(aAj, null, "video_tab", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(aAj.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
            createFromThreadCfg.setForumName(aAj.aCw());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (aVar.aAm() != null) {
                createFromThreadCfg.addLocateParam(aVar.aAm());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && t(aAj)) {
                createFromThreadCfg.setNeedPreLoad(true);
                i.ak(aAj);
            }
            createFromThreadCfg.setVideo_source("video_tab");
            createFromThreadCfg.setJumpGodReply(z);
            l.zU(aAj.getTid());
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
        return bjVar.aEm();
    }

    public static void k(c cVar) {
        an af;
        if (cVar != null && (af = cVar.af("c13583", true)) != null) {
            a(cVar, af);
            TiebaStatic.log(af);
        }
    }

    public static void l(c cVar) {
        an af;
        if (cVar != null && (af = cVar.af("c13584", true)) != null) {
            a(cVar, af);
            af.X("obj_floor", cVar.position + 1);
            TiebaStatic.log(af);
        }
    }

    public static void m(c cVar) {
        an af;
        if (cVar != null && (af = cVar.af("c13585", true)) != null) {
            a(cVar, af);
            TiebaStatic.log(af);
        }
    }

    public static void n(c cVar) {
        an af;
        if (cVar != null && (af = cVar.af("c13586", true)) != null) {
            a(cVar, af);
            TiebaStatic.log(af);
        }
    }

    public static void o(c cVar) {
        an af;
        if (cVar != null) {
            if ((TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE || (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF && TbSingleton.getInstance().isVideoEnterMiddlePage())) && (af = cVar.af("c13587", true)) != null) {
                a(cVar, af);
                TiebaStatic.log(af);
            }
        }
    }

    private static void a(c cVar, an anVar) {
        if (cVar != null && cVar.aAj() != null && anVar != null) {
            if (cVar.aAj().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = cVar.aAj().getBaijiahaoData();
                anVar.X("obj_param5", 3);
                anVar.cx("obj_param4", baijiahaoData.oriUgcNid);
                anVar.cx("obj_param6", baijiahaoData.oriUgcVid);
                return;
            }
            anVar.X("obj_param5", 1);
        }
    }
}
