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
import com.baidu.tieba.frs.ef;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.f<FrsActivity> implements BdSwitchView.a {
    private final View.OnClickListener aUm;
    private FrsActivity baG;
    private SlidingMenu bbO;
    private ef bbP;
    private final SlidingMenu.OnClosedListener bbQ;

    public k(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bbO = null;
        this.bbP = null;
        this.aUm = new l(this);
        this.bbQ = new m(this);
        this.baG = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bbP != null) {
            this.bbP.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.bbP != null) {
            this.bbP.destroy();
        }
    }

    public boolean onBackPressed() {
        if (NO().isMenuShowing()) {
            NO().toggle(true);
            if (NN().MB()) {
                NN().ch(false);
                this.baG.refresh();
                return true;
            }
            return true;
        }
        return false;
    }

    public void NM() {
        if (NO().isMenuShowing()) {
            NO().toggle(true);
        }
    }

    public ef NN() {
        if (this.bbP == null) {
            this.bbP = new ef(this.baG.getPageContext());
            NO().setMenu(this.bbP.getView());
            this.bbP.setCommonClickListener(this.aUm);
            this.bbP.init();
            this.bbP.MA().setOnSwitchStateChangeListener(this);
        }
        this.bbP.changeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return this.bbP;
    }

    public SlidingMenu NO() {
        if (this.bbO == null) {
            this.bbO = new SlidingMenu(getPageContext().getPageActivity());
            this.bbO.setBackgroundColor(getPageContext().getResources().getColor(17170444));
            this.bbO.setMode(1);
            this.bbO.setTouchModeAbove(1);
            this.bbO.setBehindOffset((int) (com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity()) * 0.3d));
            this.bbO.setBehindScrollScale(0.5f);
            this.bbO.setFadeDegree(0.35f);
            this.bbO.attachToActivity(getPageContext().getPageActivity(), 1, true);
            this.bbO.setOnClosedListener(this.bbQ);
        }
        return this.bbO;
    }

    public void showMenu(boolean z) {
        NO().showMenu(z);
    }

    public void cl(boolean z) {
        NN().cg(z);
    }

    public void setIsManager(boolean z) {
        NN().setIsManager(z);
    }

    public void a(dg dgVar) {
        if (this.bbP != null) {
            NN().a(dgVar, FrsActivityStatic.aUQ, FrsActivityStatic.aUR);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        int i = 1;
        if (view == NN().MA()) {
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
            this.baG.onChangeSkinType(i);
            com.baidu.tbadk.core.util.c.iv();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        }
    }
}
