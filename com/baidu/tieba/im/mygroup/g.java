package com.baidu.tieba.im.mygroup;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddGroupActivityConfig;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity bky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonGroupActivity personGroupActivity) {
        this.bky = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bky.sendMessage(new CustomMessage(2002001, new AddGroupActivityConfig(this.bky.getPageContext().getPageActivity())));
    }
}
