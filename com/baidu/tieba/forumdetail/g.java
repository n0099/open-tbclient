package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ ItemFootNavView axs;
    private final /* synthetic */ BaseActivity axt;
    private final /* synthetic */ String axu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ItemFootNavView itemFootNavView, BaseActivity baseActivity, String str) {
        this.axs = itemFootNavView;
        this.axt = baseActivity;
        this.axu = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        boolean z;
        context = this.axs.mContext;
        TiebaStatic.eventStat(context, "detail_enter_forum", "click", 1, new Object[0]);
        z = this.axs.axr;
        if (z) {
            this.axt.finish();
        } else {
            this.axt.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.axt).createNormalCfg(this.axu, BarDetailForDirSwitchStatic.BAR_DETAIL_DIR)));
        }
    }
}
