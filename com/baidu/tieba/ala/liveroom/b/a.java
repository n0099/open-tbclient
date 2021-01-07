package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class a {
    private CustomMessageListener gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.a.1
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
    private c hqa;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.gPs.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gPs);
    }

    public void d(ViewGroup viewGroup, x xVar) {
        if (viewGroup != null && this.mTbPageContext != null && xVar != null) {
            this.hqa = new c(this.mTbPageContext);
            ccL();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.anthor_task_viewpager_id);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds24);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            if (!TbadkCoreApplication.getInst().isOther()) {
                viewGroup.addView(this.hqa.getView(), layoutParams);
                C(xVar);
            }
        }
    }

    public void C(x xVar) {
        if (xVar.aKu != null) {
            this.hqa.fw(xVar.aKu.alaId);
        }
    }

    public boolean aG(ViewGroup viewGroup) {
        return (this.hqa == null || this.hqa.getView() == null || viewGroup.indexOfChild(this.hqa.getView()) <= -1) ? false : true;
    }

    public void ccL() {
        if (this.hqa != null && this.hqa.getView() != null && this.hqa.getView().getParent() != null) {
            ((ViewGroup) this.hqa.getView().getParent()).removeView(this.hqa.getView());
        }
    }

    public void setVisibility(int i) {
        if (this.hqa != null && this.hqa.getView() != null) {
            this.hqa.getView().setVisibility(i);
        }
    }
}
