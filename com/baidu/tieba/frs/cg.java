package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements View.OnClickListener {
    final /* synthetic */ cd bSC;
    private final /* synthetic */ com.baidu.tbadk.core.data.ax bSE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(cd cdVar, com.baidu.tbadk.core.data.ax axVar) {
        this.bSC = cdVar;
        this.bSE = axVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.ax axVar = (com.baidu.tbadk.core.data.ax) view.getTag(r.g.tag_first);
        int intValue = ((Integer) view.getTag(r.g.tag_second)).intValue();
        BaseActivity<?> baseActivity = this.bSC.aRd;
        context = this.bSC.mContext;
        baseActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(context).createConfig(this.bSE.qR(), intValue, this.bSE.qN(), "", "", true, axVar.qR().get(this.bSE.qR().size() - 1), true)));
    }
}
