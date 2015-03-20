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
    private FrsActivity aNb;
    private SlidingMenu aNA = null;
    private cj aNB = null;
    private final View.OnClickListener aJs = new l(this);
    private final SlidingMenu.OnClosedListener aNC = new m(this);

    public k(FrsActivity frsActivity) {
        this.aNb = frsActivity;
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
        return this.aNb.getPageContext();
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
        if (this.aNB != null) {
            this.aNB.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public boolean Af() {
        if (getSlidingMenu().isMenuShowing()) {
            getSlidingMenu().toggle(true);
            if (Lh().Kx()) {
                Lh().bX(false);
                this.aNb.refresh();
                return true;
            }
            return true;
        }
        return false;
    }

    public void Lg() {
        if (getSlidingMenu().isMenuShowing()) {
            getSlidingMenu().toggle(true);
        }
    }

    public cj Lh() {
        if (this.aNB == null) {
            this.aNB = new cj(this.aNb.getPageContext());
            getSlidingMenu().setMenu(this.aNB.getView());
            this.aNB.n(this.aJs);
            this.aNB.changeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
            this.aNB.init();
            this.aNB.Kw().setOnSwitchStateChangeListener(this);
        }
        return this.aNB;
    }

    public SlidingMenu getSlidingMenu() {
        if (this.aNA == null) {
            this.aNA = new SlidingMenu(getPageContext().getPageActivity());
            this.aNA.setMode(1);
            this.aNA.setTouchModeAbove(1);
            this.aNA.setBehindOffset(com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 48.0f));
            this.aNA.setBehindScrollScale(0.5f);
            this.aNA.setFadeDegree(0.35f);
            this.aNA.attachToActivity(getPageContext().getPageActivity(), 1);
            this.aNA.setOnClosedListener(this.aNC);
        }
        return this.aNA;
    }

    public void showMenu(boolean z) {
        getSlidingMenu().showMenu(z);
    }

    public void bZ(boolean z) {
        Lh().bW(z);
    }

    public void setIsManager(boolean z) {
        Lh().setIsManager(z);
    }

    public void e(w wVar) {
        if (wVar != null && wVar.YO() != null) {
            Lh().y(wVar.YO().getRecommendForumData());
        }
    }

    public void a(cf cfVar) {
        if (this.aNB != null) {
            Lh().a(cfVar, FrsActivityStatic.aJP, FrsActivityStatic.aJQ);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        int i = 1;
        if (view == Lh().Kw()) {
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
            this.aNb.onChangeSkinType(i);
            com.baidu.tbadk.core.util.c.iu();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
        }
    }
}
