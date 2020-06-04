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
    private StickyAppBarLayoutBehavior iaN;
    private a iaO;
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
                        StickyAppBarLayout.this.cfj();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cfk();
                    }
                }
            }
        };
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
                        StickyAppBarLayout.this.cfj();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cfk();
                    }
                }
            }
        };
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        cfi();
    }

    private void cfi() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.iaN = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    public boolean cfj() {
        if (this.iaN == null) {
            cfi();
        }
        if (this.iaN != null) {
            if (isSticky() && MissionEntranceSwitch.isOn() && this.iaN.cfo() != null && this.iaN.cfo().getVisibility() == 0) {
                cfl();
            }
            this.iaN.cfm();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cfk() {
        if (this.iaN == null) {
            cfi();
        }
        if (this.iaN != null) {
            this.iaN.cfn();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.iaN == null) {
            cfi();
        }
        if (this.iaN != null) {
            return this.iaN.isSticky();
        }
        return false;
    }

    private void cfl() {
        an anVar = new an("c13422");
        anVar.ag("obj_type", 1);
        anVar.ag("obj_locate", 1);
        anVar.ag("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        anVar.dh("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(anVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.iaO = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.iaO;
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
