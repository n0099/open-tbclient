package com.baidu.tieba.chat;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f970a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ChatListFragment chatListFragment) {
        this.f970a = chatListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        switch (view.getId()) {
            case R.id.chat_head /* 2131099908 */:
                HeadImageView headImageView = (HeadImageView) view;
                String userId = headImageView.getUserId();
                String userName = headImageView.getUserName();
                if (userId != null && userId.length() > 0) {
                    activity = this.f970a.c;
                    PersonInfoActivity.a(activity, userId, userName);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
