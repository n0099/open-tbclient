package com.baidu.tieba.frs.i;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bSW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bSW = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        be beVar;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        bf bfVar5;
        bf bfVar6;
        com.baidu.tieba.frs.h.b aam = com.baidu.tieba.frs.h.b.aam();
        com.baidu.tieba.frs.h.a aVar = a.bSh;
        beVar = this.bSW.bDO;
        aam.a(aVar, beVar, 1);
        TiebaStatic.log("c11150");
        v aw = this.bSW.aw(((Integer) view.getTag()).intValue());
        if (aw != null && (aw instanceof be)) {
            this.bSW.bSU = ((be) aw).qi();
            baseActivity = this.bSW.bem;
            if (g.f(baseActivity.getPageContext())) {
                baseActivity2 = this.bSW.bem;
                ThActivityDetailActivityConfig thActivityDetailActivityConfig = new ThActivityDetailActivityConfig(baseActivity2.getBaseContext());
                bfVar = this.bSW.bSU;
                String l = Long.toString(bfVar.getActivityId());
                bfVar2 = this.bSW.bSU;
                String activityName = bfVar2.getActivityName();
                bfVar3 = this.bSW.bSU;
                int startTime = bfVar3.getStartTime();
                bfVar4 = this.bSW.bSU;
                int ru = bfVar4.ru();
                bfVar5 = this.bSW.bSU;
                String location = bfVar5.getLocation();
                bfVar6 = this.bSW.bSU;
                thActivityDetailActivityConfig.createActivityDetailConfig(l, activityName, startTime, ru, location, bfVar6.rv(), ThActivityDetailActivityConfig.TH_FROM_FRS);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thActivityDetailActivityConfig));
            }
        }
    }
}
