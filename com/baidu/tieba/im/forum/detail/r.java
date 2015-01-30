package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    private final /* synthetic */ String aPA;
    final /* synthetic */ ItemFootNavView baW;
    private final /* synthetic */ ForumDetailActivity baX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity, String str) {
        this.baW = itemFootNavView;
        this.baX = forumDetailActivity;
        this.aPA = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        boolean z;
        context = this.baW.mContext;
        TiebaStatic.eventStat(context, "detail_enter_forum", "click", 1, new Object[0]);
        z = this.baW.baT;
        if (z) {
            this.baX.finish();
        } else {
            this.baX.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.baX.getPageContext().getPageActivity()).createNormalCfg(this.aPA, "bar_detail")));
        }
    }
}
