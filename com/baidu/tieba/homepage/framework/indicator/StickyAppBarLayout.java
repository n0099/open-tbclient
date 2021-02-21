package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.google.android.material.appbar.AppBarLayout;
@CoordinatorLayout.DefaultBehavior(StickyAppBarLayoutBehavior.class)
/* loaded from: classes2.dex */
public class StickyAppBarLayout extends AppBarLayout {
    CustomMessageListener fjP;
    private StickyAppBarLayoutBehavior keI;
    private a keJ;
    private int mSkinType;

    /* loaded from: classes2.dex */
    public interface a {
        void sd(boolean z);
    }

    public StickyAppBarLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fjP = new CustomMessageListener(2921441) { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (bool != null) {
                    if (bool.booleanValue()) {
                        StickyAppBarLayout.this.cQc();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cQd();
                    }
                }
            }
        };
    }

    public StickyAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fjP = new CustomMessageListener(2921441) { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (bool != null) {
                    if (bool.booleanValue()) {
                        StickyAppBarLayout.this.cQc();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.cQd();
                    }
                }
            }
        };
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        cQb();
    }

    private void cQb() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.keI = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    public boolean cQc() {
        if (this.keI == null) {
            cQb();
        }
        if (this.keI != null) {
            if (isSticky() && this.keI.cQh() != null && this.keI.cQh().getVisibility() == 0) {
                cQe();
            }
            this.keI.cQf();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cQd() {
        if (this.keI == null) {
            cQb();
        }
        if (this.keI != null) {
            this.keI.cQg();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.keI == null) {
            cQb();
        }
        if (this.keI != null) {
            return this.keI.isSticky();
        }
        return false;
    }

    private void cQe() {
        ar arVar = new ar("c13422");
        arVar.ap("obj_type", 1);
        arVar.ap("obj_locate", 1);
        arVar.ap("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        arVar.dR("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(arVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.keJ = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.keJ;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.fjP);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.fjP);
    }
}
