package com.baidu.tieba.home;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ CreateBarGuideActivity aYO;
    private final /* synthetic */ String aYP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CreateBarGuideActivity createBarGuideActivity, String str) {
        this.aYO = createBarGuideActivity;
        this.aYP = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aYO.sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.aYO.getPageContext().getPageActivity(), this.aYP, true)));
        this.aYO.finish();
    }
}
