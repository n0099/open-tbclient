package com.baidu.tieba.gift.myGiftList;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ l bxd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.bxd = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        String str;
        MyGiftListActivity myGiftListActivity;
        String str2;
        String str3;
        MyGiftListActivity myGiftListActivity2;
        MyGiftListActivity myGiftListActivity3;
        MyGiftListActivity myGiftListActivity4;
        MyGiftListActivity myGiftListActivity5;
        MyGiftListActivity myGiftListActivity6;
        if (view != null) {
            textView = this.bxd.bwW;
            if (view != textView) {
                textView2 = this.bxd.bwV;
                if (view == textView2) {
                    str = this.bxd.bwX;
                    if (ax.isEmpty(str)) {
                        myGiftListActivity2 = this.bxd.bwC;
                        Activity pageActivity = myGiftListActivity2.getPageContext().getPageActivity();
                        myGiftListActivity3 = this.bxd.bwC;
                        UtilHelper.showToast(pageActivity, myGiftListActivity3.getResources().getString(n.i.error_unkown_try_again));
                        return;
                    }
                    myGiftListActivity = this.bxd.bwC;
                    Activity pageActivity2 = myGiftListActivity.getPageContext().getPageActivity();
                    str2 = this.bxd.bwY;
                    str3 = this.bxd.bwX;
                    com.baidu.tbadk.browser.f.a(pageActivity2, str2, str3, true, true, true);
                }
            } else if (!com.baidu.adp.lib.util.k.jg()) {
                myGiftListActivity5 = this.bxd.bwC;
                Activity pageActivity3 = myGiftListActivity5.getPageContext().getPageActivity();
                myGiftListActivity6 = this.bxd.bwC;
                UtilHelper.showToast(pageActivity3, myGiftListActivity6.getResources().getString(n.i.neterror));
            } else {
                MessageManager messageManager = MessageManager.getInstance();
                myGiftListActivity4 = this.bxd.bwC;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(myGiftListActivity4.getPageContext().getPageActivity(), 0L)));
            }
        }
    }
}
