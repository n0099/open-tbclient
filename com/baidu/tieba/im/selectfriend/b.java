package com.baidu.tieba.im.selectfriend;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
/* loaded from: classes.dex */
class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectFriendActivity biu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SelectFriendActivity selectFriendActivity) {
        this.biu = selectFriendActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        com.baidu.tbadk.coreExtra.relationship.b item = this.biu.bis.getItem(i);
        if (item != null) {
            long userId = item.getUserId();
            String userName = item.getUserName();
            String userPortrait = item.getUserPortrait();
            i2 = this.biu.bir;
            if (i2 == 0) {
                this.biu.a(com.baidu.tbadk.game.b.rU().rW(), userId, userName, userPortrait);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, userId);
            intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, userName);
            intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, userPortrait);
            this.biu.setResult(-1, intent);
            this.biu.finish();
        }
    }
}
