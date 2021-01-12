package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class b {
    private CustomMessageListener gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.b.1
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
    private c hlt;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.gKM.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gKM);
    }

    public void d(ViewGroup viewGroup, x xVar) {
        if (viewGroup != null && this.mTbPageContext != null && xVar != null) {
            this.hlt = new c(this.mTbPageContext);
            bYT();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.ala_sdk_recommend_more_id);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds24);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds4);
            viewGroup.addView(this.hlt.getView(), layoutParams);
            if (xVar.aFH != null) {
                this.hlt.fw(xVar.aFH.alaId);
            }
        }
    }

    public void vb(int i) {
        if (this.hlt != null && this.hlt.getView() != null) {
            this.hlt.getView().setVisibility(i);
        }
    }

    public void bYT() {
        if (this.hlt != null && this.hlt.getView() != null && this.hlt.getView().getParent() != null) {
            ((ViewGroup) this.hlt.getView().getParent()).removeView(this.hlt.getView());
        }
    }

    public void Ei() {
        if (this.gKM != null) {
            MessageManager.getInstance().unRegisterListener(this.gKM);
        }
    }
}
