package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ h aZm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar) {
        this.aZm = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        com.baidu.tieba.tbadkCore.x xVar;
        String str7;
        if (view != null) {
            if (view.getId() == r.g.forum_add_love) {
                if (com.baidu.tbadk.core.util.bm.ak(this.aZm.getView().getContext())) {
                    String str8 = (String) view.getTag(r.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(r.g.tag_forum_id));
                    if (com.baidu.tbadk.core.util.az.aN(str8)) {
                        xVar = this.aZm.Ge;
                        xVar.bQ(str8, valueOf);
                        str7 = this.aZm.aZg;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ax(str7).ab("fid", valueOf).ab("obj_param3", an.Oc()));
                    }
                }
            } else if (view.getTag(r.g.tag_forum_name) != null) {
                String str9 = (String) view.getTag(r.g.tag_forum_name);
                String valueOf2 = String.valueOf(view.getTag(r.g.tag_forum_id));
                if (com.baidu.tbadk.core.util.az.aN(str9)) {
                    if (view.getId() != r.g.m_forum_name_textview) {
                        str = this.aZm.aZh;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ax(str).ab("fid", valueOf2).ab("obj_param3", an.Oc()));
                    } else {
                        str6 = this.aZm.aZi;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ax(str6).ab("fid", valueOf2).ab("obj_param3", an.Oc()));
                    }
                    str2 = this.aZm.stType;
                    if (!StringUtils.isNull(str2)) {
                        str3 = this.aZm.aZj;
                        if (!StringUtils.isNull(str3)) {
                            MessageManager messageManager = MessageManager.getInstance();
                            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.aZm.getView().getContext());
                            str4 = this.aZm.stType;
                            str5 = this.aZm.aZj;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(str9, str4, str5)));
                            return;
                        }
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aZm.getView().getContext()).createNormalCfg(str9, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }
}
