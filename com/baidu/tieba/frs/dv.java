package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dv implements View.OnClickListener {
    final /* synthetic */ ds bim;
    private final /* synthetic */ com.baidu.tbadk.core.data.u bio;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(ds dsVar, com.baidu.tbadk.core.data.u uVar) {
        this.bim = dsVar;
        this.bio = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.u uVar = (com.baidu.tbadk.core.data.u) view.getTag(n.g.tag_first);
        int intValue = ((Integer) view.getTag(n.g.tag_second)).intValue();
        BaseActivity<?> baseActivity = this.bim.bbA;
        context = this.bim.mContext;
        baseActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(context).createConfig(this.bio.rZ(), intValue, this.bio.rV(), "", "", true, uVar.rZ().get(this.bio.rZ().size() - 1), true)));
    }
}
