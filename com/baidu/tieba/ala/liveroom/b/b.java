package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes7.dex */
public class b {
    private CustomMessageListener fPP = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
            }
        }
    };
    private c glW;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.fPP.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fPP);
    }

    public void b(ViewGroup viewGroup, r rVar) {
        if (viewGroup != null && this.mTbPageContext != null && rVar != null) {
            this.glW = new c(this.mTbPageContext);
            bNb();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds144) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds156);
            }
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
            layoutParams.gravity = 5;
            viewGroup.addView(this.glW.getView(), 2, layoutParams);
            if (rVar.aDE != null) {
                this.glW.ec(rVar.aDE.alaId);
            }
        }
    }

    public void lD(boolean z) {
        if (this.glW != null) {
            ViewGroup.LayoutParams layoutParams = this.glW.getView().getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                if (z) {
                    layoutParams2.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds156);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds144) + UtilHelper.getStatusBarHeight();
                    }
                } else {
                    layoutParams2.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds128);
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        layoutParams2.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds70) + UtilHelper.getStatusBarHeight();
                    }
                }
                layoutParams2.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
                layoutParams2.gravity = 5;
                this.glW.getView().setLayoutParams(layoutParams2);
            }
        }
    }

    public void bNb() {
        if (this.glW != null && this.glW.getView() != null && this.glW.getView().getParent() != null) {
            ((ViewGroup) this.glW.getView().getParent()).removeView(this.glW.getView());
        }
    }

    public void Fb() {
        if (this.fPP != null) {
            MessageManager.getInstance().unRegisterListener(this.fPP);
        }
    }
}
