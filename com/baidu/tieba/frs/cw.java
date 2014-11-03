package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements View.OnClickListener {
    final /* synthetic */ ct aDZ;
    private final /* synthetic */ com.baidu.tbadk.core.data.o aEa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(ct ctVar, com.baidu.tbadk.core.data.o oVar) {
        this.aDZ = ctVar;
        this.aEa = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.o oVar = (com.baidu.tbadk.core.data.o) view.getTag(com.baidu.tieba.v.tag_first);
        int intValue = ((Integer) view.getTag(com.baidu.tieba.v.tag_second)).intValue();
        FrsActivity frsActivity = this.aDZ.aBz;
        context = this.aDZ.mContext;
        frsActivity.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(context).createConfig(this.aEa.ko(), intValue, this.aEa.kk(), "", "", true, oVar.ko().get(this.aEa.ko().size() - 1), true)));
    }
}
