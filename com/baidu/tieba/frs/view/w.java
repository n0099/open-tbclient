package com.baidu.tieba.frs.view;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    private final /* synthetic */ PopupWindow aIU;
    final /* synthetic */ o aJb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(o oVar, PopupWindow popupWindow) {
        this.aJb = oVar;
        this.aIU = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        this.aIU.dismiss();
        tbPageContext = this.aJb.mContext;
        String string = tbPageContext.getResources().getString(com.baidu.tieba.z.experion_speed);
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext2 = this.aJb.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(tbPageContext2.getPageActivity(), string, String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, false, true, true)));
    }
}
