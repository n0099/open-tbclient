package com.baidu.tieba.gift.myGiftList;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.BuyGiftActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ MyGiftListActivity bnC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MyGiftListActivity myGiftListActivity) {
        this.bnC = myGiftListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        l lVar;
        z = this.bnC.mIsHost;
        if (!z) {
            lVar = this.bnC.bnw;
            long uid = lVar.getUid();
            if (uid != 0) {
                TiebaStatic.log("gift_list_btn");
                this.bnC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyGiftActivityConfig(this.bnC.getPageContext().getPageActivity(), uid)));
            }
        }
    }
}
