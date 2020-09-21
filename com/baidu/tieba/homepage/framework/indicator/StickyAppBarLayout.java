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
/* loaded from: classes21.dex */
public class StickyAppBarLayout extends AppBarLayout {
    private StickyAppBarLayoutBehavior iSr;
    private a iSs;
    CustomMessageListener listener;
    private int mSkinType;

    /* loaded from: classes21.dex */
    public interface a {
        void pN(boolean z);
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
                        StickyAppBarLayout.this.cAz();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cAA();
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
                        StickyAppBarLayout.this.cAz();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cAA();
                    }
                }
            }
        };
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        cAy();
    }

    private void cAy() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.iSr = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    public boolean cAz() {
        if (this.iSr == null) {
            cAy();
        }
        if (this.iSr != null) {
            if (isSticky() && this.iSr.cAE() != null && this.iSr.cAE().getVisibility() == 0) {
                cAB();
            }
            this.iSr.cAC();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cAA() {
        if (this.iSr == null) {
            cAy();
        }
        if (this.iSr != null) {
            this.iSr.cAD();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.iSr == null) {
            cAy();
        }
        if (this.iSr != null) {
            return this.iSr.isSticky();
        }
        return false;
    }

    private void cAB() {
        aq aqVar = new aq("c13422");
        aqVar.ai("obj_type", 1);
        aqVar.ai("obj_locate", 1);
        aqVar.ai("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dF("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.iSs = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.iSs;
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
