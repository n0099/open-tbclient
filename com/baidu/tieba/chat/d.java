package com.baidu.tieba.chat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.person.cm;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        switch (view.getId()) {
            case R.id.chat_head /* 2131100037 */:
                HeadImageView headImageView = (HeadImageView) view;
                String userId = headImageView.getUserId();
                String userName = headImageView.getUserName();
                String userName2 = headImageView.getUserName();
                if (TextUtils.isEmpty(userName2)) {
                    if (userId != null && userId.length() > 0) {
                        activity2 = this.a.d;
                        cm.a(activity2, userId, userName);
                        return;
                    }
                    return;
                } else if (!userName2.equals(SocialConstants.TRUE) && !userName2.equals("2") && !userName2.equals("3") && userId != null && userId.length() > 0) {
                    activity = this.a.d;
                    cm.a(activity, userId, userName);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
