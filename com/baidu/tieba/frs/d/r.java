package com.baidu.tieba.frs.d;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.frs.d.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    private final /* synthetic */ TbPageContext QC;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.n cav;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig caw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.n nVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.QC = tbPageContext;
        this.cav = nVar;
        this.caw = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        q.a aVar2;
        q.a aVar3;
        q.a aVar4;
        q.a aVar5;
        aVar.dismiss();
        q.q(this.QC);
        aVar2 = q.cau;
        if (aVar2 == null) {
            q.cau = new q.a(null);
        }
        aVar3 = q.cau;
        aVar3.c(this.cav, this.QC);
        if (PluginPackageManager.jx().bh(XiaoyingUtil.PKG_NAME_VIDEO)) {
            PluginPackageManager jx = PluginPackageManager.jx();
            aVar5 = q.cau;
            jx.a(aVar5);
            return;
        }
        PluginPackageManager jx2 = PluginPackageManager.jx();
        PluginNetConfigInfos.PluginConfig pluginConfig = this.caw;
        aVar4 = q.cau;
        jx2.a(pluginConfig, aVar4);
    }
}
