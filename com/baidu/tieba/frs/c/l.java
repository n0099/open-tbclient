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
import com.baidu.tieba.frs.ei;
import com.baidu.tieba.frs.fs;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f<FrsActivity> implements BdSwitchView.a {
    private final View.OnClickListener bkV;
    private FrsActivity bts;
    private SlidingMenu buQ;
    private fs buR;
    private final SlidingMenu.OnClosedListener buS;

    public l(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.buQ = null;
        this.buR = null;
        this.bkV = new m(this);
        this.buS = new n(this);
        this.bts = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.buR != null) {
            this.buR.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.buR != null) {
            this.buR.destroy();
        }
    }

    public boolean onBackPressed() {
        if (TX().isMenuShowing()) {
            TX().toggle(true);
            if (TW().Sz()) {
                TW().cJ(false);
                this.bts.refresh();
                return true;
            }
            return true;
        }
        return false;
    }

    public void TV() {
        if (TX().isMenuShowing()) {
            TX().toggle(true);
        }
    }

    public fs TW() {
        if (this.buR == null) {
            this.buR = new fs(this.bts.getPageContext());
            TX().setMenu(this.buR.getView());
            this.buR.setCommonClickListener(this.bkV);
            this.buR.init();
            this.buR.Sy().setOnSwitchStateChangeListener(this);
        }
        this.buR.changeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return this.buR;
    }

    public SlidingMenu TX() {
        if (this.buQ == null) {
            this.buQ = new SlidingMenu(getPageContext().getPageActivity());
            this.buQ.setBackgroundColor(getPageContext().getResources().getColor(17170444));
            this.buQ.setMode(1);
            this.buQ.setTouchModeAbove(1);
            this.buQ.setBehindOffset((int) (com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity()) * 0.3d));
            this.buQ.setBehindScrollScale(0.5f);
            this.buQ.setFadeDegree(0.35f);
            this.buQ.attachToActivity(getPageContext().getPageActivity(), 1, true);
            this.buQ.setOnClosedListener(this.buS);
        }
        return this.buQ;
    }

    public void showMenu(boolean z) {
        TX().showMenu(z);
    }

    public void cN(boolean z) {
        TW().cI(z);
    }

    public void setIsManager(boolean z) {
        TW().setIsManager(z);
    }

    public void a(ei eiVar) {
        if (this.buR != null) {
            TW().a(eiVar, FrsActivityStatic.blD);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        int i = 1;
        if (view == TW().Sy()) {
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
            this.bts.onChangeSkinType(i);
            BitmapHelper.clearCashBitmap();
        }
    }
}
