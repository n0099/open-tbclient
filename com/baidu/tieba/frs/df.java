package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class df implements View.OnClickListener {
    final /* synthetic */ dc aYa;
    private final /* synthetic */ com.baidu.tbadk.core.data.q aYc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(dc dcVar, com.baidu.tbadk.core.data.q qVar) {
        this.aYa = dcVar;
        this.aYc = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.q qVar = (com.baidu.tbadk.core.data.q) view.getTag(i.f.tag_first);
        int intValue = ((Integer) view.getTag(i.f.tag_second)).intValue();
        BaseActivity<?> baseActivity = this.aYa.aRT;
        context = this.aYa.mContext;
        baseActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(context).createConfig(this.aYc.rU(), intValue, this.aYc.rQ(), "", "", true, qVar.rU().get(this.aYc.rU().size() - 1), true)));
    }
}
