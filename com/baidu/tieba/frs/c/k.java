package com.baidu.tieba.frs.c;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.ci;
import com.baidu.tieba.tbadkCore.w;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.mvc.i.a implements com.baidu.adp.widget.BdSwitchView.b {
    private FrsActivity aPF;
    private SlidingMenu aQe = null;
    private ci aQf = null;
    private final View.OnClickListener aLK = new l(this);
    private final SlidingMenu.OnClosedListener aQg = new m(this);

    public k(FrsActivity frsActivity) {
        this.aPF = frsActivity;
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void oJ() {
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void oI() {
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.adp.base.g
    public TbPageContext<?> getPageContext() {
        return this.aPF.getPageContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void oL() {
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int oK() {
        return 0;
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.aQf != null) {
            this.aQf.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public boolean AY() {
        if (getSlidingMenu().isMenuShowing()) {
            getSlidingMenu().toggle(true);
            if (Mz().LN()) {
                Mz().ce(false);
                this.aPF.refresh();
                return true;
            }
            return true;
        }
        return false;
    }

    public void My() {
        if (getSlidingMenu().isMenuShowing()) {
            getSlidingMenu().toggle(true);
        }
    }

    public ci Mz() {
        if (this.aQf == null) {
            this.aQf = new ci(this.aPF.getPageContext());
            getSlidingMenu().setMenu(this.aQf.getView());
            this.aQf.n(this.aLK);
            this.aQf.changeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
            this.aQf.init();
            this.aQf.LM().setOnSwitchStateChangeListener(this);
        }
        return this.aQf;
    }

    public SlidingMenu getSlidingMenu() {
        if (this.aQe == null) {
            this.aQe = new SlidingMenu(getPageContext().getPageActivity());
            this.aQe.setMode(1);
            this.aQe.setTouchModeAbove(1);
            this.aQe.setBehindOffset(com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 48.0f));
            this.aQe.setBehindScrollScale(0.5f);
            this.aQe.setFadeDegree(0.35f);
            this.aQe.attachToActivity(getPageContext().getPageActivity(), 1, true);
            this.aQe.setOnClosedListener(this.aQg);
        }
        return this.aQe;
    }

    public void showMenu(boolean z) {
        getSlidingMenu().showMenu(z);
    }

    public void cg(boolean z) {
        Mz().cd(z);
    }

    public void setIsManager(boolean z) {
        Mz().setIsManager(z);
    }

    public void e(w wVar) {
        if (wVar != null && wVar.aas() != null) {
            Mz().y(wVar.aas().getRecommendForumData());
        }
    }

    public void a(ce ceVar) {
        if (this.aQf != null) {
            Mz().a(ceVar, FrsActivityStatic.aMh, FrsActivityStatic.aMi);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        int i = 1;
        if (view == Mz().LM()) {
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
            this.aPF.onChangeSkinType(i);
            com.baidu.tbadk.core.util.c.iL();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
        }
    }
}
