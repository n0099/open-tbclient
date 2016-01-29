package com.baidu.tieba.frs.c;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.fj;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f<FrsActivity> implements BdSwitchView.a {
    private final View.OnClickListener bgj;
    private FrsActivity bot;
    private SlidingMenu bpP;
    private fj bpQ;
    private final SlidingMenu.OnClosedListener bpR;

    public l(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bpP = null;
        this.bpQ = null;
        this.bgj = new m(this);
        this.bpR = new n(this);
        this.bot = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bpQ != null) {
            this.bpQ.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.bpQ != null) {
            this.bpQ.destroy();
        }
    }

    public boolean onBackPressed() {
        if (Si().isMenuShowing()) {
            Si().toggle(true);
            if (Sh().QG()) {
                Sh().cx(false);
                this.bot.refresh();
                return true;
            }
            return true;
        }
        return false;
    }

    public void Sg() {
        if (Si().isMenuShowing()) {
            Si().toggle(true);
        }
    }

    public fj Sh() {
        if (this.bpQ == null) {
            this.bpQ = new fj(this.bot.getPageContext());
            Si().setMenu(this.bpQ.getView());
            this.bpQ.setCommonClickListener(this.bgj);
            this.bpQ.init();
            this.bpQ.QF().setOnSwitchStateChangeListener(this);
        }
        this.bpQ.changeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return this.bpQ;
    }

    public SlidingMenu Si() {
        if (this.bpP == null) {
            this.bpP = new SlidingMenu(getPageContext().getPageActivity());
            this.bpP.setBackgroundColor(getPageContext().getResources().getColor(17170444));
            this.bpP.setMode(1);
            this.bpP.setTouchModeAbove(1);
            this.bpP.setBehindOffset((int) (com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity()) * 0.3d));
            this.bpP.setBehindScrollScale(0.5f);
            this.bpP.setFadeDegree(0.35f);
            this.bpP.attachToActivity(getPageContext().getPageActivity(), 1, true);
            this.bpP.setOnClosedListener(this.bpR);
        }
        return this.bpP;
    }

    public void showMenu(boolean z) {
        Si().showMenu(z);
    }

    public void cB(boolean z) {
        Sh().cw(z);
    }

    public void setIsManager(boolean z) {
        Sh().setIsManager(z);
    }

    public void a(eb ebVar) {
        if (this.bpQ != null) {
            Sh().a(ebVar, FrsActivityStatic.bgS);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        int i = 1;
        if (view == Sh().QF()) {
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
            this.bot.onChangeSkinType(i);
            BitmapHelper.clearCashBitmap();
        }
    }
}
