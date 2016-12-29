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
    final /* synthetic */ h bbB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar) {
        this.bbB = hVar;
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
            if (view.getId() == r.g.forum_add_love) {
                if (com.baidu.tbadk.core.util.bh.ai(this.bbB.getView().getContext())) {
                    String str8 = (String) view.getTag(r.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(r.g.tag_forum_id));
                    if (com.baidu.tbadk.core.util.av.aN(str8)) {
                        wVar = this.bbB.Gg;
                        wVar.bV(str8, valueOf);
                        str7 = this.bbB.bbv;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.at(str7).ab("fid", valueOf).ab("obj_param3", ap.OA()));
                    }
                }
            } else if (view.getTag(r.g.tag_forum_name) != null) {
                String str9 = (String) view.getTag(r.g.tag_forum_name);
                String valueOf2 = String.valueOf(view.getTag(r.g.tag_forum_id));
                if (com.baidu.tbadk.core.util.av.aN(str9)) {
                    if (view.getId() != r.g.m_forum_name_textview) {
                        str = this.bbB.bbw;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.at(str).ab("fid", valueOf2).ab("obj_param3", ap.OA()));
                    } else {
                        str6 = this.bbB.bbx;
                        TiebaStatic.log(new com.baidu.tbadk.core.util.at(str6).ab("fid", valueOf2).ab("obj_param3", ap.OA()));
                    }
                    str2 = this.bbB.stType;
                    if (!StringUtils.isNull(str2)) {
                        str3 = this.bbB.bby;
                        if (!StringUtils.isNull(str3)) {
                            MessageManager messageManager = MessageManager.getInstance();
                            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.bbB.getView().getContext());
                            str4 = this.bbB.stType;
                            str5 = this.bbB.bby;
                            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createCfgForpersonalized(str9, str4, str5)));
                            return;
                        }
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bbB.getView().getContext()).createNormalCfg(str9, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                }
            }
        }
    }
}
