package com.baidu.tieba.im.selectfriend;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectFriendActivity bos;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SelectFriendActivity selectFriendActivity) {
        this.bos = selectFriendActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        CustomMessageListener customMessageListener;
        CustomMessageListener customMessageListener2;
        com.baidu.tbadk.coreExtra.relationship.b item = this.bos.bop.getItem(i);
        if (item != null) {
            long userId = item.getUserId();
            String userName = item.getUserName();
            String userPortrait = item.getUserPortrait();
            i2 = this.bos.boo;
            if (i2 == 0) {
                customMessageListener = this.bos.boq;
                if (customMessageListener == null) {
                    this.bos.boq = new c(this, 2001268, userId, userName, userPortrait);
                    SelectFriendActivity selectFriendActivity = this.bos;
                    customMessageListener2 = this.bos.boq;
                    selectFriendActivity.registerListener(customMessageListener2);
                }
                this.bos.sendMessage(new CustomMessage(2001268));
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_user_id", userId);
            intent.putExtra("key_user_name", userName);
            intent.putExtra("key_user_portait", userPortrait);
            this.bos.setResult(-1, intent);
            this.bos.finish();
        }
    }
}
