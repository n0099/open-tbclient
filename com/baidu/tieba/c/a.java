package com.baidu.tieba.c;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    public static void a(Intent intent, final TbPageContext tbPageContext, final int i) {
        Uri uri;
        if (intent != null && TbadkCoreApplication.isLogin() && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("portrait");
            if (TbadkCoreApplication.getCurrentPortrait() != null && queryParameter != null && !TbadkCoreApplication.getCurrentPortrait().contains(queryParameter)) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.nx(1);
                aVar.Ad(tbPageContext.getString(R.string.account_not_the_same_as_pc));
                aVar.a(R.string.change_account, new a.b() { // from class: com.baidu.tieba.c.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(TbPageContext.this.getPageActivity(), true, i)));
                    }
                });
                aVar.b(R.string.not_change_account, new a.b() { // from class: com.baidu.tieba.c.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).bqe();
            }
        }
    }
}
