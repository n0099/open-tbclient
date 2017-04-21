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
    private final /* synthetic */ TbPageContext Rl;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.n ccH;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig ccI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.n nVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.Rl = tbPageContext;
        this.ccH = nVar;
        this.ccI = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        u.a aVar2;
        u.a aVar3;
        u.a aVar4;
        u.a aVar5;
        aVar.dismiss();
        u.r(this.Rl);
        aVar2 = u.ccG;
        if (aVar2 == null) {
            u.ccG = new u.a(null);
        }
        aVar3 = u.ccG;
        aVar3.d(this.ccH, this.Rl);
        if (PluginPackageManager.jy().bh(XiaoyingUtil.PKG_NAME_VIDEO)) {
            PluginPackageManager jy = PluginPackageManager.jy();
            aVar5 = u.ccG;
            jy.a(aVar5);
            return;
        }
        PluginPackageManager jy2 = PluginPackageManager.jy();
        PluginNetConfigInfos.PluginConfig pluginConfig = this.ccI;
        aVar4 = u.ccG;
        jy2.a(pluginConfig, aVar4);
    }
}
