package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.switchs.MissionEntranceSwitch;
@CoordinatorLayout.DefaultBehavior(StickyAppBarLayoutBehavior.class)
/* loaded from: classes9.dex */
public class StickyAppBarLayout extends AppBarLayout {
    CustomMessageListener dVL;
    private StickyAppBarLayoutBehavior iaa;
    private a iab;
    private int mSkinType;

    /* loaded from: classes9.dex */
    public interface a {
        void oi(boolean z);
    }

    public StickyAppBarLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dVL = new CustomMessageListener(2921441) { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (bool != null) {
                    if (bool.booleanValue()) {
                        StickyAppBarLayout.this.cfa();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cfb();
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dVL = new CustomMessageListener(2921441) { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (bool != null) {
                    if (bool.booleanValue()) {
                        StickyAppBarLayout.this.cfa();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cfb();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        if (MissionEntranceSwitch.isOn()) {
            cfc();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ceZ();
    }

    private void ceZ() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.iaa = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    public boolean cfa() {
        if (this.iaa == null) {
            ceZ();
        }
        if (this.iaa != null) {
            if (isSticky() && MissionEntranceSwitch.isOn() && this.iaa.cff() != null && this.iaa.cff().getVisibility() == 0) {
                cfc();
            }
            this.iaa.cfd();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfb() {
        if (this.iaa == null) {
            ceZ();
        }
        if (this.iaa != null) {
            this.iaa.cfe();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.iaa == null) {
            ceZ();
        }
        if (this.iaa != null) {
            return this.iaa.isSticky();
        }
        return false;
    }

    private void cfc() {
        an anVar = new an("c13422");
        anVar.ag("obj_type", 1);
        anVar.ag("obj_locate", 1);
        anVar.ag("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.iab = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.iab;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dVL);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dVL);
    }
}
