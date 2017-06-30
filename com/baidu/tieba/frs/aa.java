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
    final /* synthetic */ r cdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(r rVar) {
        this.cdl = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cdl.ccj == null || view != this.cdl.ccj.aew()) {
            if (this.cdl.cbN != null && this.cdl.cbN.aMt() != null) {
                if (this.cdl.ccj == null || view != this.cdl.ccj.aeC()) {
                    if (this.cdl.ccj != null && view == this.cdl.ccj.aeD()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10378").r("obj_type", 5));
                        if (!StringUtils.isNull(this.cdl.cbN.aMt().getName())) {
                            this.cdl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(this.cdl.getPageContext().getPageActivity(), this.cdl.cbN.aMt().getName())));
                            return;
                        }
                        return;
                    }
                } else if (!StringUtils.isNull(this.cdl.cbN.aMt().getId())) {
                    if (this.cdl.cbN.aMt() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c12046").Z("fid", this.cdl.cbN.aMt().getId()).r("obj_locate", this.cdl.aem() ? 1 : 2));
                    }
                    this.cdl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.cdl.getPageContext().getPageActivity(), this.cdl.cbN.aMt().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                } else {
                    return;
                }
            }
            if (view.getId() == w.h.game_activity_egg_layout && com.baidu.adp.lib.util.k.hA()) {
                TiebaStatic.log("c10853");
                if (this.cdl.ccj.aeF()) {
                    this.cdl.ccj.aeG();
                    return;
                }
                String activityUrl = this.cdl.cbN.aMt().getYuleData().sT().getActivityUrl();
                if (!StringUtils.isNull(activityUrl)) {
                    com.baidu.tbadk.browser.g.U(this.cdl.getPageContext().getPageActivity(), activityUrl);
                    return;
                }
                return;
            }
            return;
        }
        this.cdl.getActivity().finish();
    }
}
