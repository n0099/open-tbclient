package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a {
    private c gDA;
    private CustomMessageListener gfx = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                a.this.otherParams = str;
            }
        }
    };
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext, boolean z) {
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
            layoutParams.gravity = 5;
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds116);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds96) + UtilHelper.getStatusBarHeight();
            }
            if (!TbadkCoreApplication.getInst().isOther()) {
                viewGroup.addView(this.gDA.getView(), 0, layoutParams);
                t(uVar);
            }
        }
    }

    public void t(u uVar) {
        if (uVar.aHD != null) {
            this.gDA.eu(uVar.aHD.alaId);
        }
    }

    public boolean aw(ViewGroup viewGroup) {
        return (this.gDA == null || this.gDA.getView() == null || viewGroup.indexOfChild(this.gDA.getView()) <= -1) ? false : true;
    }

    public void bRC() {
        if (this.gDA != null && this.gDA.getView() != null && this.gDA.getView().getParent() != null) {
            ((ViewGroup) this.gDA.getView().getParent()).removeView(this.gDA.getView());
        }
    }

    public void setVisibility(int i) {
        if (this.gDA != null && this.gDA.getView() != null) {
            this.gDA.getView().setVisibility(i);
        }
    }
}
