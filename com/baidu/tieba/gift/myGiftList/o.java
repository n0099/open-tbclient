package com.baidu.tieba.gift.myGiftList;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ m bof;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.bof = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        MyGiftListActivity myGiftListActivity;
        String str2;
        String str3;
        MyGiftListActivity myGiftListActivity2;
        MyGiftListActivity myGiftListActivity3;
        str = this.bof.bnY;
        if (as.isEmpty(str)) {
            myGiftListActivity2 = this.bof.bnF;
            Activity pageActivity = myGiftListActivity2.getPageContext().getPageActivity();
            myGiftListActivity3 = this.bof.bnF;
            UtilHelper.showToast(pageActivity, myGiftListActivity3.getResources().getString(i.h.error_unkown_try_again));
            return;
        }
        myGiftListActivity = this.bof.bnF;
        Activity pageActivity2 = myGiftListActivity.getPageContext().getPageActivity();
        str2 = this.bof.bnZ;
        str3 = this.bof.bnY;
        com.baidu.tbadk.browser.g.a(pageActivity2, str2, str3, true, true, true);
    }
}
