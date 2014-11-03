package com.baidu.tieba.im.group;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.CaptureActivityConfig;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.ZxingPlugin;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.b.a.a {
    final /* synthetic */ b aYH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, Context context, int i, int i2, int i3, int i4) {
        super(context, i, i2, i3, i4);
        this.aYH = bVar;
    }

    @Override // com.baidu.tbadk.b.a.a
    public void onClick() {
        Context context;
        if (((ZxingPlugin) PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_ZXING).getClassInstance(ZxingPlugin.class)) != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.aYH.mContext;
            messageManager.sendMessage(new CustomMessage(2002001, new CaptureActivityConfig((DiscoverMoreActivity) context, 16003)));
        }
    }
}
