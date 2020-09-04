package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes7.dex */
public class a {
    private CustomMessageListener fPT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.a.1
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
    private c gma;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.fPT.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fPT);
    }

    public void b(ViewGroup viewGroup, r rVar) {
        if (viewGroup != null && this.mTbPageContext != null && rVar != null) {
            this.gma = new c(this.mTbPageContext);
            bNc();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 5;
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds116);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds96) + UtilHelper.getStatusBarHeight();
            }
            if (!TbadkCoreApplication.getInst().isOther()) {
                viewGroup.addView(this.gma.getView(), 0, layoutParams);
                q(rVar);
            }
        }
    }

    public void q(r rVar) {
        if (rVar.aDG != null) {
            this.gma.ec(rVar.aDG.alaId);
        }
    }

    public boolean at(ViewGroup viewGroup) {
        return (this.gma == null || this.gma.getView() == null || viewGroup.indexOfChild(this.gma.getView()) <= -1) ? false : true;
    }

    public void bNc() {
        if (this.gma != null && this.gma.getView() != null && this.gma.getView().getParent() != null) {
            ((ViewGroup) this.gma.getView().getParent()).removeView(this.gma.getView());
        }
    }

    public void setVisibility(int i) {
        if (this.gma != null && this.gma.getView() != null) {
            this.gma.getView().setVisibility(i);
        }
    }
}
