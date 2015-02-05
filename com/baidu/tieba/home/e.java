package com.baidu.tieba.home;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ CreateBarGuideActivity aPy;
    private final /* synthetic */ String aPz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CreateBarGuideActivity createBarGuideActivity, String str) {
        this.aPy = createBarGuideActivity;
        this.aPz = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aPy.sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.aPy.getPageContext().getPageActivity(), this.aPz, true)));
        this.aPy.finish();
    }
}
