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
    private final View.OnClickListener bPX;
    private FrsActivity bWH;
    private dr cfx;
    private final BdSwitchView.a cfy;

    public aa(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.cfx = null;
        this.bPX = new ab(this);
        this.cfy = new ac(this);
        this.bWH = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.cfx != null) {
            this.cfx.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.cfx != null) {
            this.cfx.destroy();
        }
    }

    public dr afS() {
        if (this.cfx == null) {
            this.cfx = new dr(this.bWH.getPageContext());
            this.cfx.setCommonClickListener(this.bPX);
            this.cfx.init();
            this.cfx.acD().setOnSwitchStateChangeListener(this);
            this.cfx.acE().setOnSwitchStateChangeListener(this);
            ej(false);
        }
        return this.cfx;
    }

    public void ei(boolean z) {
        afS().dQ(z);
    }

    public void ej(boolean z) {
        afS().acE().setOnSwitchStateChangeListener(null);
        afS().dR(z);
        afS().acE().setOnSwitchStateChangeListener(this.cfy);
    }

    public void ek(boolean z) {
        if (z) {
            afS().acC().setVisibility(0);
        } else {
            afS().acC().setVisibility(8);
        }
    }

    public void a(ct ctVar) {
        if (this.cfx != null) {
            afS().a(ctVar, FrsActivityStatic.bQv);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == afS().acD()) {
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
