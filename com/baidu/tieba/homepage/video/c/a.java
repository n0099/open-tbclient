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
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(bmn, null, "video_tab", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(bmn.getFid()));
            createFromThreadCfg.setFrom(PbActivityConfig.KEY_FROM_VIDEO_TAB);
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
            createFromThreadCfg.setVideo_source("video_tab");
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

    public static void n(b bVar) {
        ar aJ;
        if (bVar != null && (aJ = bVar.aJ("c13583", true)) != null) {
            a(bVar, aJ);
            TiebaStatic.log(aJ);
        }
    }

    public static void o(b bVar) {
        ar aJ;
        if (bVar != null && (aJ = bVar.aJ("c13584", true)) != null) {
            a(bVar, aJ);
            aJ.al("obj_floor", bVar.position + 1);
            TiebaStatic.log(aJ);
        }
    }

    public static void p(b bVar) {
        ar aJ;
        if (bVar != null && (aJ = bVar.aJ("c13585", true)) != null) {
            a(bVar, aJ);
            TiebaStatic.log(aJ);
        }
    }

    public static void q(b bVar) {
        ar aJ;
        if (bVar != null && (aJ = bVar.aJ("c13586", true)) != null) {
            a(bVar, aJ);
            TiebaStatic.log(aJ);
        }
    }

    public static void r(b bVar) {
        ar aJ;
        if (bVar != null && (aJ = bVar.aJ("c13587", true)) != null) {
            a(bVar, aJ);
            TiebaStatic.log(aJ);
        }
    }

    private static void a(b bVar, ar arVar) {
        if (bVar != null && bVar.bmn() != null && arVar != null) {
            if (bVar.bmn().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = bVar.bmn().getBaijiahaoData();
                arVar.al("obj_param5", 3);
                arVar.dY("obj_param4", baijiahaoData.oriUgcNid);
                arVar.dY("obj_param6", baijiahaoData.oriUgcVid);
                return;
            }
            arVar.al("obj_param5", 1);
        }
    }
}
