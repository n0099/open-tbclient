package com.baidu.tieba.im.mygroup;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddGroupActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity bjc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonGroupActivity personGroupActivity) {
        this.bjc = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bjc.sendMessage(new CustomMessage(2002001, new AddGroupActivityConfig(this.bjc.getPageContext().getPageActivity())));
    }
}
