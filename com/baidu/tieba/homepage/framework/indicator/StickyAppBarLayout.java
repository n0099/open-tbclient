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
import com.baidu.tbadk.core.util.ap;
@CoordinatorLayout.DefaultBehavior(StickyAppBarLayoutBehavior.class)
/* loaded from: classes16.dex */
public class StickyAppBarLayout extends AppBarLayout {
    private StickyAppBarLayoutBehavior ivq;
    private a ivr;
    CustomMessageListener listener;
    private int mSkinType;

    /* loaded from: classes16.dex */
    public interface a {
        void oY(boolean z);
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
                        StickyAppBarLayout.this.cmh();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cmi();
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
                        StickyAppBarLayout.this.cmh();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cmi();
                    }
                }
            }
        };
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        cmg();
    }

    private void cmg() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.ivq = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    public boolean cmh() {
        if (this.ivq == null) {
            cmg();
        }
        if (this.ivq != null) {
            if (isSticky() && this.ivq.cmm() != null && this.ivq.cmm().getVisibility() == 0) {
                cmj();
            }
            this.ivq.cmk();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cmi() {
        if (this.ivq == null) {
            cmg();
        }
        if (this.ivq != null) {
            this.ivq.cml();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.ivq == null) {
            cmg();
        }
        if (this.ivq != null) {
            return this.ivq.isSticky();
        }
        return false;
    }

    private void cmj() {
        ap apVar = new ap("c13422");
        apVar.ah("obj_type", 1);
        apVar.ah("obj_locate", 1);
        apVar.ah("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        apVar.dn("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(apVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.ivr = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.ivr;
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
