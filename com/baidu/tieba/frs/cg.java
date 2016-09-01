package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements View.OnClickListener {
    final /* synthetic */ cd bSJ;
    private final /* synthetic */ com.baidu.tbadk.core.data.av bSL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(cd cdVar, com.baidu.tbadk.core.data.av avVar) {
        this.bSJ = cdVar;
        this.bSL = avVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.av avVar = (com.baidu.tbadk.core.data.av) view.getTag(t.g.tag_first);
        int intValue = ((Integer) view.getTag(t.g.tag_second)).intValue();
        BaseActivity<?> baseActivity = this.bSJ.aPR;
        context = this.bSJ.mContext;
        baseActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(context).createConfig(this.bSL.qG(), intValue, this.bSL.qC(), "", "", true, avVar.qG().get(this.bSL.qG().size() - 1), true)));
    }
}
