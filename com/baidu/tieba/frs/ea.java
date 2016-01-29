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
public class ea implements View.OnClickListener {
    final /* synthetic */ dx blc;
    private final /* synthetic */ com.baidu.tbadk.core.data.y ble;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(dx dxVar, com.baidu.tbadk.core.data.y yVar) {
        this.blc = dxVar;
        this.ble = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) view.getTag(t.g.tag_first);
        int intValue = ((Integer) view.getTag(t.g.tag_second)).intValue();
        BaseActivity<?> baseActivity = this.blc.bdK;
        context = this.blc.mContext;
        baseActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(context).createConfig(this.ble.sG(), intValue, this.ble.sC(), "", "", true, yVar.sG().get(this.ble.sG().size() - 1), true)));
    }
}
