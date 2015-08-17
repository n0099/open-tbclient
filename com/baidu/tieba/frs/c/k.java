package com.baidu.tieba.frs.c;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.dg;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.f<FrsActivity> implements BdSwitchView.a {
    private final View.OnClickListener aUY;
    private FrsActivity bat;
    private SlidingMenu bbA;
    private dg bbB;
    private final SlidingMenu.OnClosedListener bbC;

    public k(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bbA = null;
        this.bbB = null;
        this.aUY = new l(this);
        this.bbC = new m(this);
        this.bat = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bbB != null) {
            this.bbB.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.bbB != null) {
            this.bbB.destroy();
        }
    }

    public boolean onBackPressed() {
        if (NN().isMenuShowing()) {
            NN().toggle(true);
            if (NM().MC()) {
                NM().cf(false);
                this.bat.refresh();
                return true;
            }
            return true;
        }
        return false;
    }

    public void NL() {
        if (NN().isMenuShowing()) {
            NN().toggle(true);
        }
    }

    public dg NM() {
        if (this.bbB == null) {
            this.bbB = new dg(this.bat.getPageContext());
            NN().setMenu(this.bbB.getView());
            this.bbB.n(this.aUY);
            this.bbB.changeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
            this.bbB.init();
            this.bbB.MB().setOnSwitchStateChangeListener(this);
        }
        return this.bbB;
    }

    public SlidingMenu NN() {
        if (this.bbA == null) {
            this.bbA = new SlidingMenu(getPageContext().getPageActivity());
            this.bbA.setBackgroundColor(getPageContext().getResources().getColor(17170444));
            this.bbA.setMode(1);
            this.bbA.setTouchModeAbove(1);
            this.bbA.setBehindOffset(com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 48.0f));
            this.bbA.setBehindScrollScale(0.5f);
            this.bbA.setFadeDegree(0.35f);
            this.bbA.attachToActivity(getPageContext().getPageActivity(), 1, true);
            this.bbA.setOnClosedListener(this.bbC);
        }
        return this.bbA;
    }

    public void showMenu(boolean z) {
        NN().showMenu(z);
    }

    public void cj(boolean z) {
        NM().ce(z);
    }

    public void setIsManager(boolean z) {
        NM().setIsManager(z);
    }

    public void a(cn cnVar) {
        if (this.bbB != null) {
            NM().a(cnVar, FrsActivityStatic.aVt, FrsActivityStatic.aVu);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        int i = 1;
        if (view == NM().MB()) {
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
            this.bat.onChangeSkinType(i);
            com.baidu.tbadk.core.util.c.ix();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        }
    }
}
