package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.k;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class b {
    private c eKS;
    private CustomMessageListener eqn = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.b.1
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
        MessageManager.getInstance().registerListener(this.eqn);
    }

    public void b(ViewGroup viewGroup, k kVar) {
        if (viewGroup != null && this.mTbPageContext != null && kVar != null) {
            this.eKS = new c(this.mTbPageContext);
            bfv();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds34);
            viewGroup.addView(this.eKS.getView(), layoutParams);
            if (kVar.VP != null) {
                this.eKS.cK(kVar.VP.alaId);
            }
        }
    }

    public void bfv() {
        if (this.eKS != null && this.eKS.getView() != null && this.eKS.getView().getParent() != null) {
            ((ViewGroup) this.eKS.getView().getParent()).removeView(this.eKS.getView());
        }
    }
}
