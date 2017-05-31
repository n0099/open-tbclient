package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ r bVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(r rVar) {
        this.bVb = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bVb.bUa == null || view != this.bVb.bUa.aaF()) {
            if (this.bVb.bTF != null && this.bVb.bTF.aIz() != null) {
                if (this.bVb.bUa == null || view != this.bVb.bUa.aaL()) {
                    if (this.bVb.bUa != null && view == this.bVb.bUa.aaM()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10378").r("obj_type", 5));
                        if (!StringUtils.isNull(this.bVb.bTF.aIz().getName())) {
                            this.bVb.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(this.bVb.getPageContext().getPageActivity(), this.bVb.bTF.aIz().getName())));
                            return;
                        }
                        return;
                    }
                } else if (!StringUtils.isNull(this.bVb.bTF.aIz().getId())) {
                    if (this.bVb.bTF.aIz() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12046").Z("fid", this.bVb.bTF.aIz().getId()).r("obj_locate", this.bVb.aaw() ? 1 : 2));
                    }
                    this.bVb.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bVb.getPageContext().getPageActivity(), this.bVb.bTF.aIz().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                } else {
                    return;
                }
            }
            if (view.getId() == w.h.game_activity_egg_layout && com.baidu.adp.lib.util.k.hB()) {
                TiebaStatic.log("c10853");
                if (this.bVb.bUa.aaO()) {
                    this.bVb.bUa.aaP();
                    return;
                }
                String activityUrl = this.bVb.bTF.aIz().getYuleData().sV().getActivityUrl();
                if (!StringUtils.isNull(activityUrl)) {
                    com.baidu.tbadk.browser.f.T(this.bVb.getPageContext().getPageActivity(), activityUrl);
                    return;
                }
                return;
            }
            return;
        }
        this.bVb.getActivity().finish();
    }
}
