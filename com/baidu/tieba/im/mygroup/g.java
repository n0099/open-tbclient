package com.baidu.tieba.im.mygroup;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddGroupActivityConfig;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity blD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonGroupActivity personGroupActivity) {
        this.blD = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.blD.sendMessage(new CustomMessage(2002001, new AddGroupActivityConfig(this.blD.getPageContext().getPageActivity())));
    }
}
