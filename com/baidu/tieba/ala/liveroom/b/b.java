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
    private CustomMessageListener gDG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.b.1
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
    private c hen;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.gDG.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gDG);
    }

    public void d(ViewGroup viewGroup, w wVar) {
        if (viewGroup != null && this.mTbPageContext != null && wVar != null) {
            this.hen = new c(this.mTbPageContext);
            cad();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.ala_sdk_recommend_more_id);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds24);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds4);
            viewGroup.addView(this.hen.getView(), layoutParams);
            if (wVar.aJV != null) {
                this.hen.fw(wVar.aJV.alaId);
            }
        }
    }

    public void ww(int i) {
        if (this.hen != null && this.hen.getView() != null) {
            this.hen.getView().setVisibility(i);
        }
    }

    public void cad() {
        if (this.hen != null && this.hen.getView() != null && this.hen.getView().getParent() != null) {
            ((ViewGroup) this.hen.getView().getParent()).removeView(this.hen.getView());
        }
    }

    public void IB() {
        if (this.gDG != null) {
            MessageManager.getInstance().unRegisterListener(this.gDG);
        }
    }
}
