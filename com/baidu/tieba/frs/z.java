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
public class z implements View.OnClickListener {
    final /* synthetic */ r bPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(r rVar) {
        this.bPn = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bPn.bOn == null || view != this.bPn.bOn.ZC()) {
            if (this.bPn.bNT != null && this.bPn.bNT.aHE() != null) {
                if (this.bPn.bOn == null || view != this.bPn.bOn.ZI()) {
                    if (this.bPn.bOn != null && view == this.bPn.bOn.ZJ()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10378").s("obj_type", 5));
                        if (!StringUtils.isNull(this.bPn.bNT.aHE().getName())) {
                            this.bPn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(this.bPn.getPageContext().getPageActivity(), this.bPn.bNT.aHE().getName())));
                            return;
                        }
                        return;
                    }
                } else {
                    if (this.bPn.bNT.aHE() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12046").aa("fid", this.bPn.bNT.aHE().getId()).s("obj_locate", this.bPn.Zt() ? 1 : 2));
                    }
                    this.bPn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bPn.getPageContext().getPageActivity(), this.bPn.bNT.aHE().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
            }
            if (view.getId() == w.h.game_activity_egg_layout && com.baidu.adp.lib.util.k.hB()) {
                TiebaStatic.log("c10853");
                if (this.bPn.bOn.ZL()) {
                    this.bPn.bOn.ZM();
                    return;
                }
                String activityUrl = this.bPn.bNT.aHE().getYuleData().sW().getActivityUrl();
                if (!StringUtils.isNull(activityUrl)) {
                    com.baidu.tbadk.browser.f.T(this.bPn.getPageContext().getPageActivity(), activityUrl);
                    return;
                }
                return;
            }
            return;
        }
        this.bPn.getActivity().finish();
    }
}
