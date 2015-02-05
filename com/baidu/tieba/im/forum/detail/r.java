package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    private final /* synthetic */ String aPz;
    final /* synthetic */ ItemFootNavView baV;
    private final /* synthetic */ ForumDetailActivity baW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ItemFootNavView itemFootNavView, ForumDetailActivity forumDetailActivity, String str) {
        this.baV = itemFootNavView;
        this.baW = forumDetailActivity;
        this.aPz = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        boolean z;
        context = this.baV.mContext;
        TiebaStatic.eventStat(context, "detail_enter_forum", "click", 1, new Object[0]);
        z = this.baV.baS;
        if (z) {
            this.baW.finish();
        } else {
            this.baW.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.baW.getPageContext().getPageActivity()).createNormalCfg(this.aPz, "bar_detail")));
        }
    }
}
