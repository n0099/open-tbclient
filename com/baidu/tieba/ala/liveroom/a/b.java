package com.baidu.tieba.ala.liveroom.a;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class b {
    private CustomMessageListener gPp = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.a.b.1
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
    private c hrE;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.gPp.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gPp);
    }

    public void d(ViewGroup viewGroup, ab abVar) {
        if (viewGroup != null && this.mTbPageContext != null && abVar != null) {
            this.hrE = new c(this.mTbPageContext);
            cac();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.ala_sdk_recommend_more_id);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds24);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds4);
            viewGroup.addView(this.hrE.getView(), layoutParams);
            if (abVar.aJD != null) {
                this.hrE.fB(abVar.aJD.alaId);
            }
        }
    }

    public void vo(int i) {
        if (this.hrE != null && this.hrE.getView() != null) {
            this.hrE.getView().setVisibility(i);
        }
    }

    public void cac() {
        if (this.hrE != null && this.hrE.getView() != null && this.hrE.getView().getParent() != null) {
            ((ViewGroup) this.hrE.getView().getParent()).removeView(this.hrE.getView());
        }
    }

    public void FB() {
        if (this.gPp != null) {
            MessageManager.getInstance().unRegisterListener(this.gPp);
        }
    }
}
