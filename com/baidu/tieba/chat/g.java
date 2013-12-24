package com.baidu.tieba.chat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ ChatListFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatListFragment chatListFragment) {
        this.a = chatListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        switch (view.getId()) {
            case R.id.chat_head /* 2131099946 */:
                HeadImageView headImageView = (HeadImageView) view;
                String userId = headImageView.getUserId();
                String userName = headImageView.getUserName();
                String userName2 = headImageView.getUserName();
                if (TextUtils.isEmpty(userName2)) {
                    if (userId != null && userId.length() > 0) {
                        activity2 = this.a.c;
                        PersonInfoActivity.a(activity2, userId, userName);
                        return;
                    }
                    return;
                } else if (!userName2.equals(SocialConstants.TRUE) && !userName2.equals("2") && !userName2.equals("3") && userId != null && userId.length() > 0) {
                    activity = this.a.c;
                    PersonInfoActivity.a(activity, userId, userName);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
