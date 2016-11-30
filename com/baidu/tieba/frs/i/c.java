package com.baidu.tieba.frs.i;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a cie;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cie = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        bn bnVar4;
        bn bnVar5;
        bn bnVar6;
        v aJ = this.cie.aJ(((Integer) view.getTag()).intValue());
        if (aJ != null && (aJ instanceof bk)) {
            this.cie.cia = ((bk) aJ).rA();
            baseActivity = this.cie.aTb;
            if (h.f(baseActivity.getPageContext())) {
                baseActivity2 = this.cie.aTb;
                ThActivityDetailActivityConfig thActivityDetailActivityConfig = new ThActivityDetailActivityConfig(baseActivity2.getBaseContext());
                bnVar = this.cie.cia;
                String l = Long.toString(bnVar.getActivityId());
                bnVar2 = this.cie.cia;
                String activityName = bnVar2.getActivityName();
                bnVar3 = this.cie.cia;
                int startTime = bnVar3.getStartTime();
                bnVar4 = this.cie.cia;
                int sS = bnVar4.sS();
                bnVar5 = this.cie.cia;
                String location = bnVar5.getLocation();
                bnVar6 = this.cie.cia;
                thActivityDetailActivityConfig.createActivityDetailConfig(l, activityName, startTime, sS, location, bnVar6.sT(), ThActivityDetailActivityConfig.TH_FROM_FRS);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thActivityDetailActivityConfig));
            }
            com.baidu.tieba.frs.h.b.agV().a(a.chm, (bk) aJ, 1);
            TiebaStatic.log("c11150");
        }
    }
}
