package com.baidu.tieba.frs.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.dg;
import com.baidu.tieba.frs.eh;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f<FrsActivity> implements BdSwitchView.a {
    private final View.OnClickListener aUF;
    private FrsActivity bbk;
    private SlidingMenu bcE;
    private eh bcF;
    private final SlidingMenu.OnClosedListener bcG;

    public l(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bcE = null;
        this.bcF = null;
        this.aUF = new m(this);
        this.bcG = new n(this);
        this.bbk = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bcF != null) {
            this.bcF.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.bcF != null) {
            this.bcF.destroy();
        }
    }

    public boolean onBackPressed() {
        if (Og().isMenuShowing()) {
            Og().toggle(true);
            if (Of().MN()) {
                Of().cj(false);
                this.bbk.refresh();
                return true;
            }
            return true;
        }
        return false;
    }

    public void Oe() {
        if (Og().isMenuShowing()) {
            Og().toggle(true);
        }
    }

    public eh Of() {
        if (this.bcF == null) {
            this.bcF = new eh(this.bbk.getPageContext());
            Og().setMenu(this.bcF.getView());
            this.bcF.setCommonClickListener(this.aUF);
            this.bcF.init();
            this.bcF.MM().setOnSwitchStateChangeListener(this);
        }
        this.bcF.changeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return this.bcF;
    }

    public SlidingMenu Og() {
        if (this.bcE == null) {
            this.bcE = new SlidingMenu(getPageContext().getPageActivity());
            this.bcE.setBackgroundColor(getPageContext().getResources().getColor(17170444));
            this.bcE.setMode(1);
            this.bcE.setTouchModeAbove(1);
            this.bcE.setBehindOffset((int) (com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity()) * 0.3d));
            this.bcE.setBehindScrollScale(0.5f);
            this.bcE.setFadeDegree(0.35f);
            this.bcE.attachToActivity(getPageContext().getPageActivity(), 1, true);
            this.bcE.setOnClosedListener(this.bcG);
        }
        return this.bcE;
    }

    public void showMenu(boolean z) {
        Og().showMenu(z);
    }

    public void cn(boolean z) {
        Of().ci(z);
    }

    public void setIsManager(boolean z) {
        Of().setIsManager(z);
    }

    public void a(dg dgVar) {
        if (this.bcF != null) {
            Of().a(dgVar, FrsActivityStatic.aVj, FrsActivityStatic.aVk);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        int i = 1;
        if (view == Of().MM()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TbadkCoreApplication.m411getInst().getSkinType() != 1) {
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_night_mode", "frsclick", 1, new Object[0]);
                    TbadkCoreApplication.m411getInst().setSkinType(1);
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                } else {
                    return;
                }
            } else if (TbadkCoreApplication.m411getInst().getSkinType() != 0) {
                TbadkCoreApplication.m411getInst().setSkinType(0);
                i = 0;
            } else {
                return;
            }
            this.bbk.onChangeSkinType(i);
            com.baidu.tbadk.core.util.c.iw();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        }
    }
}
