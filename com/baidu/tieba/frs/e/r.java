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
    private final /* synthetic */ TbPageContext Qj;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.n coX;
    private final /* synthetic */ PluginNetConfigInfos.PluginConfig coY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.n nVar, PluginNetConfigInfos.PluginConfig pluginConfig) {
        this.Qj = tbPageContext;
        this.coX = nVar;
        this.coY = pluginConfig;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        q.a aVar2;
        q.a aVar3;
        q.a aVar4;
        q.a aVar5;
        aVar.dismiss();
        q.p(this.Qj);
        aVar2 = q.coW;
        if (aVar2 == null) {
            q.coW = new q.a(null);
        }
        aVar3 = q.coW;
        aVar3.c(this.coX, this.Qj);
        if (PluginPackageManager.jw().bm(XiaoyingUtil.PKG_NAME_VIDEO)) {
            PluginPackageManager jw = PluginPackageManager.jw();
            aVar5 = q.coW;
            jw.a(aVar5);
            return;
        }
        PluginPackageManager jw2 = PluginPackageManager.jw();
        PluginNetConfigInfos.PluginConfig pluginConfig = this.coY;
        aVar4 = q.coW;
        jw2.a(pluginConfig, aVar4);
    }
}
