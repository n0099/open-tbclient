package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ String aOr;
    private final /* synthetic */ ForumDetailActivity aZA;
    final /* synthetic */ ItemFootNavView aZz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity, String str) {
        this.aZz = itemFootNavView;
        this.aZA = forumDetailActivity;
        this.aOr = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        boolean z;
        context = this.aZz.mContext;
        TiebaStatic.eventStat(context, "detail_enter_forum", "click", 1, new Object[0]);
        z = this.aZz.aZw;
        if (z) {
            this.aZA.finish();
        } else {
            this.aZA.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aZA.getPageContext().getPageActivity()).createNormalCfg(this.aOr, "bar_detail")));
        }
    }
}
