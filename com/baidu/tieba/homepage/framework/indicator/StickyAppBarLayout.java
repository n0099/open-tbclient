package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.switchs.MissionEntranceSwitch;
@CoordinatorLayout.DefaultBehavior(StickyAppBarLayoutBehavior.class)
/* loaded from: classes9.dex */
public class StickyAppBarLayout extends AppBarLayout {
    CustomMessageListener dHv;
    private StickyAppBarLayoutBehavior hLt;
    private a hLu;
    private int mSkinType;

    /* loaded from: classes9.dex */
    public interface a {
        void nM(boolean z);
    }

    public StickyAppBarLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dHv = new CustomMessageListener(2921441) { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (bool != null) {
                    if (bool.booleanValue()) {
                        StickyAppBarLayout.this.bYG();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.bYH();
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dHv = new CustomMessageListener(2921441) { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (bool != null) {
                    if (bool.booleanValue()) {
                        StickyAppBarLayout.this.bYG();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.bYH();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        if (MissionEntranceSwitch.isOn()) {
            bYI();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bYF();
    }

    private void bYF() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.hLt = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    public boolean bYG() {
        if (this.hLt == null) {
            bYF();
        }
        if (this.hLt != null) {
            if (isSticky() && MissionEntranceSwitch.isOn() && this.hLt.bYL() != null && this.hLt.bYL().getVisibility() == 0) {
                bYI();
            }
            this.hLt.bYJ();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bYH() {
        if (this.hLt == null) {
            bYF();
        }
        if (this.hLt != null) {
            this.hLt.bYK();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.hLt == null) {
            bYF();
        }
        if (this.hLt != null) {
            return this.hLt.isSticky();
        }
        return false;
    }

    private void bYI() {
        an anVar = new an("c13422");
        anVar.af("obj_type", 1);
        anVar.af("obj_locate", 1);
        anVar.af(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.hLu = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.hLu;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dHv);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dHv);
    }
}
