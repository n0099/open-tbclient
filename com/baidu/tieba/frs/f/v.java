package com.baidu.tieba.frs.f;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.frs.f.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements a.b {
    private final /* synthetic */ TbPageContext Rj;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.n caq;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig car;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.n nVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.Rj = tbPageContext;
        this.caq = nVar;
        this.car = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        u.a aVar2;
        u.a aVar3;
        u.a aVar4;
        u.a aVar5;
        aVar.dismiss();
        u.r(this.Rj);
        aVar2 = u.cap;
        if (aVar2 == null) {
            u.cap = new u.a(null);
        }
        aVar3 = u.cap;
        aVar3.d(this.caq, this.Rj);
        if (PluginPackageManager.jx().bh(XiaoyingUtil.PKG_NAME_VIDEO)) {
            PluginPackageManager jx = PluginPackageManager.jx();
            aVar5 = u.cap;
            jx.a(aVar5);
            return;
        }
        PluginPackageManager jx2 = PluginPackageManager.jx();
        PluginNetConfigInfos.PluginConfig pluginConfig = this.car;
        aVar4 = u.cap;
        jx2.a(pluginConfig, aVar4);
    }
}
