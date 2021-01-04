package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.google.android.material.appbar.AppBarLayout;
@CoordinatorLayout.DefaultBehavior(StickyAppBarLayoutBehavior.class)
/* loaded from: classes2.dex */
public class StickyAppBarLayout extends AppBarLayout {
    CustomMessageListener fmh;
    private StickyAppBarLayoutBehavior kbx;
    private a kby;
    private int mSkinType;

    /* loaded from: classes2.dex */
    public interface a {
        void rV(boolean z);
    }

    public StickyAppBarLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fmh = new CustomMessageListener(2921441) { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (bool != null) {
                    if (bool.booleanValue()) {
                        StickyAppBarLayout.this.cRP();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cRQ();
                    }
                }
            }
        };
    }

    public StickyAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fmh = new CustomMessageListener(2921441) { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (bool != null) {
                    if (bool.booleanValue()) {
                        StickyAppBarLayout.this.cRP();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cRQ();
                    }
                }
            }
        };
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        cRO();
    }

    private void cRO() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.kbx = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    public boolean cRP() {
        if (this.kbx == null) {
            cRO();
        }
        if (this.kbx != null) {
            if (isSticky() && this.kbx.cRU() != null && this.kbx.cRU().getVisibility() == 0) {
                cRR();
            }
            this.kbx.cRS();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cRQ() {
        if (this.kbx == null) {
            cRO();
        }
        if (this.kbx != null) {
            this.kbx.cRT();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.kbx == null) {
            cRO();
        }
        if (this.kbx != null) {
            return this.kbx.isSticky();
        }
        return false;
    }

    private void cRR() {
        aq aqVar = new aq("c13422");
        aqVar.an("obj_type", 1);
        aqVar.an("obj_locate", 1);
        aqVar.an("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        aqVar.dX("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(aqVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.kby = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.kby;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.fmh);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.fmh);
    }
}
