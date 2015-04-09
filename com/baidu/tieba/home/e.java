package com.baidu.tieba.home;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ CreateBarGuideActivity aWj;
    private final /* synthetic */ String aWk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CreateBarGuideActivity createBarGuideActivity, String str) {
        this.aWj = createBarGuideActivity;
        this.aWk = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aWj.sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.aWj.getPageContext().getPageActivity(), this.aWk, true)));
        this.aWj.finish();
    }
}
