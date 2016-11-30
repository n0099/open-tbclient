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
import com.baidu.tieba.frs.br;
import com.baidu.tieba.frs.cq;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f<FrsActivity> implements BdSwitchView.a {
    private final View.OnClickListener bSS;
    private FrsActivity bZY;
    private cq cko;
    private final BdSwitchView.a ckp;

    public af(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.cko = null;
        this.bSS = new ag(this);
        this.ckp = new ah(this);
        this.bZY = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.cko != null) {
            this.cko.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.cko != null) {
            this.cko.destroy();
        }
    }

    public cq ahF() {
        if (this.cko == null) {
            this.cko = new cq(this.bZY.getPageContext());
            this.cko.setCommonClickListener(this.bSS);
            this.cko.init();
            this.cko.adK().setOnSwitchStateChangeListener(this);
            this.cko.adL().setOnSwitchStateChangeListener(this);
            ey(false);
        }
        return this.cko;
    }

    public void ex(boolean z) {
        ahF().dZ(z);
    }

    public void ey(boolean z) {
        ahF().adL().setOnSwitchStateChangeListener(null);
        ahF().ea(z);
        ahF().adL().setOnSwitchStateChangeListener(this.ckp);
    }

    public void ez(boolean z) {
        if (z) {
            ahF().adJ().setVisibility(0);
        } else {
            ahF().adJ().setVisibility(8);
        }
    }

    public void a(br brVar) {
        if (this.cko != null) {
            ahF().a(brVar, FrsActivityStatic.bTh);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == ahF().adK()) {
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
