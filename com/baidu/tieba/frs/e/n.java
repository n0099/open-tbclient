package com.baidu.tieba.frs.e;

import android.view.View;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ i cbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar) {
        this.cbx = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        com.baidu.tieba.frs.r rVar3;
        com.baidu.tieba.frs.r rVar4;
        com.baidu.tieba.frs.r rVar5;
        com.baidu.tieba.frs.r rVar6;
        com.baidu.tieba.frs.r rVar7;
        com.baidu.tieba.frs.r rVar8;
        com.baidu.tieba.frs.r rVar9;
        rVar = this.cbx.bPw;
        if (rVar != null) {
            rVar2 = this.cbx.bPw;
            if (bg.aN(rVar2.getPageContext().getPageActivity())) {
                if (!this.cbx.cbf.gJ(1) && this.cbx.cbr != null) {
                    this.cbx.cbr.setVisibility(8);
                }
                if (view == this.cbx.cbh) {
                    TiebaStatic.log(new as("c12052").aa("obj_locate", "2"));
                    boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
                    boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class);
                    if (this.cbx.cbf.gJ(1)) {
                        this.cbx.a(false, showXiaoyingTool, false, appResponseToIntentClass);
                        this.cbx.cbf.Sx();
                        if (appResponseToIntentClass) {
                            this.cbx.eh(appResponseToIntentClass);
                        }
                        TiebaStatic.log("c11837");
                    } else if (this.cbx.cbf.gJ(3)) {
                        if (this.cbx.cbr != null) {
                            this.cbx.cbr.setVisibility(8);
                        }
                        this.cbx.cbf.Sy();
                    }
                } else if (view == this.cbx.cbi) {
                    if (!this.cbx.acR()) {
                        rVar7 = this.cbx.bPw;
                        com.baidu.tieba.tbadkCore.n Zq = rVar7.Zq();
                        rVar8 = this.cbx.bPw;
                        TbPageContext<BaseFragmentActivity> pageContext = rVar8.getPageContext();
                        rVar9 = this.cbx.bPw;
                        com.baidu.tieba.frs.d.q.a(Zq, pageContext, rVar9.YU());
                    }
                } else if (view == this.cbx.cbj) {
                    rVar5 = this.cbx.bPw;
                    com.baidu.tieba.tbadkCore.n Zq2 = rVar5.Zq();
                    rVar6 = this.cbx.bPw;
                    com.baidu.tieba.frs.d.q.b(Zq2, rVar6.getPageContext());
                    this.cbx.cbf.Sy();
                } else if (view == this.cbx.cbk) {
                    TiebaStatic.log(new as("c11839").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    rVar3 = this.cbx.bPw;
                    com.baidu.tieba.tbadkCore.n Zq3 = rVar3.Zq();
                    rVar4 = this.cbx.bPw;
                    com.baidu.tieba.frs.d.q.a(Zq3, rVar4.getPageContext());
                }
            }
        }
    }
}
