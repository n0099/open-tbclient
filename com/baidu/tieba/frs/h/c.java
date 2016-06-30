package com.baidu.tieba.frs.h;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bQY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bQY = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        ba baVar;
        ba baVar2;
        ba baVar3;
        ba baVar4;
        ba baVar5;
        ba baVar6;
        TiebaStatic.log("c11150");
        v at = this.bQY.at(((Integer) view.getTag()).intValue());
        if (at != null && (at instanceof az)) {
            this.bQY.bQW = ((az) at).qz();
            baseActivity = this.bQY.bkc;
            if (com.baidu.tbadk.plugins.d.f(baseActivity.getPageContext())) {
                baseActivity2 = this.bQY.bkc;
                ThActivityDetailActivityConfig thActivityDetailActivityConfig = new ThActivityDetailActivityConfig(baseActivity2.getBaseContext());
                baVar = this.bQY.bQW;
                String l = Long.toString(baVar.getActivityId());
                baVar2 = this.bQY.bQW;
                String activityName = baVar2.getActivityName();
                baVar3 = this.bQY.bQW;
                int startTime = baVar3.getStartTime();
                baVar4 = this.bQY.bQW;
                int rv = baVar4.rv();
                baVar5 = this.bQY.bQW;
                String location = baVar5.getLocation();
                baVar6 = this.bQY.bQW;
                thActivityDetailActivityConfig.createActivityDetailConfig(l, activityName, startTime, rv, location, baVar6.rw(), ThActivityDetailActivityConfig.TH_FROM_FRS);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thActivityDetailActivityConfig));
            }
        }
    }
}
