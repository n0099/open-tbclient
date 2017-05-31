package com.baidu.tieba.frs.e;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.frs.e.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    private final /* synthetic */ TbPageContext Qp;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.n cgH;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig cgI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.n nVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.Qp = tbPageContext;
        this.cgH = nVar;
        this.cgI = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        q.a aVar2;
        q.a aVar3;
        q.a aVar4;
        q.a aVar5;
        aVar.dismiss();
        q.p(this.Qp);
        aVar2 = q.cgG;
        if (aVar2 == null) {
            q.cgG = new q.a(null);
        }
        aVar3 = q.cgG;
        aVar3.c(this.cgH, this.Qp);
        if (PluginPackageManager.jx().bh(XiaoyingUtil.PKG_NAME_VIDEO)) {
            PluginPackageManager jx = PluginPackageManager.jx();
            aVar5 = q.cgG;
            jx.a(aVar5);
            return;
        }
        PluginPackageManager jx2 = PluginPackageManager.jx();
        PluginNetConfigInfos.PluginConfig pluginConfig = this.cgI;
        aVar4 = q.cgG;
        jx2.a(pluginConfig, aVar4);
    }
}
