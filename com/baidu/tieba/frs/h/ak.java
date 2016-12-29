package com.baidu.tieba.frs.h;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.cp;
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.base.f<FrsActivity> implements BdSwitchView.a {
    private FrsActivity bFI;
    private cp bPx;
    private final BdSwitchView.a bPy;
    private final View.OnClickListener bzd;

    public ak(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bPx = null;
        this.bzd = new al(this);
        this.bPy = new am(this);
        this.bFI = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bPx != null) {
            this.bPx.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.bPx != null) {
            this.bPx.destroy();
        }
    }

    public cp acc() {
        if (this.bPx == null) {
            this.bPx = new cp(this.bFI.getPageContext());
            this.bPx.setCommonClickListener(this.bzd);
            this.bPx.init();
            this.bPx.Yd().setOnSwitchStateChangeListener(this);
            this.bPx.Ye().setOnSwitchStateChangeListener(this);
            ei(false);
        }
        return this.bPx;
    }

    public void eh(boolean z) {
        acc().dI(z);
    }

    public void ei(boolean z) {
        acc().Ye().setOnSwitchStateChangeListener(null);
        acc().dJ(z);
        acc().Ye().setOnSwitchStateChangeListener(this.bPy);
    }

    public void ej(boolean z) {
        if (z) {
            acc().Yc().setVisibility(0);
        } else {
            acc().Yc().setVisibility(8);
        }
    }

    public void a(bq bqVar) {
        if (this.bPx != null) {
            acc().a(bqVar, FrsActivityStatic.bzs);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == acc().Yd()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TbadkCoreApplication.m9getInst().getSkinType() != 1) {
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_night_mode", "frsclick", 1, new Object[0]);
                    TbadkCoreApplication.m9getInst().setSkinType(1);
                    TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                } else {
                    return;
                }
            } else if (TbadkCoreApplication.m9getInst().getSkinType() != 0) {
                TbadkCoreApplication.m9getInst().setSkinType(0);
            } else {
                return;
            }
            BitmapHelper.clearCashBitmap();
        }
    }
}
