package com.baidu.tieba.frs.h;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a cec;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cec = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        bl blVar6;
        com.baidu.tieba.frs.g.b afl = com.baidu.tieba.frs.g.b.afl();
        com.baidu.tieba.frs.g.a aVar = a.cdl;
        biVar = this.cec.aLV;
        afl.a(aVar, biVar, 1);
        TiebaStatic.log("c11150");
        v aJ = this.cec.aJ(((Integer) view.getTag()).intValue());
        if (aJ != null && (aJ instanceof bi)) {
            this.cec.cdZ = ((bi) aJ).ry();
            baseActivity = this.cec.aRd;
            if (k.f(baseActivity.getPageContext())) {
                baseActivity2 = this.cec.aRd;
                ThActivityDetailActivityConfig thActivityDetailActivityConfig = new ThActivityDetailActivityConfig(baseActivity2.getBaseContext());
                blVar = this.cec.cdZ;
                String l = Long.toString(blVar.getActivityId());
                blVar2 = this.cec.cdZ;
                String activityName = blVar2.getActivityName();
                blVar3 = this.cec.cdZ;
                int startTime = blVar3.getStartTime();
                blVar4 = this.cec.cdZ;
                int sO = blVar4.sO();
                blVar5 = this.cec.cdZ;
                String location = blVar5.getLocation();
                blVar6 = this.cec.cdZ;
                thActivityDetailActivityConfig.createActivityDetailConfig(l, activityName, startTime, sO, location, blVar6.sP(), ThActivityDetailActivityConfig.TH_FROM_FRS);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thActivityDetailActivityConfig));
            }
        }
    }
}
