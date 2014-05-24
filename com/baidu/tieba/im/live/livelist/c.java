package com.baidu.tieba.im.live.livelist;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.at;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements AdapterView.OnItemClickListener {
    final /* synthetic */ BlackMembersListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BlackMembersListActivity blackMembersListActivity) {
        this.a = blackMembersListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        i iVar;
        i iVar2;
        iVar = this.a.a;
        if (!iVar.e().b()) {
            iVar2 = this.a.a;
            Object item = iVar2.e().getItem(i);
            if (item instanceof UserData) {
                UserData userData = (UserData) item;
                MessageManager.getInstance().sendMessage(new CustomMessage(2003003, new at(this.a, userData.getUserId(), userData.getUserName())));
            }
        }
    }
}
