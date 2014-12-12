package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements View.OnClickListener {
    final /* synthetic */ cr aFE;
    private final /* synthetic */ com.baidu.tbadk.core.data.s aFF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cr crVar, com.baidu.tbadk.core.data.s sVar) {
        this.aFE = crVar;
        this.aFF = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.s sVar = (com.baidu.tbadk.core.data.s) view.getTag(com.baidu.tieba.w.tag_first);
        int intValue = ((Integer) view.getTag(com.baidu.tieba.w.tag_second)).intValue();
        FrsActivity frsActivity = this.aFE.aDc;
        context = this.aFE.mContext;
        frsActivity.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(context).createConfig(this.aFF.nh(), intValue, this.aFF.nd(), "", "", true, sVar.nh().get(this.aFF.nh().size() - 1), true)));
    }
}
