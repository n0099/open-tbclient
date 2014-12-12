package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ o aHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.aHR = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        String str2;
        str = this.aHR.aHC;
        if (!TextUtils.isEmpty(str)) {
            MessageManager messageManager = MessageManager.getInstance();
            tbPageContext = this.aHR.mContext;
            Activity pageActivity = tbPageContext.getPageActivity();
            tbPageContext2 = this.aHR.mContext;
            String string = tbPageContext2.getString(com.baidu.tieba.z.frs_badge_intro);
            str2 = this.aHR.aHC;
            messageManager.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(pageActivity, string, str2, true, true, false, false, false)));
        }
    }
}
