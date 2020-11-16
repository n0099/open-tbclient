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
    private c gUZ;
    private CustomMessageListener guV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.b.1
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
        this.guV.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.guV);
    }

    public void c(ViewGroup viewGroup, w wVar) {
        if (viewGroup != null && this.mTbPageContext != null && wVar != null) {
            this.gUZ = new c(this.mTbPageContext);
            bWs();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.ala_sdk_recommend_more_id);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds24);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds4);
            viewGroup.addView(this.gUZ.getView(), layoutParams);
            if (wVar.aHk != null) {
                this.gUZ.eS(wVar.aHk.alaId);
            }
        }
    }

    public void vR(int i) {
        if (this.gUZ != null && this.gUZ.getView() != null) {
            this.gUZ.getView().setVisibility(i);
        }
    }

    public void bWs() {
        if (this.gUZ != null && this.gUZ.getView() != null && this.gUZ.getView().getParent() != null) {
            ((ViewGroup) this.gUZ.getView().getParent()).removeView(this.gUZ.getView());
        }
    }

    public void GK() {
        if (this.guV != null) {
            MessageManager.getInstance().unRegisterListener(this.guV);
        }
    }
}
