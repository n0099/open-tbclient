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
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.fr;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.f<FrsActivity> implements BdSwitchView.a {
    private final View.OnClickListener bha;
    private FrsActivity bpj;
    private fr buE;

    public y(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.buE = null;
        this.bha = new z(this);
        this.bpj = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.buE != null) {
            this.buE.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.buE != null) {
            this.buE.destroy();
        }
    }

    public fr Ub() {
        if (this.buE == null) {
            this.buE = new fr(this.bpj.getPageContext());
            this.buE.setCommonClickListener(this.bha);
            this.buE.init();
            this.buE.RW().setOnSwitchStateChangeListener(this);
        }
        return this.buE;
    }

    public void dn(boolean z) {
        Ub().da(z);
    }

    public void setIsManager(boolean z) {
        Ub().setIsManager(z);
    }

    public void a(ed edVar) {
        if (this.buE != null) {
            Ub().a(edVar, FrsActivityStatic.bhG);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        int i = 1;
        if (view == Ub().RW()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TbadkCoreApplication.m11getInst().getSkinType() != 1) {
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_night_mode", "frsclick", 1, new Object[0]);
                    TbadkCoreApplication.m11getInst().setSkinType(1);
                    TiebaStatic.eventStat(TbadkCoreApplication.m11getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                } else {
                    return;
                }
            } else if (TbadkCoreApplication.m11getInst().getSkinType() != 0) {
                TbadkCoreApplication.m11getInst().setSkinType(0);
                i = 0;
            } else {
                return;
            }
            this.bpj.onChangeSkinType(i);
            BitmapHelper.clearCashBitmap();
        }
    }
}
