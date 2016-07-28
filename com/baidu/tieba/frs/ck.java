package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements View.OnClickListener {
    final /* synthetic */ ch bHD;
    private final /* synthetic */ com.baidu.tbadk.core.data.at bHF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(ch chVar, com.baidu.tbadk.core.data.at atVar) {
        this.bHD = chVar;
        this.bHF = atVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.at atVar = (com.baidu.tbadk.core.data.at) view.getTag(u.g.tag_first);
        int intValue = ((Integer) view.getTag(u.g.tag_second)).intValue();
        BaseActivity<?> baseActivity = this.bHD.bem;
        context = this.bHD.mContext;
        baseActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(context).createConfig(this.bHF.pC(), intValue, this.bHF.py(), "", "", true, atVar.pC().get(this.bHF.pC().size() - 1), true)));
    }
}
