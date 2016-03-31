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
public class ac implements View.OnClickListener {
    final /* synthetic */ y aSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(y yVar) {
        this.aSZ = yVar;
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
                if (com.baidu.tbadk.core.util.bl.ad(this.aSZ.getView().getContext())) {
                    String str8 = (String) view.getTag(t.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(t.g.tag_forum_id));
                    if (com.baidu.tbadk.core.util.ay.aS(str8)) {
                        wVar = this.aSZ.MY;
                        wVar.bC(str8, valueOf);
                        str7 = this.aSZ.aGe;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aw(str7).ac("fid", valueOf).ac("obj_param3", bc.Lr()));
                    }
                }
            } else if (view.getTag(t.g.tag_forum_name) != null) {
                String str9 = (String) view.getTag(t.g.tag_forum_name);
                String valueOf2 = String.valueOf(view.getTag(t.g.tag_forum_id));
                if (com.baidu.tbadk.core.util.ay.aS(str9)) {
                    if (view.getId() != t.g.m_forum_name_textview) {
                        str = this.aSZ.aSW;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aw(str).ac("fid", valueOf2).ac("obj_param3", bc.Lr()));
                    } else {
                        str6 = this.aSZ.aSX;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aw(str6).ac("fid", valueOf2).ac("obj_param3", bc.Lr()));
                    }
                    str2 = this.aSZ.stType;
                    if (!StringUtils.isNull(str2)) {
                        str3 = this.aSZ.aSY;
                        if (!StringUtils.isNull(str3)) {
                            MessageManager messageManager = MessageManager.getInstance();
                            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.aSZ.getView().getContext());
                            str4 = this.aSZ.stType;
                            str5 = this.aSZ.aSY;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(str9, str4, str5)));
                            return;
                        }
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aSZ.getView().getContext()).createNormalCfg(str9, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }
}
