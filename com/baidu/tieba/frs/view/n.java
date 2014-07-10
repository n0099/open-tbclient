package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        activity = this.a.z;
        str = this.a.R;
        ForumListActivity.a(activity, str, TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT, TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
    }
}
