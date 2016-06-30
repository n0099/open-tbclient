package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ p aSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.aSO = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        com.baidu.tieba.tbadkCore.y yVar;
        String str7;
        if (view != null) {
            if (view.getId() == u.g.forum_add_love) {
                if (com.baidu.tbadk.core.util.bn.ab(this.aSO.getView().getContext())) {
                    String str8 = (String) view.getTag(u.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(u.g.tag_forum_id));
                    if (com.baidu.tbadk.core.util.ba.aL(str8)) {
                        yVar = this.aSO.Dq;
                        yVar.bJ(str8, valueOf);
                        str7 = this.aSO.aSI;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay(str7).ab("fid", valueOf).ab("obj_param3", at.La()));
                    }
                }
            } else if (view.getTag(u.g.tag_forum_name) != null) {
                String str9 = (String) view.getTag(u.g.tag_forum_name);
                String valueOf2 = String.valueOf(view.getTag(u.g.tag_forum_id));
                if (com.baidu.tbadk.core.util.ba.aL(str9)) {
                    if (view.getId() != u.g.m_forum_name_textview) {
                        str = this.aSO.aSJ;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay(str).ab("fid", valueOf2).ab("obj_param3", at.La()));
                    } else {
                        str6 = this.aSO.aSK;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay(str6).ab("fid", valueOf2).ab("obj_param3", at.La()));
                    }
                    str2 = this.aSO.stType;
                    if (!StringUtils.isNull(str2)) {
                        str3 = this.aSO.aSL;
                        if (!StringUtils.isNull(str3)) {
                            MessageManager messageManager = MessageManager.getInstance();
                            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.aSO.getView().getContext());
                            str4 = this.aSO.stType;
                            str5 = this.aSO.aSL;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(str9, str4, str5)));
                            return;
                        }
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aSO.getView().getContext()).createNormalCfg(str9, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }
}
