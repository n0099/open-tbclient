package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements View.OnClickListener {
    final /* synthetic */ cb aMt;
    private final /* synthetic */ com.baidu.tbadk.core.data.s aMv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cb cbVar, com.baidu.tbadk.core.data.s sVar) {
        this.aMt = cbVar;
        this.aMv = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.s sVar = (com.baidu.tbadk.core.data.s) view.getTag(com.baidu.tieba.v.tag_first);
        int intValue = ((Integer) view.getTag(com.baidu.tieba.v.tag_second)).intValue();
        FrsActivity frsActivity = this.aMt.aJT;
        context = this.aMt.mContext;
        frsActivity.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(context).createConfig(this.aMv.qs(), intValue, this.aMv.qo(), "", "", true, sVar.qs().get(this.aMv.qs().size() - 1), true)));
    }
}
