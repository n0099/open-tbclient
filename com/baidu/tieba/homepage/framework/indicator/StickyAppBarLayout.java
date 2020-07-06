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
import com.baidu.tbadk.core.util.ao;
@CoordinatorLayout.DefaultBehavior(StickyAppBarLayoutBehavior.class)
/* loaded from: classes9.dex */
public class StickyAppBarLayout extends AppBarLayout {
    private StickyAppBarLayoutBehavior ipk;
    private a ipl;
    CustomMessageListener listener;
    private int mSkinType;

    /* loaded from: classes9.dex */
    public interface a {
        void ot(boolean z);
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
                        StickyAppBarLayout.this.ciG();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.ciH();
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
                        StickyAppBarLayout.this.ciG();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.ciH();
                    }
                }
            }
        };
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ciF();
    }

    private void ciF() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.ipk = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    public boolean ciG() {
        if (this.ipk == null) {
            ciF();
        }
        if (this.ipk != null) {
            if (isSticky() && this.ipk.ciL() != null && this.ipk.ciL().getVisibility() == 0) {
                ciI();
            }
            this.ipk.ciJ();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ciH() {
        if (this.ipk == null) {
            ciF();
        }
        if (this.ipk != null) {
            this.ipk.ciK();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.ipk == null) {
            ciF();
        }
        if (this.ipk != null) {
            return this.ipk.isSticky();
        }
        return false;
    }

    private void ciI() {
        ao aoVar = new ao("c13422");
        aoVar.ag("obj_type", 1);
        aoVar.ag("obj_locate", 1);
        aoVar.ag("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aoVar.dk("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aoVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.ipl = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.ipl;
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
