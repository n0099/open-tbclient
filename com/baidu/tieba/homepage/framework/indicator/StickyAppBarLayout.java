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
import com.baidu.tbadk.core.util.aq;
@CoordinatorLayout.DefaultBehavior(StickyAppBarLayoutBehavior.class)
/* loaded from: classes16.dex */
public class StickyAppBarLayout extends AppBarLayout {
    private StickyAppBarLayoutBehavior iJF;
    private a iJG;
    CustomMessageListener listener;
    private int mSkinType;

    /* loaded from: classes16.dex */
    public interface a {
        void pD(boolean z);
    }

    public StickyAppBarLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.listener = new CustomMessageListener(2921441) { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (bool != null) {
                    if (bool.booleanValue()) {
                        StickyAppBarLayout.this.cwQ();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cwR();
                    }
                }
            }
        };
    }

    public StickyAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.listener = new CustomMessageListener(2921441) { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (bool != null) {
                    if (bool.booleanValue()) {
                        StickyAppBarLayout.this.cwQ();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cwR();
                    }
                }
            }
        };
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        cwP();
    }

    private void cwP() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.iJF = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    public boolean cwQ() {
        if (this.iJF == null) {
            cwP();
        }
        if (this.iJF != null) {
            if (isSticky() && this.iJF.cwV() != null && this.iJF.cwV().getVisibility() == 0) {
                cwS();
            }
            this.iJF.cwT();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cwR() {
        if (this.iJF == null) {
            cwP();
        }
        if (this.iJF != null) {
            this.iJF.cwU();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.iJF == null) {
            cwP();
        }
        if (this.iJF != null) {
            return this.iJF.isSticky();
        }
        return false;
    }

    private void cwS() {
        aq aqVar = new aq("c13422");
        aqVar.ai("obj_type", 1);
        aqVar.ai("obj_locate", 1);
        aqVar.ai("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dD("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.iJG = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.iJG;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.listener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.listener);
    }
}
