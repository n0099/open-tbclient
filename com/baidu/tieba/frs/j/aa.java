package com.baidu.tieba.frs.j;

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
    private final View.OnClickListener bEy;
    private FrsActivity bLx;
    private dw bUs;
    private final BdSwitchView.a bUt;

    public aa(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bUs = null;
        this.bEy = new ab(this);
        this.bUt = new ac(this);
        this.bLx = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bUs != null) {
            this.bUs.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.bUs != null) {
            this.bUs.destroy();
        }
    }

    public dw aaT() {
        if (this.bUs == null) {
            this.bUs = new dw(this.bLx.getPageContext());
            this.bUs.setCommonClickListener(this.bEy);
            this.bUs.init();
            this.bUs.XG().setOnSwitchStateChangeListener(this);
            this.bUs.XH().setOnSwitchStateChangeListener(this);
            dM(false);
        }
        return this.bUs;
    }

    public void dL(boolean z) {
        aaT().dt(z);
    }

    public void setIsManager(boolean z) {
        aaT().setIsManager(z);
    }

    public void dM(boolean z) {
        aaT().XH().setOnSwitchStateChangeListener(null);
        aaT().du(z);
        aaT().XH().setOnSwitchStateChangeListener(this.bUt);
    }

    public void dN(boolean z) {
        if (z) {
            aaT().XF().setVisibility(0);
        } else {
            aaT().XF().setVisibility(8);
        }
    }

    public void a(cx cxVar) {
        if (this.bUs != null) {
            aaT().a(cxVar, FrsActivityStatic.bEY);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == aaT().XG()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TbadkCoreApplication.m10getInst().getSkinType() != 1) {
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_night_mode", "frsclick", 1, new Object[0]);
                    TbadkCoreApplication.m10getInst().setSkinType(1);
                    TiebaStatic.eventStat(TbadkCoreApplication.m10getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                } else {
                    return;
                }
            } else if (TbadkCoreApplication.m10getInst().getSkinType() != 0) {
                TbadkCoreApplication.m10getInst().setSkinType(0);
            } else {
                return;
            }
            BitmapHelper.clearCashBitmap();
        }
    }
}
