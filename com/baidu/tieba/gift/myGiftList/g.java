package com.baidu.tieba.gift.myGiftList;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ MyGiftListActivity bwy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MyGiftListActivity myGiftListActivity) {
        this.bwy = myGiftListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        j jVar;
        String str;
        z = this.bwy.mIsHost;
        if (!z) {
            jVar = this.bwy.bwr;
            long uid = jVar.getUid();
            if (uid != 0) {
                TiebaStatic.log("gift_list_btn");
                Activity pageActivity = this.bwy.getPageContext().getPageActivity();
                str = this.bwy.username;
                this.bwy.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(pageActivity, uid, str)));
            }
        }
    }
}
