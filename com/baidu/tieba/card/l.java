package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ h brZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar) {
        this.brZ = hVar;
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
            if (view.getId() == w.h.forum_add_love) {
                if (com.baidu.tbadk.core.util.bg.aK(this.brZ.getView().getContext())) {
                    String str8 = (String) view.getTag(w.h.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(w.h.tag_forum_id));
                    if (com.baidu.tbadk.core.util.au.aB(str8)) {
                        likeModel = this.brZ.brQ;
                        likeModel.bZ(str8, valueOf);
                        str7 = this.brZ.brT;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as(str7).aa("fid", valueOf).aa("obj_param3", at.SN()));
                    }
                }
            } else if (view.getTag(w.h.tag_forum_name) != null) {
                String str9 = (String) view.getTag(w.h.tag_forum_name);
                String valueOf2 = String.valueOf(view.getTag(w.h.tag_forum_id));
                if (com.baidu.tbadk.core.util.au.aB(str9)) {
                    if (view.getId() != w.h.m_forum_name_textview) {
                        str = this.brZ.brU;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as(str).aa("fid", valueOf2).aa("obj_param3", at.SN()));
                    } else {
                        str6 = this.brZ.brV;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as(str6).aa("fid", valueOf2).aa("obj_param3", at.SN()));
                    }
                    str2 = this.brZ.stType;
                    if (!StringUtils.isNull(str2)) {
                        str3 = this.brZ.brW;
                        if (!StringUtils.isNull(str3)) {
                            MessageManager messageManager = MessageManager.getInstance();
                            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.brZ.getView().getContext());
                            str4 = this.brZ.stType;
                            str5 = this.brZ.brW;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(str9, str4, str5)));
                            return;
                        }
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.brZ.getView().getContext()).createNormalCfg(str9, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }
}
