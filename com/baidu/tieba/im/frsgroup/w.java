package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AdapterView.OnItemClickListener {
    final /* synthetic */ MembersActivity aXN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MembersActivity membersActivity) {
        this.aXN = membersActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ah ahVar;
        ahVar = this.aXN.aXJ;
        ad NO = ahVar.NO();
        UserData userData = (UserData) NO.getItem(i);
        if (userData != null) {
            if (NO.NJ()) {
                if (!userData.getPermission().isController()) {
                    NO.a(Long.valueOf(userData.getUserIdLong()));
                    return;
                }
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.aXN, new StringBuilder(String.valueOf(userData.getUserId())).toString(), userData.getUserName())));
        }
    }
}
