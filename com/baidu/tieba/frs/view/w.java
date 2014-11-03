package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ r aGu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(r rVar) {
        this.aGu = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.aGu.aBP;
        str = this.aGu.aFC;
        ForumListActivity.c(activity, str, TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT, "1");
    }
}
