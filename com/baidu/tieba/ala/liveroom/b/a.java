package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private CustomMessageListener fEy = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.a.1
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
    private c fZT;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.fEy.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fEy);
    }

    public void b(ViewGroup viewGroup, q qVar) {
        if (viewGroup != null && this.mTbPageContext != null && qVar != null) {
            this.fZT = new c(this.mTbPageContext);
            bDA();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
            viewGroup.addView(this.fZT.getView(), layoutParams);
            p(qVar);
        }
    }

    public void p(q qVar) {
        if (qVar.ayC != null) {
            this.fZT.dR(qVar.ayC.alaId);
        }
    }

    public boolean as(ViewGroup viewGroup) {
        return (this.fZT == null || this.fZT.getView() == null || viewGroup.indexOfChild(this.fZT.getView()) <= -1) ? false : true;
    }

    public void bDA() {
        if (this.fZT != null && this.fZT.getView() != null && this.fZT.getView().getParent() != null) {
            ((ViewGroup) this.fZT.getView().getParent()).removeView(this.fZT.getView());
        }
    }

    public void setVisibility(int i) {
        if (this.fZT != null && this.fZT.getView() != null) {
            this.fZT.getView().setVisibility(i);
        }
    }
}
