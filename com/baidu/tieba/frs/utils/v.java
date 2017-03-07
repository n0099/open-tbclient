package com.baidu.tieba.frs.utils;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.frs.utils.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements a.b {
    private final /* synthetic */ TbPageContext QR;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.n cbP;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig cbQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.n nVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.QR = tbPageContext;
        this.cbP = nVar;
        this.cbQ = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        u.a aVar2;
        u.a aVar3;
        u.a aVar4;
        u.a aVar5;
        aVar.dismiss();
        u.r(this.QR);
        aVar2 = u.cbO;
        if (aVar2 == null) {
            u.cbO = new u.a(null);
        }
        aVar3 = u.cbO;
        aVar3.d(this.cbP, this.QR);
        if (PluginPackageManager.jt().bm(XiaoyingUtil.PKG_NAME_VIDEO)) {
            PluginPackageManager jt = PluginPackageManager.jt();
            aVar5 = u.cbO;
            jt.a(aVar5);
            return;
        }
        PluginPackageManager jt2 = PluginPackageManager.jt();
        PluginNetConfigInfos.PluginConfig pluginConfig = this.cbQ;
        aVar4 = u.cbO;
        jt2.a(pluginConfig, aVar4);
    }
}
