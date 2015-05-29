package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements View.OnClickListener {
    final /* synthetic */ ca aOO;
    private final /* synthetic */ com.baidu.tbadk.core.data.s aOQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(ca caVar, com.baidu.tbadk.core.data.s sVar) {
        this.aOO = caVar;
        this.aOQ = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.s sVar = (com.baidu.tbadk.core.data.s) view.getTag(com.baidu.tieba.q.tag_first);
        int intValue = ((Integer) view.getTag(com.baidu.tieba.q.tag_second)).intValue();
        FrsActivity frsActivity = this.aOO.aMk;
        context = this.aOO.mContext;
        frsActivity.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(context).createConfig(this.aOQ.qY(), intValue, this.aOQ.qU(), "", "", true, sVar.qY().get(this.aOQ.qY().size() - 1), true)));
    }
}
