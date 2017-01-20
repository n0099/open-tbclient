package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.LikeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ h blo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar) {
        this.blo = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        LikeModel likeModel;
        String str7;
        if (view != null) {
            if (view.getId() == r.h.forum_add_love) {
                if (com.baidu.tbadk.core.util.bf.ak(this.blo.getView().getContext())) {
                    String str8 = (String) view.getTag(r.h.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(r.h.tag_forum_id));
                    if (com.baidu.tbadk.core.util.at.aM(str8)) {
                        likeModel = this.blo.Fq;
                        likeModel.ce(str8, valueOf);
                        str7 = this.blo.bli;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar(str7).ab("fid", valueOf).ab("obj_param3", at.Rr()));
                    }
                }
            } else if (view.getTag(r.h.tag_forum_name) != null) {
                String str9 = (String) view.getTag(r.h.tag_forum_name);
                String valueOf2 = String.valueOf(view.getTag(r.h.tag_forum_id));
                if (com.baidu.tbadk.core.util.at.aM(str9)) {
                    if (view.getId() != r.h.m_forum_name_textview) {
                        str = this.blo.blj;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar(str).ab("fid", valueOf2).ab("obj_param3", at.Rr()));
                    } else {
                        str6 = this.blo.blk;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar(str6).ab("fid", valueOf2).ab("obj_param3", at.Rr()));
                    }
                    str2 = this.blo.stType;
                    if (!StringUtils.isNull(str2)) {
                        str3 = this.blo.bll;
                        if (!StringUtils.isNull(str3)) {
                            MessageManager messageManager = MessageManager.getInstance();
                            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.blo.getView().getContext());
                            str4 = this.blo.stType;
                            str5 = this.blo.bll;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(str9, str4, str5)));
                            return;
                        }
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.blo.getView().getContext()).createNormalCfg(str9, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }
}
