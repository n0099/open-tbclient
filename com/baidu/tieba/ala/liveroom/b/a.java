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
    private c eQw;
    private CustomMessageListener evY = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.a.1
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
        MessageManager.getInstance().registerListener(this.evY);
    }

    public void b(ViewGroup viewGroup, m mVar) {
        if (viewGroup != null && this.mTbPageContext != null && mVar != null) {
            this.eQw = new c(this.mTbPageContext);
            bih();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
            viewGroup.addView(this.eQw.getView(), layoutParams);
            o(mVar);
        }
    }

    public void o(m mVar) {
        if (mVar.XQ != null) {
            this.eQw.cR(mVar.XQ.alaId);
        }
    }

    public boolean ag(ViewGroup viewGroup) {
        return (this.eQw == null || this.eQw.getView() == null || viewGroup.indexOfChild(this.eQw.getView()) <= -1) ? false : true;
    }

    public void bih() {
        if (this.eQw != null && this.eQw.getView() != null && this.eQw.getView().getParent() != null) {
            ((ViewGroup) this.eQw.getView().getParent()).removeView(this.eQw.getView());
        }
    }

    public void setVisibility(int i) {
        if (this.eQw != null && this.eQw.getView() != null) {
            this.eQw.getView().setVisibility(i);
        }
    }
}
