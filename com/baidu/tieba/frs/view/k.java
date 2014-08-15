package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bn;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsPraiseView frsPraiseView) {
        this.a = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PraiseData praiseData;
        Context context;
        String str;
        String str2;
        boolean z;
        PraiseData praiseData2;
        String str3 = "";
        praiseData = this.a.f;
        if (praiseData != null) {
            praiseData2 = this.a.f;
            str3 = praiseData2.getTitle();
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.a.a;
        str = this.a.g;
        str2 = this.a.h;
        z = this.a.i;
        messageManager.sendMessage(new CustomMessage(2002007, new bn(context, str, str2, str3, z)));
    }
}
