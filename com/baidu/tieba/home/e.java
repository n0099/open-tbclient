package com.baidu.tieba.home;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ CreateBarGuideActivity aOq;
    private final /* synthetic */ String aOr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CreateBarGuideActivity createBarGuideActivity, String str) {
        this.aOq = createBarGuideActivity;
        this.aOr = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aOq.sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.aOq.getPageContext().getPageActivity(), this.aOr, true)));
        this.aOq.finish();
    }
}
