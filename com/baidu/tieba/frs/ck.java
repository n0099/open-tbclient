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
    final /* synthetic */ ch bGh;
    private final /* synthetic */ com.baidu.tbadk.core.data.ao bGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(ch chVar, com.baidu.tbadk.core.data.ao aoVar) {
        this.bGh = chVar;
        this.bGj = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.ao aoVar = (com.baidu.tbadk.core.data.ao) view.getTag(u.g.tag_first);
        int intValue = ((Integer) view.getTag(u.g.tag_second)).intValue();
        BaseActivity<?> baseActivity = this.bGh.bkc;
        context = this.bGh.mContext;
        baseActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(context).createConfig(this.bGj.pT(), intValue, this.bGj.pP(), "", "", true, aoVar.pT().get(this.bGj.pT().size() - 1), true)));
    }
}
