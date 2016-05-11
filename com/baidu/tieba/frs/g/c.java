package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a btu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.btu = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        ay ayVar;
        ay ayVar2;
        ay ayVar3;
        ay ayVar4;
        ay ayVar5;
        ay ayVar6;
        TiebaStatic.log("c11150");
        v at = this.btu.at(((Integer) view.getTag()).intValue());
        if (at != null && (at instanceof ax)) {
            this.btu.bts = ((ax) at).qG();
            baseActivity = this.btu.bek;
            if (com.baidu.tbadk.plugins.d.f(baseActivity.getPageContext())) {
                baseActivity2 = this.btu.bek;
                ThActivityDetailActivityConfig thActivityDetailActivityConfig = new ThActivityDetailActivityConfig(baseActivity2.getBaseContext());
                ayVar = this.btu.bts;
                String l = Long.toString(ayVar.getActivityId());
                ayVar2 = this.btu.bts;
                String activityName = ayVar2.getActivityName();
                ayVar3 = this.btu.bts;
                int startTime = ayVar3.getStartTime();
                ayVar4 = this.btu.bts;
                int rw = ayVar4.rw();
                ayVar5 = this.btu.bts;
                String location = ayVar5.getLocation();
                ayVar6 = this.btu.bts;
                thActivityDetailActivityConfig.createActivityDetailConfig(l, activityName, startTime, rw, location, ayVar6.rx(), ThActivityDetailActivityConfig.TH_FROM_FRS);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thActivityDetailActivityConfig));
            }
        }
    }
}
