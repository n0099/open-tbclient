package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class b {
    private CustomMessageListener gDE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.b.1
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
    private c hel;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.gDE.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gDE);
    }

    public void d(ViewGroup viewGroup, w wVar) {
        if (viewGroup != null && this.mTbPageContext != null && wVar != null) {
            this.hel = new c(this.mTbPageContext);
            cac();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.ala_sdk_recommend_more_id);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds24);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds4);
            viewGroup.addView(this.hel.getView(), layoutParams);
            if (wVar.aJV != null) {
                this.hel.fw(wVar.aJV.alaId);
            }
        }
    }

    public void ww(int i) {
        if (this.hel != null && this.hel.getView() != null) {
            this.hel.getView().setVisibility(i);
        }
    }

    public void cac() {
        if (this.hel != null && this.hel.getView() != null && this.hel.getView().getParent() != null) {
            ((ViewGroup) this.hel.getView().getParent()).removeView(this.hel.getView());
        }
    }

    public void IB() {
        if (this.gDE != null) {
            MessageManager.getInstance().unRegisterListener(this.gDE);
        }
    }
}
