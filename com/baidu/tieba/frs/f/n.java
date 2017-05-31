package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.WriteUrlActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ i chJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar) {
        this.chJ = iVar;
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
        com.baidu.tieba.frs.r rVar10;
        com.baidu.tieba.frs.r rVar11;
        com.baidu.tieba.frs.r rVar12;
        com.baidu.tieba.frs.r rVar13;
        rVar = this.chJ.bVm;
        if (rVar != null) {
            rVar2 = this.chJ.bVm;
            if (bh.aN(rVar2.getPageContext().getPageActivity())) {
                if (!this.chJ.chq.ha(1) && this.chJ.chD != null) {
                    this.chJ.chD.setVisibility(8);
                }
                if (view == this.chJ.chs) {
                    TiebaStatic.log(new as("c12052").Z("obj_locate", "2"));
                    boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
                    boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class);
                    if (this.chJ.chq.ha(1)) {
                        this.chJ.a(false, showXiaoyingTool, false, appResponseToIntentClass);
                        this.chJ.chq.SJ();
                        if (appResponseToIntentClass) {
                            this.chJ.ex(appResponseToIntentClass);
                        }
                        TiebaStatic.log("c11837");
                    } else if (this.chJ.chq.ha(3)) {
                        if (this.chJ.chD != null) {
                            this.chJ.chD.setVisibility(8);
                        }
                        this.chJ.chq.SK();
                    }
                } else if (view == this.chJ.cht) {
                    if (!this.chJ.adU()) {
                        rVar11 = this.chJ.bVm;
                        com.baidu.tieba.tbadkCore.n aau = rVar11.aau();
                        rVar12 = this.chJ.bVm;
                        TbPageContext<BaseFragmentActivity> pageContext = rVar12.getPageContext();
                        rVar13 = this.chJ.bVm;
                        com.baidu.tieba.frs.e.q.a(aau, pageContext, rVar13.ZY());
                    }
                } else if (view == this.chJ.chu) {
                    rVar9 = this.chJ.bVm;
                    com.baidu.tieba.tbadkCore.n aau2 = rVar9.aau();
                    rVar10 = this.chJ.bVm;
                    com.baidu.tieba.frs.e.q.b(aau2, rVar10.getPageContext());
                    this.chJ.chq.SK();
                } else if (view == this.chJ.chv) {
                    TiebaStatic.log(new as("c11839").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    rVar7 = this.chJ.bVm;
                    com.baidu.tieba.tbadkCore.n aau3 = rVar7.aau();
                    rVar8 = this.chJ.bVm;
                    com.baidu.tieba.frs.e.q.a(aau3, rVar8.getPageContext());
                } else if (view == this.chJ.chw && !this.chJ.adU()) {
                    rVar3 = this.chJ.bVm;
                    if (rVar3.aau() != null) {
                        rVar4 = this.chJ.bVm;
                        if (rVar4.aau().aIz() != null) {
                            rVar5 = this.chJ.bVm;
                            ForumData aIz = rVar5.aau().aIz();
                            rVar6 = this.chJ.bVm;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteUrlActivityConfig(rVar6.getPageContext().getPageActivity(), aIz.getId(), aIz.getName(), "2")));
                            TiebaStatic.log(new as("c12162").Z("obj_locate", "2"));
                        }
                    }
                }
            }
        }
    }
}
