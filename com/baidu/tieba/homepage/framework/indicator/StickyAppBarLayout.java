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
    CustomMessageListener dhn;
    private StickyAppBarLayoutBehavior hav;
    private a haw;
    private int mSkinType;

    /* loaded from: classes9.dex */
    public interface a {
        void mC(boolean z);
    }

    public StickyAppBarLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dhn = new CustomMessageListener(2921441) { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (bool != null) {
                    if (bool.booleanValue()) {
                        StickyAppBarLayout.this.bNR();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.bNS();
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dhn = new CustomMessageListener(2921441) { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (bool != null) {
                    if (bool.booleanValue()) {
                        StickyAppBarLayout.this.bNR();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.bNS();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        if (MissionEntranceSwitch.isOn()) {
            bNT();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bNQ();
    }

    private void bNQ() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.hav = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    public boolean bNR() {
        if (this.hav == null) {
            bNQ();
        }
        if (this.hav != null) {
            if (isSticky() && MissionEntranceSwitch.isOn() && this.hav.bNW() != null && this.hav.bNW().getVisibility() == 0) {
                bNT();
            }
            this.hav.bNU();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bNS() {
        if (this.hav == null) {
            bNQ();
        }
        if (this.hav != null) {
            this.hav.bNV();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.hav == null) {
            bNQ();
        }
        if (this.hav != null) {
            return this.hav.isSticky();
        }
        return false;
    }

    private void bNT() {
        an anVar = new an("c13422");
        anVar.X("obj_type", 1);
        anVar.X("obj_locate", 1);
        anVar.X(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.haw = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.haw;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dhn);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dhn);
    }
}
