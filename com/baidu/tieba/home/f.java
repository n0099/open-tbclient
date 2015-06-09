package com.baidu.tieba.home;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ CreateBarGuideActivity aYP;
    private final /* synthetic */ String aYQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CreateBarGuideActivity createBarGuideActivity, String str) {
        this.aYP = createBarGuideActivity;
        this.aYQ = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aYP.sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.aYP.getPageContext().getPageActivity(), this.aYQ, true)));
        this.aYP.finish();
    }
}
