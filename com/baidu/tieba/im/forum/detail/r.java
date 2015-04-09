package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    private final /* synthetic */ String aWk;
    final /* synthetic */ ItemFootNavView bdn;
    private final /* synthetic */ ForumDetailActivity bdo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity, String str) {
        this.bdn = itemFootNavView;
        this.bdo = forumDetailActivity;
        this.aWk = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        boolean z;
        ForumDetailActivity forumDetailActivity;
        context = this.bdn.mContext;
        TiebaStatic.eventStat(context, "detail_enter_forum", "click", 1, new Object[0]);
        z = this.bdn.bdl;
        if (z) {
            this.bdo.finish();
            return;
        }
        this.bdo.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bdo.getPageContext().getPageActivity()).createNormalCfg(this.aWk, "bar_detail")));
        if (this.bdo != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(this.bdo.Qr())) {
            forumDetailActivity = this.bdn.bcU;
            TiebaStatic.eventStat(forumDetailActivity.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
        }
    }
}
