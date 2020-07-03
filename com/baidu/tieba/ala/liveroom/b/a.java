package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class a {
    private c fUB;
    private CustomMessageListener fzr = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.a.1
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
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.fzr.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fzr);
    }

    public void b(ViewGroup viewGroup, q qVar) {
        if (viewGroup != null && this.mTbPageContext != null && qVar != null) {
            this.fUB = new c(this.mTbPageContext);
            bAl();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
            viewGroup.addView(this.fUB.getView(), layoutParams);
            p(qVar);
        }
    }

    public void p(q qVar) {
        if (qVar.axp != null) {
            this.fUB.dD(qVar.axp.alaId);
        }
    }

    public boolean ar(ViewGroup viewGroup) {
        return (this.fUB == null || this.fUB.getView() == null || viewGroup.indexOfChild(this.fUB.getView()) <= -1) ? false : true;
    }

    public void bAl() {
        if (this.fUB != null && this.fUB.getView() != null && this.fUB.getView().getParent() != null) {
            ((ViewGroup) this.fUB.getView().getParent()).removeView(this.fUB.getView());
        }
    }

    public void setVisibility(int i) {
        if (this.fUB != null && this.fUB.getView() != null) {
            this.fUB.getView().setVisibility(i);
        }
    }
}
