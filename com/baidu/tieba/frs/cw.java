package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements View.OnClickListener {
    final /* synthetic */ ct aDP;
    private final /* synthetic */ com.baidu.tbadk.core.data.o aDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(ct ctVar, com.baidu.tbadk.core.data.o oVar) {
        this.aDP = ctVar;
        this.aDQ = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.o oVar = (com.baidu.tbadk.core.data.o) view.getTag(com.baidu.tieba.v.tag_first);
        int intValue = ((Integer) view.getTag(com.baidu.tieba.v.tag_second)).intValue();
        FrsActivity frsActivity = this.aDP.aBp;
        context = this.aDP.mContext;
        frsActivity.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(context).createConfig(this.aDQ.ko(), intValue, this.aDQ.kk(), "", "", true, oVar.ko().get(this.aDQ.ko().size() - 1), true)));
    }
}
