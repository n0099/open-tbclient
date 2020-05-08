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
        if (aVar != null && aVar.aIu() != null && context != null) {
            bj aIu = aVar.aIu();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(aIu, null, "video_tab", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(aIu.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
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
            createFromThreadCfg.setVideo_source("video_tab");
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

    public static void k(c cVar) {
        an al;
        if (cVar != null && (al = cVar.al("c13583", true)) != null) {
            a(cVar, al);
            TiebaStatic.log(al);
        }
    }

    public static void l(c cVar) {
        an al;
        if (cVar != null && (al = cVar.al("c13584", true)) != null) {
            a(cVar, al);
            al.af("obj_floor", cVar.position + 1);
            TiebaStatic.log(al);
        }
    }

    public static void m(c cVar) {
        an al;
        if (cVar != null && (al = cVar.al("c13585", true)) != null) {
            a(cVar, al);
            TiebaStatic.log(al);
        }
    }

    public static void n(c cVar) {
        an al;
        if (cVar != null && (al = cVar.al("c13586", true)) != null) {
            a(cVar, al);
            TiebaStatic.log(al);
        }
    }

    public static void o(c cVar) {
        an al;
        if (cVar != null) {
            if ((TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE || (TbSingleton.getInstance().getNewVideoClickType() == TbSingleton.NEW_VIDEO_CLICK_TEST_SWITCH_OFF && TbSingleton.getInstance().isVideoEnterMiddlePage())) && (al = cVar.al("c13587", true)) != null) {
                a(cVar, al);
                TiebaStatic.log(al);
            }
        }
    }

    private static void a(c cVar, an anVar) {
        if (cVar != null && cVar.aIu() != null && anVar != null) {
            if (cVar.aIu().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = cVar.aIu().getBaijiahaoData();
                anVar.af("obj_param5", 3);
                anVar.cI("obj_param4", baijiahaoData.oriUgcNid);
                anVar.cI("obj_param6", baijiahaoData.oriUgcVid);
                return;
            }
            anVar.af("obj_param5", 1);
        }
    }
}
