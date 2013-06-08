package com.baidu.tieba.chat;

import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.write.AtListActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ ChatListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ChatListActivity chatListActivity) {
        this.a = chatListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_back /* 2131099883 */:
                this.a.finish();
                return;
            case R.id.add_chat /* 2131099885 */:
                AtListActivity.a(this.a, 1200011);
                return;
            case R.id.chat_head /* 2131099893 */:
                HeadImageView headImageView = (HeadImageView) view;
                String userId = headImageView.getUserId();
                String userName = headImageView.getUserName();
                if (userId != null && userId.length() > 0) {
                    PersonInfoActivity.a(this.a, userId, userName);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
