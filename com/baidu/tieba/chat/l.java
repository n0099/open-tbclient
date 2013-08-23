package com.baidu.tieba.chat;

import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListActivity f951a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ChatListActivity chatListActivity) {
        this.f951a = chatListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chat_head /* 2131099908 */:
                HeadImageView headImageView = (HeadImageView) view;
                String userId = headImageView.getUserId();
                String userName = headImageView.getUserName();
                if (userId != null && userId.length() > 0) {
                    PersonInfoActivity.a(this.f951a, userId, userName);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
