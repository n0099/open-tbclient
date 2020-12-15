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
import com.baidu.tbadk.core.util.ar;
@CoordinatorLayout.DefaultBehavior(StickyAppBarLayoutBehavior.class)
/* loaded from: classes22.dex */
public class StickyAppBarLayout extends AppBarLayout {
    private StickyAppBarLayoutBehavior jOj;
    private a jOk;
    CustomMessageListener listener;
    private int mSkinType;

    /* loaded from: classes22.dex */
    public interface a {
        void ry(boolean z);
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
                        StickyAppBarLayout.this.cOJ();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cOK();
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
                        StickyAppBarLayout.this.cOJ();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cOK();
                    }
                }
            }
        };
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        cOI();
    }

    private void cOI() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.jOj = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    public boolean cOJ() {
        if (this.jOj == null) {
            cOI();
        }
        if (this.jOj != null) {
            if (isSticky() && this.jOj.cOO() != null && this.jOj.cOO().getVisibility() == 0) {
                cOL();
            }
            this.jOj.cOM();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cOK() {
        if (this.jOj == null) {
            cOI();
        }
        if (this.jOj != null) {
            this.jOj.cON();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.jOj == null) {
            cOI();
        }
        if (this.jOj != null) {
            return this.jOj.isSticky();
        }
        return false;
    }

    private void cOL() {
        ar arVar = new ar("c13422");
        arVar.al("obj_type", 1);
        arVar.al("obj_locate", 1);
        arVar.al("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        arVar.dY("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(arVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.jOk = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.jOk;
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
