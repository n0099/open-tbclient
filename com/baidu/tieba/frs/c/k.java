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
    private FrsActivity aPE;
    private SlidingMenu aQd = null;
    private ci aQe = null;
    private final View.OnClickListener aLJ = new l(this);
    private final SlidingMenu.OnClosedListener aQf = new m(this);

    public k(FrsActivity frsActivity) {
        this.aPE = frsActivity;
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
        return this.aPE.getPageContext();
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
        if (this.aQe != null) {
            this.aQe.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public boolean AX() {
        if (getSlidingMenu().isMenuShowing()) {
            getSlidingMenu().toggle(true);
            if (My().LM()) {
                My().ce(false);
                this.aPE.refresh();
                return true;
            }
            return true;
        }
        return false;
    }

    public void Mx() {
        if (getSlidingMenu().isMenuShowing()) {
            getSlidingMenu().toggle(true);
        }
    }

    public ci My() {
        if (this.aQe == null) {
            this.aQe = new ci(this.aPE.getPageContext());
            getSlidingMenu().setMenu(this.aQe.getView());
            this.aQe.n(this.aLJ);
            this.aQe.changeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
            this.aQe.init();
            this.aQe.LL().setOnSwitchStateChangeListener(this);
        }
        return this.aQe;
    }

    public SlidingMenu getSlidingMenu() {
        if (this.aQd == null) {
            this.aQd = new SlidingMenu(getPageContext().getPageActivity());
            this.aQd.setMode(1);
            this.aQd.setTouchModeAbove(1);
            this.aQd.setBehindOffset(com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 48.0f));
            this.aQd.setBehindScrollScale(0.5f);
            this.aQd.setFadeDegree(0.35f);
            this.aQd.attachToActivity(getPageContext().getPageActivity(), 1, true);
            this.aQd.setOnClosedListener(this.aQf);
        }
        return this.aQd;
    }

    public void showMenu(boolean z) {
        getSlidingMenu().showMenu(z);
    }

    public void cg(boolean z) {
        My().cd(z);
    }

    public void setIsManager(boolean z) {
        My().setIsManager(z);
    }

    public void e(w wVar) {
        if (wVar != null && wVar.aar() != null) {
            My().y(wVar.aar().getRecommendForumData());
        }
    }

    public void a(ce ceVar) {
        if (this.aQe != null) {
            My().a(ceVar, FrsActivityStatic.aMg, FrsActivityStatic.aMh);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        int i = 1;
        if (view == My().LL()) {
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
            this.aPE.onChangeSkinType(i);
            com.baidu.tbadk.core.util.c.iL();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
        }
    }
}
