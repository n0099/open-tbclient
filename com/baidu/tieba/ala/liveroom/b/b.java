package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class b {
    private c gDA;
    private CustomMessageListener gfx = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.b.1
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
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.gfx.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gfx);
    }

    public void c(ViewGroup viewGroup, u uVar) {
        if (viewGroup != null && this.mTbPageContext != null && uVar != null) {
            this.gDA = new c(this.mTbPageContext);
            bRC();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds144) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds156);
            }
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
            layoutParams.gravity = 5;
            viewGroup.addView(this.gDA.getView(), 2, layoutParams);
            if (uVar.aHD != null) {
                this.gDA.eu(uVar.aHD.alaId);
            }
        }
    }

    public void mj(boolean z) {
        if (this.gDA != null) {
            ViewGroup.LayoutParams layoutParams = this.gDA.getView().getLayoutParams();
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
                this.gDA.getView().setLayoutParams(layoutParams2);
            }
        }
    }

    public void bRC() {
        if (this.gDA != null && this.gDA.getView() != null && this.gDA.getView().getParent() != null) {
            ((ViewGroup) this.gDA.getView().getParent()).removeView(this.gDA.getView());
        }
    }

    public void Gx() {
        if (this.gfx != null) {
            MessageManager.getInstance().unRegisterListener(this.gfx);
        }
    }
}
