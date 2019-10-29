package com.baidu.tieba.ad.browser.newstyle;

import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes3.dex */
class e {
    private final TbPageContext<?> mTbPageContext;

    public e(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @JavascriptInterface
    public void closePage(String str) {
        if (!aq.isEmpty(str)) {
            Toast.makeText(this.mTbPageContext.getPageActivity(), str, 0).show();
        }
        this.mTbPageContext.getPageActivity().finish();
    }

    @JavascriptInterface
    public void jumpToLogin(int i) {
        TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mTbPageContext.getPageActivity())));
    }

    @JavascriptInterface
    public void showShareDialog(String str, String str2, String str3, String str4) {
        com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
        eVar.title = str;
        eVar.content = str2;
        eVar.linkUrl = str4;
        if (!aq.isEmpty(str3)) {
            eVar.imageUri = Uri.parse(str3);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig(this.mTbPageContext.getPageActivity(), eVar, true)));
    }

    @JavascriptInterface
    public void payWithDQ(String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(this.mTbPageContext.getPageActivity(), DealIntentService.class);
        intent.putExtra(DealIntentService.KEY_CLASS, 15);
        intent.putExtra("pay_type", str);
        intent.putExtra("props_id", str2);
        intent.putExtra("quan_num", str3);
        intent.putExtra("is_left", str4);
        intent.putExtra("props_mon", str5);
        com.baidu.adp.lib.g.f.startService(this.mTbPageContext.getPageActivity(), intent);
    }
}
