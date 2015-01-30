package com.baidu.tieba.im.mygroup;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddGroupActivityConfig;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity bkz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonGroupActivity personGroupActivity) {
        this.bkz = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bkz.sendMessage(new CustomMessage(2002001, new AddGroupActivityConfig(this.bkz.getPageContext().getPageActivity())));
    }
}
