package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ ItemFootNavView a;
    private final /* synthetic */ BaseActivity b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ItemFootNavView itemFootNavView, BaseActivity baseActivity, String str) {
        this.a = itemFootNavView;
        this.b = baseActivity;
        this.c = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        boolean z;
        context = this.a.a;
        TiebaStatic.eventStat(context, "detail_enter_forum", "click", 1, new Object[0]);
        z = this.a.g;
        if (z) {
            this.b.finish();
        } else {
            this.b.sendMessage(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(this.b).a(this.c, BarDetailForDirSwitchStatic.BAR_DETAIL_DIR)));
        }
    }
}
