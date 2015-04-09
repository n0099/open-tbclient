package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ ItemHotThreadView bdx;
    private final /* synthetic */ String bdy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ItemHotThreadView itemHotThreadView, String str) {
        this.bdx = itemHotThreadView;
        this.bdy = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.bdx.mContext;
        TiebaStatic.eventStat(context, "detail_hot_thread", "click", 1, new Object[0]);
        MessageManager messageManager = MessageManager.getInstance();
        context2 = this.bdx.mContext;
        messageManager.sendMessage(new CustomMessage(2004001, new PbActivityConfig(context2).createNormalCfg(this.bdy, "", "")));
    }
}
