package com.baidu.tieba.home;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final /* synthetic */ String aPA;
    final /* synthetic */ CreateBarGuideActivity aPz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CreateBarGuideActivity createBarGuideActivity, String str) {
        this.aPz = createBarGuideActivity;
        this.aPA = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aPz.sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.aPz.getPageContext().getPageActivity(), this.aPA, true)));
        this.aPz.finish();
    }
}
