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
    private CustomMessageListener fTe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.b.1
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
    private c gph;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.fTe.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fTe);
    }

    public void c(ViewGroup viewGroup, u uVar) {
        if (viewGroup != null && this.mTbPageContext != null && uVar != null) {
            this.gph = new c(this.mTbPageContext);
            bOl();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds144) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds156);
            }
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds22);
            layoutParams.gravity = 5;
            viewGroup.addView(this.gph.getView(), 2, layoutParams);
            if (uVar.aEz != null) {
                this.gph.ee(uVar.aEz.alaId);
            }
        }
    }

    public void lH(boolean z) {
        if (this.gph != null) {
            ViewGroup.LayoutParams layoutParams = this.gph.getView().getLayoutParams();
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
                this.gph.getView().setLayoutParams(layoutParams2);
            }
        }
    }

    public void bOl() {
        if (this.gph != null && this.gph.getView() != null && this.gph.getView().getParent() != null) {
            ((ViewGroup) this.gph.getView().getParent()).removeView(this.gph.getView());
        }
    }

    public void FB() {
        if (this.fTe != null) {
            MessageManager.getInstance().unRegisterListener(this.fTe);
        }
    }
}
