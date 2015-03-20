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
    private final /* synthetic */ String aVU;
    final /* synthetic */ ItemFootNavView bcX;
    private final /* synthetic */ ForumDetailActivity bcY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity, String str) {
        this.bcX = itemFootNavView;
        this.bcY = forumDetailActivity;
        this.aVU = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        boolean z;
        ForumDetailActivity forumDetailActivity;
        context = this.bcX.mContext;
        TiebaStatic.eventStat(context, "detail_enter_forum", "click", 1, new Object[0]);
        z = this.bcX.bcV;
        if (z) {
            this.bcY.finish();
            return;
        }
        this.bcY.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bcY.getPageContext().getPageActivity()).createNormalCfg(this.aVU, "bar_detail")));
        if (this.bcY != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(this.bcY.Qe())) {
            forumDetailActivity = this.bcX.bcE;
            TiebaStatic.eventStat(forumDetailActivity.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
        }
    }
}
