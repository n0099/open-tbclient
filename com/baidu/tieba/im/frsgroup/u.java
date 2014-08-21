package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bh;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements AdapterView.OnItemClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        af afVar;
        afVar = this.a.b;
        ab f = afVar.f();
        UserData userData = (UserData) f.getItem(i);
        if (userData != null) {
            if (f.d()) {
                if (!userData.getPermission().isController()) {
                    f.a(Long.valueOf(userData.getUserIdLong()));
                    return;
                }
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new bh(this.a, new StringBuilder(String.valueOf(userData.getUserId())).toString(), userData.getUserName())));
        }
    }
}
