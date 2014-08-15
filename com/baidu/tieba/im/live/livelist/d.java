package com.baidu.tieba.im.live.livelist;

import android.widget.Button;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements h {
    final /* synthetic */ BlackMembersListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BlackMembersListActivity blackMembersListActivity) {
        this.a = blackMembersListActivity;
    }

    @Override // com.baidu.tieba.im.live.livelist.h
    public void a(Button button) {
        com.baidu.tieba.im.model.q qVar;
        com.baidu.tieba.im.model.q qVar2;
        Object tag = button.getTag();
        if (tag instanceof UserData) {
            UserData userData = (UserData) tag;
            this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.x.group_tab_enterchatroom_loading), null);
            qVar = this.a.b;
            qVar2 = this.a.b;
            qVar.a(qVar2.b(), 2, new String[]{userData.getUserId()}, new String[]{userData.getUserName()});
        }
    }
}
