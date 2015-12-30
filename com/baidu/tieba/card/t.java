package com.baidu.tieba.card;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ p aOb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.aOb = pVar;
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
            if (view.getId() == n.g.forum_add_love) {
                if (bj.ah(this.aOb.getView().getContext())) {
                    String str8 = (String) view.getTag(n.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(n.g.tag_forum_id));
                    if (ax.aR(str8)) {
                        xVar = this.aOb.MB;
                        xVar.bc(str8, valueOf);
                        str7 = this.aOb.aDT;
                        TiebaStatic.log(new av(str7).aa(ImageViewerConfig.FORUM_ID, valueOf).aa("obj_param3", x.Im()));
                    }
                }
            } else if ((view.getId() == n.g.forum_avatar || view.getId() == n.g.m_forum_name_textview) && view.getTag(n.g.tag_forum_name) != null) {
                String str9 = (String) view.getTag(n.g.tag_forum_name);
                String valueOf2 = String.valueOf(view.getTag(n.g.tag_forum_id));
                if (ax.aR(str9)) {
                    if (view.getId() == n.g.forum_avatar) {
                        str6 = this.aOb.aNY;
                        TiebaStatic.log(new av(str6).aa(ImageViewerConfig.FORUM_ID, valueOf2).aa("obj_param3", x.Im()));
                    } else if (view.getId() == n.g.m_forum_name_textview) {
                        str = this.aOb.aNZ;
                        TiebaStatic.log(new av(str).aa(ImageViewerConfig.FORUM_ID, valueOf2).aa("obj_param3", x.Im()));
                    }
                    str2 = this.aOb.stType;
                    if (!StringUtils.isNull(str2)) {
                        str3 = this.aOb.aOa;
                        if (!StringUtils.isNull(str3)) {
                            MessageManager messageManager = MessageManager.getInstance();
                            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.aOb.getView().getContext());
                            str4 = this.aOb.stType;
                            str5 = this.aOb.aOa;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(str9, str4, str5)));
                            return;
                        }
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aOb.getView().getContext()).createNormalCfg(str9, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }
}
