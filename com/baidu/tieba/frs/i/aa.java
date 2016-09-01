package com.baidu.tieba.frs.i;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.dr;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.base.f<FrsActivity> implements BdSwitchView.a {
    private final View.OnClickListener bQe;
    private FrsActivity bWH;
    private dr cfA;
    private final BdSwitchView.a cfB;

    public aa(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.cfA = null;
        this.bQe = new ab(this);
        this.cfB = new ac(this);
        this.bWH = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.cfA != null) {
            this.cfA.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.cfA != null) {
            this.cfA.destroy();
        }
    }

    public dr afE() {
        if (this.cfA == null) {
            this.cfA = new dr(this.bWH.getPageContext());
            this.cfA.setCommonClickListener(this.bQe);
            this.cfA.init();
            this.cfA.acr().setOnSwitchStateChangeListener(this);
            this.cfA.acs().setOnSwitchStateChangeListener(this);
            ei(false);
        }
        return this.cfA;
    }

    public void eh(boolean z) {
        afE().dP(z);
    }

    public void ei(boolean z) {
        afE().acs().setOnSwitchStateChangeListener(null);
        afE().dQ(z);
        afE().acs().setOnSwitchStateChangeListener(this.cfB);
    }

    public void ej(boolean z) {
        if (z) {
            afE().acq().setVisibility(0);
        } else {
            afE().acq().setVisibility(8);
        }
    }

    public void a(ct ctVar) {
        if (this.cfA != null) {
            afE().a(ctVar, FrsActivityStatic.bQC);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == afE().acr()) {
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
