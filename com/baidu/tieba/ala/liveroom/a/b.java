package com.baidu.tieba.ala.liveroom.a;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class b {
    private CustomMessageListener gNG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.a.b.1
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
    private c hpV;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.gNG.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gNG);
    }

    public void d(ViewGroup viewGroup, ab abVar) {
        if (viewGroup != null && this.mTbPageContext != null && abVar != null) {
            this.hpV = new c(this.mTbPageContext);
            bZW();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.ala_sdk_recommend_more_id);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds24);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds4);
            viewGroup.addView(this.hpV.getView(), layoutParams);
            if (abVar.aId != null) {
                this.hpV.fB(abVar.aId.alaId);
            }
        }
    }

    public void vm(int i) {
        if (this.hpV != null && this.hpV.getView() != null) {
            this.hpV.getView().setVisibility(i);
        }
    }

    public void bZW() {
        if (this.hpV != null && this.hpV.getView() != null && this.hpV.getView().getParent() != null) {
            ((ViewGroup) this.hpV.getView().getParent()).removeView(this.hpV.getView());
        }
    }

    public void Fy() {
        if (this.gNG != null) {
            MessageManager.getInstance().unRegisterListener(this.gNG);
        }
    }
}
