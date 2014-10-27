package com.baidu.tieba.game;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class t implements AdapterView.OnItemClickListener {
    final /* synthetic */ s aHl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.aHl = sVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        u uVar;
        uVar = this.aHl.aHj;
        UserData item = uVar.getItem(i);
        if (item != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.aHl.getActivity(), item.getUserId(), item.getUserName())));
        }
    }
}
