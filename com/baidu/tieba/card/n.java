package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ j aYS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.aYS = jVar;
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
            if (view.getId() == t.g.forum_add_love) {
                if (com.baidu.tbadk.core.util.bn.al(this.aYS.getView().getContext())) {
                    String str8 = (String) view.getTag(t.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(t.g.tag_forum_id));
                    if (com.baidu.tbadk.core.util.ba.aN(str8)) {
                        xVar = this.aYS.Ge;
                        xVar.bP(str8, valueOf);
                        str7 = this.aYS.aYM;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay(str7).ab("fid", valueOf).ab("obj_param3", ap.NC()));
                    }
                }
            } else if (view.getTag(t.g.tag_forum_name) != null) {
                String str9 = (String) view.getTag(t.g.tag_forum_name);
                String valueOf2 = String.valueOf(view.getTag(t.g.tag_forum_id));
                if (com.baidu.tbadk.core.util.ba.aN(str9)) {
                    if (view.getId() != t.g.m_forum_name_textview) {
                        str = this.aYS.aYN;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay(str).ab("fid", valueOf2).ab("obj_param3", ap.NC()));
                    } else {
                        str6 = this.aYS.aYO;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay(str6).ab("fid", valueOf2).ab("obj_param3", ap.NC()));
                    }
                    str2 = this.aYS.stType;
                    if (!StringUtils.isNull(str2)) {
                        str3 = this.aYS.aYP;
                        if (!StringUtils.isNull(str3)) {
                            MessageManager messageManager = MessageManager.getInstance();
                            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.aYS.getView().getContext());
                            str4 = this.aYS.stType;
                            str5 = this.aYS.aYP;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(str9, str4, str5)));
                            return;
                        }
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aYS.getView().getContext()).createNormalCfg(str9, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }
}
