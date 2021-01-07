package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class b {
    private CustomMessageListener gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.b.1
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
    private c hqa;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public b(TbPageContext tbPageContext, boolean z) {
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
            layoutParams.addRule(3, a.f.ala_sdk_recommend_more_id);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds24);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds4);
            viewGroup.addView(this.hqa.getView(), layoutParams);
            if (xVar.aKu != null) {
                this.hqa.fw(xVar.aKu.alaId);
            }
        }
    }

    public void wH(int i) {
        if (this.hqa != null && this.hqa.getView() != null) {
            this.hqa.getView().setVisibility(i);
        }
    }

    public void ccL() {
        if (this.hqa != null && this.hqa.getView() != null && this.hqa.getView().getParent() != null) {
            ((ViewGroup) this.hqa.getView().getParent()).removeView(this.hqa.getView());
        }
    }

    public void Id() {
        if (this.gPs != null) {
            MessageManager.getInstance().unRegisterListener(this.gPs);
        }
    }
}
