package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private c eQi;
    private CustomMessageListener evK = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.a.1
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
        MessageManager.getInstance().registerListener(this.evK);
    }

    public void b(ViewGroup viewGroup, m mVar) {
        if (viewGroup != null && this.mTbPageContext != null && mVar != null) {
            this.eQi = new c(this.mTbPageContext);
            bie();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
            viewGroup.addView(this.eQi.getView(), layoutParams);
            o(mVar);
        }
    }

    public void o(m mVar) {
        if (mVar.XQ != null) {
            this.eQi.cR(mVar.XQ.alaId);
        }
    }

    public boolean ag(ViewGroup viewGroup) {
        return (this.eQi == null || this.eQi.getView() == null || viewGroup.indexOfChild(this.eQi.getView()) <= -1) ? false : true;
    }

    public void bie() {
        if (this.eQi != null && this.eQi.getView() != null && this.eQi.getView().getParent() != null) {
            ((ViewGroup) this.eQi.getView().getParent()).removeView(this.eQi.getView());
        }
    }

    public void setVisibility(int i) {
        if (this.eQi != null && this.eQi.getView() != null) {
            this.eQi.getView().setVisibility(i);
        }
    }
}
