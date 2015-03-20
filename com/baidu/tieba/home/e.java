package com.baidu.tieba.home;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ CreateBarGuideActivity aVT;
    private final /* synthetic */ String aVU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CreateBarGuideActivity createBarGuideActivity, String str) {
        this.aVT = createBarGuideActivity;
        this.aVU = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aVT.sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.aVT.getPageContext().getPageActivity(), this.aVU, true)));
        this.aVT.finish();
    }
}
