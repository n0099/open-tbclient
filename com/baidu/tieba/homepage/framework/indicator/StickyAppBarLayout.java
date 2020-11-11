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
/* loaded from: classes22.dex */
public class StickyAppBarLayout extends AppBarLayout {
    private StickyAppBarLayoutBehavior jzJ;
    private a jzK;
    CustomMessageListener listener;
    private int mSkinType;

    /* loaded from: classes22.dex */
    public interface a {
        void qU(boolean z);
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
                        StickyAppBarLayout.this.cJO();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cJP();
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
                        StickyAppBarLayout.this.cJO();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cJP();
                    }
                }
            }
        };
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        cJN();
    }

    private void cJN() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.jzJ = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    public boolean cJO() {
        if (this.jzJ == null) {
            cJN();
        }
        if (this.jzJ != null) {
            if (isSticky() && this.jzJ.cJT() != null && this.jzJ.cJT().getVisibility() == 0) {
                cJQ();
            }
            this.jzJ.cJR();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJP() {
        if (this.jzJ == null) {
            cJN();
        }
        if (this.jzJ != null) {
            this.jzJ.cJS();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.jzJ == null) {
            cJN();
        }
        if (this.jzJ != null) {
            return this.jzJ.isSticky();
        }
        return false;
    }

    private void cJQ() {
        aq aqVar = new aq("c13422");
        aqVar.al("obj_type", 1);
        aqVar.al("obj_locate", 1);
        aqVar.al("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.jzK = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.jzK;
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
