package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ w aQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar) {
        this.aQe = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        com.baidu.tieba.tbadkCore.w wVar;
        String str7;
        if (view != null) {
            if (view.getId() == t.g.forum_add_love) {
                if (bi.ah(this.aQe.getView().getContext())) {
                    String str8 = (String) view.getTag(t.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(t.g.tag_forum_id));
                    if (com.baidu.tbadk.core.util.aw.aQ(str8)) {
                        wVar = this.aQe.MS;
                        wVar.bl(str8, valueOf);
                        str7 = this.aQe.aEJ;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.au(str7).aa(ImageViewerConfig.FORUM_ID, valueOf).aa("obj_param3", ae.JU()));
                    }
                }
            } else if (view.getTag(t.g.tag_forum_name) != null) {
                String str9 = (String) view.getTag(t.g.tag_forum_name);
                String valueOf2 = String.valueOf(view.getTag(t.g.tag_forum_id));
                if (com.baidu.tbadk.core.util.aw.aQ(str9)) {
                    if (view.getId() != t.g.m_forum_name_textview) {
                        str = this.aQe.aQb;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.au(str).aa(ImageViewerConfig.FORUM_ID, valueOf2).aa("obj_param3", ae.JU()));
                    } else {
                        str6 = this.aQe.aQc;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.au(str6).aa(ImageViewerConfig.FORUM_ID, valueOf2).aa("obj_param3", ae.JU()));
                    }
                    str2 = this.aQe.stType;
                    if (!StringUtils.isNull(str2)) {
                        str3 = this.aQe.aQd;
                        if (!StringUtils.isNull(str3)) {
                            MessageManager messageManager = MessageManager.getInstance();
                            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.aQe.getView().getContext());
                            str4 = this.aQe.stType;
                            str5 = this.aQe.aQd;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(str9, str4, str5)));
                            return;
                        }
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aQe.getView().getContext()).createNormalCfg(str9, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }
}
