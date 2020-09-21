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
    private CustomMessageListener fTe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.a.1
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
    private c gph;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext, boolean z) {
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
            layoutParams.gravity = 5;
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds116);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds96) + UtilHelper.getStatusBarHeight();
            }
            if (!TbadkCoreApplication.getInst().isOther()) {
                viewGroup.addView(this.gph.getView(), 0, layoutParams);
                s(uVar);
            }
        }
    }

    public void s(u uVar) {
        if (uVar.aEz != null) {
            this.gph.ee(uVar.aEz.alaId);
        }
    }

    public boolean au(ViewGroup viewGroup) {
        return (this.gph == null || this.gph.getView() == null || viewGroup.indexOfChild(this.gph.getView()) <= -1) ? false : true;
    }

    public void bOl() {
        if (this.gph != null && this.gph.getView() != null && this.gph.getView().getParent() != null) {
            ((ViewGroup) this.gph.getView().getParent()).removeView(this.gph.getView());
        }
    }

    public void setVisibility(int i) {
        if (this.gph != null && this.gph.getView() != null) {
            this.gph.getView().setVisibility(i);
        }
    }
}
