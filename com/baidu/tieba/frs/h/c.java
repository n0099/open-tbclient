package com.baidu.tieba.frs.h;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a ced;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.ced = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bj bjVar5;
        bj bjVar6;
        com.baidu.tieba.frs.g.b aeX = com.baidu.tieba.frs.g.b.aeX();
        com.baidu.tieba.frs.g.a aVar = a.cdn;
        bgVar = this.ced.bPs;
        aeX.a(aVar, bgVar, 1);
        TiebaStatic.log("c11150");
        v aJ = this.ced.aJ(((Integer) view.getTag()).intValue());
        if (aJ != null && (aJ instanceof bg)) {
            this.ced.cea = ((bg) aJ).rm();
            baseActivity = this.ced.aPR;
            if (g.f(baseActivity.getPageContext())) {
                baseActivity2 = this.ced.aPR;
                ThActivityDetailActivityConfig thActivityDetailActivityConfig = new ThActivityDetailActivityConfig(baseActivity2.getBaseContext());
                bjVar = this.ced.cea;
                String l = Long.toString(bjVar.getActivityId());
                bjVar2 = this.ced.cea;
                String activityName = bjVar2.getActivityName();
                bjVar3 = this.ced.cea;
                int startTime = bjVar3.getStartTime();
                bjVar4 = this.ced.cea;
                int sz = bjVar4.sz();
                bjVar5 = this.ced.cea;
                String location = bjVar5.getLocation();
                bjVar6 = this.ced.cea;
                thActivityDetailActivityConfig.createActivityDetailConfig(l, activityName, startTime, sz, location, bjVar6.sA(), ThActivityDetailActivityConfig.TH_FROM_FRS);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thActivityDetailActivityConfig));
            }
        }
    }
}
