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
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.frs.cj;
import com.baidu.tieba.tbadkCore.w;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.mvc.i.a implements com.baidu.adp.widget.BdSwitchView.b {
    private FrsActivity aNs;
    private SlidingMenu aNR = null;
    private cj aNS = null;
    private final View.OnClickListener aJC = new l(this);
    private final SlidingMenu.OnClosedListener aNT = new m(this);

    public k(FrsActivity frsActivity) {
        this.aNs = frsActivity;
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void ot() {
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void os() {
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.adp.base.g
    public TbPageContext<?> getPageContext() {
        return this.aNs.getPageContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ov() {
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return 0;
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.aNS != null) {
            this.aNS.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public boolean Al() {
        if (getSlidingMenu().isMenuShowing()) {
            getSlidingMenu().toggle(true);
            if (Lt().KH()) {
                Lt().bV(false);
                this.aNs.refresh();
                return true;
            }
            return true;
        }
        return false;
    }

    public void Ls() {
        if (getSlidingMenu().isMenuShowing()) {
            getSlidingMenu().toggle(true);
        }
    }

    public cj Lt() {
        if (this.aNS == null) {
            this.aNS = new cj(this.aNs.getPageContext());
            getSlidingMenu().setMenu(this.aNS.getView());
            this.aNS.n(this.aJC);
            this.aNS.changeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
            this.aNS.init();
            this.aNS.KG().setOnSwitchStateChangeListener(this);
        }
        return this.aNS;
    }

    public SlidingMenu getSlidingMenu() {
        if (this.aNR == null) {
            this.aNR = new SlidingMenu(getPageContext().getPageActivity());
            this.aNR.setMode(1);
            this.aNR.setTouchModeAbove(1);
            this.aNR.setBehindOffset(com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 48.0f));
            this.aNR.setBehindScrollScale(0.5f);
            this.aNR.setFadeDegree(0.35f);
            this.aNR.attachToActivity(getPageContext().getPageActivity(), 1);
            this.aNR.setOnClosedListener(this.aNT);
        }
        return this.aNR;
    }

    public void showMenu(boolean z) {
        getSlidingMenu().showMenu(z);
    }

    public void bX(boolean z) {
        Lt().bU(z);
    }

    public void setIsManager(boolean z) {
        Lt().setIsManager(z);
    }

    public void e(w wVar) {
        if (wVar != null && wVar.Za() != null) {
            Lt().z(wVar.Za().getRecommendForumData());
        }
    }

    public void a(cf cfVar) {
        if (this.aNS != null) {
            Lt().a(cfVar, FrsActivityStatic.aJZ, FrsActivityStatic.aKa);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        int i = 1;
        if (view == Lt().KG()) {
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
            this.aNs.onChangeSkinType(i);
            com.baidu.tbadk.core.util.c.iu();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
        }
    }
}
