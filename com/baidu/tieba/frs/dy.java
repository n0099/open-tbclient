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
public class dy implements View.OnClickListener {
    final /* synthetic */ dv blu;
    private final /* synthetic */ com.baidu.tbadk.core.data.am blw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(dv dvVar, com.baidu.tbadk.core.data.am amVar) {
        this.blu = dvVar;
        this.blw = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.am amVar = (com.baidu.tbadk.core.data.am) view.getTag(t.g.tag_first);
        int intValue = ((Integer) view.getTag(t.g.tag_second)).intValue();
        BaseActivity<?> baseActivity = this.blu.bek;
        context = this.blu.mContext;
        baseActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(context).createConfig(this.blw.pZ(), intValue, this.blw.pV(), "", "", true, amVar.pZ().get(this.blw.pZ().size() - 1), true)));
    }
}
