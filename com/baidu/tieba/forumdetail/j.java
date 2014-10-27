package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ ItemHotThreadView axv;
    private final /* synthetic */ String axw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ItemHotThreadView itemHotThreadView, String str) {
        this.axv = itemHotThreadView;
        this.axw = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.axv.mContext;
        TiebaStatic.eventStat(context, "detail_hot_thread", "click", 1, new Object[0]);
        MessageManager messageManager = MessageManager.getInstance();
        context2 = this.axv.mContext;
        messageManager.sendMessage(new CustomMessage(2004001, new PbActivityConfig(context2).createNormalCfg(this.axw, "", "")));
    }
}
