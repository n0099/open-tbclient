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
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.frs.dw;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.base.f<FrsActivity> implements BdSwitchView.a {
    private final View.OnClickListener bDr;
    private FrsActivity bJR;
    private dw bSs;
    private final BdSwitchView.a bSt;

    public aa(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bSs = null;
        this.bDr = new ab(this);
        this.bSt = new ac(this);
        this.bJR = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bSs != null) {
            this.bSs.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.bSs != null) {
            this.bSs.destroy();
        }
    }

    public dw aar() {
        if (this.bSs == null) {
            this.bSs = new dw(this.bJR.getPageContext());
            this.bSs.setCommonClickListener(this.bDr);
            this.bSs.init();
            this.bSs.Xo().setOnSwitchStateChangeListener(this);
            this.bSs.Xp().setOnSwitchStateChangeListener(this);
            dM(false);
        }
        return this.bSs;
    }

    public void dL(boolean z) {
        aar().dw(z);
    }

    public void setIsManager(boolean z) {
        aar().setIsManager(z);
    }

    public void dM(boolean z) {
        aar().Xp().setOnSwitchStateChangeListener(null);
        aar().dx(z);
        aar().Xp().setOnSwitchStateChangeListener(this.bSt);
    }

    public void dN(boolean z) {
        if (z) {
            aar().Xn().setVisibility(0);
        } else {
            aar().Xn().setVisibility(8);
        }
    }

    public void a(cx cxVar) {
        if (this.bSs != null) {
            aar().a(cxVar, FrsActivityStatic.bDO);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == aar().Xo()) {
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
