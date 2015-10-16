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
    final /* synthetic */ dc aYl;
    private final /* synthetic */ com.baidu.tbadk.core.data.r aYn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(dc dcVar, com.baidu.tbadk.core.data.r rVar) {
        this.aYl = dcVar;
        this.aYn = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.r rVar = (com.baidu.tbadk.core.data.r) view.getTag(i.f.tag_first);
        int intValue = ((Integer) view.getTag(i.f.tag_second)).intValue();
        BaseActivity<?> baseActivity = this.aYl.aSe;
        context = this.aYl.mContext;
        baseActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(context).createConfig(this.aYn.rU(), intValue, this.aYn.rQ(), "", "", true, rVar.rU().get(this.aYn.rU().size() - 1), true)));
    }
}
