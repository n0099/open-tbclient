package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.as;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsPraiseView frsPraiseView) {
        this.a = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PraiseData praiseData;
        Context context;
        praiseData = this.a.f;
        MetaData metaData = praiseData.getUser().get(1);
        if (metaData != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.a.a;
            messageManager.sendMessage(new CustomMessage(2003003, new as(context, metaData.getUserId(), metaData.getName_show())));
        }
    }
}
