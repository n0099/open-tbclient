package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.switchs.MissionEntranceSwitch;
import com.baidu.tieba.R;
@CoordinatorLayout.DefaultBehavior(StickyAppBarLayoutBehavior.class)
/* loaded from: classes7.dex */
public class StickyAppBarLayout extends AppBarLayout {
    CustomMessageListener dcU;
    private Drawable fTy;
    private StickyAppBarLayoutBehavior gYg;
    private a gYh;
    private Paint gYi;
    private int mSkinType;

    /* loaded from: classes7.dex */
    public interface a {
        void mA(boolean z);
    }

    public StickyAppBarLayout(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dcU = new CustomMessageListener(2921441) { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (bool != null) {
                    if (bool.booleanValue()) {
                        StickyAppBarLayout.this.bMm();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.bMn();
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dcU = new CustomMessageListener(2921441) { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (bool != null) {
                    if (bool.booleanValue()) {
                        StickyAppBarLayout.this.bMm();
                    } else if (!StickyAppBarLayout.this.isSticky()) {
                        StickyAppBarLayout.this.bMn();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        if (MissionEntranceSwitch.isOn()) {
            bMo();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bMl();
    }

    private void bMl() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.gYg = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (TbSingleton.getInstance().isShowNewYearSkin() && this.fTy != null) {
            int measuredHeight = getMeasuredHeight() - ((int) ((this.fTy.getIntrinsicHeight() / this.fTy.getIntrinsicWidth()) * getWidth()));
            this.fTy.setBounds(0, measuredHeight, getMeasuredWidth(), getMeasuredHeight());
            this.fTy.draw(canvas);
            if (measuredHeight > 0) {
                if (this.gYi == null) {
                    this.gYi = new Paint();
                    this.gYi.setColor(am.getColor(R.color.cp_cont_h));
                }
                canvas.drawRect(0.0f, 0.0f, getWidth(), measuredHeight, this.gYi);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            if (TbSingleton.getInstance().isShowNewYearSkin()) {
                this.fTy = am.getDrawable(R.drawable.backguard_mask_topbar_newyear);
                if (skinType == 1) {
                    int color = am.getColor(R.color.cp_mask_a);
                    this.fTy.mutate();
                    this.fTy.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
                } else if (skinType == 4) {
                    int color2 = am.getColor(R.color.cp_mask_a);
                    this.fTy.mutate();
                    this.fTy.setColorFilter(color2, PorterDuff.Mode.SRC_ATOP);
                }
                if (this.gYi != null) {
                    this.gYi.setColor(am.getColor(R.color.cp_cont_h));
                }
            }
        }
    }

    public boolean bMm() {
        if (this.gYg == null) {
            bMl();
        }
        if (this.gYg != null) {
            if (isSticky() && MissionEntranceSwitch.isOn() && this.gYg.bMr() != null && this.gYg.bMr().getVisibility() == 0) {
                bMo();
            }
            this.gYg.bMp();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bMn() {
        if (this.gYg == null) {
            bMl();
        }
        if (this.gYg != null) {
            this.gYg.bMq();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.gYg == null) {
            bMl();
        }
        if (this.gYg != null) {
            return this.gYg.isSticky();
        }
        return false;
    }

    private void bMo() {
        an anVar = new an("c13422");
        anVar.Z("obj_type", 1);
        anVar.Z("obj_locate", 1);
        anVar.Z(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.gYh = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.gYh;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dcU);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dcU);
    }
}
