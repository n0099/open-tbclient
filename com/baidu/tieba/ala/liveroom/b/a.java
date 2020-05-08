package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private CustomMessageListener faq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.a.1
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
    private c fvt;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.faq.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.faq);
    }

    public void b(ViewGroup viewGroup, n nVar) {
        if (viewGroup != null && this.mTbPageContext != null && nVar != null) {
            this.fvt = new c(this.mTbPageContext);
            brC();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
            viewGroup.addView(this.fvt.getView(), layoutParams);
            n(nVar);
        }
    }

    public void n(n nVar) {
        if (nVar.aqk != null) {
            this.fvt.dz(nVar.aqk.alaId);
        }
    }

    public boolean ai(ViewGroup viewGroup) {
        return (this.fvt == null || this.fvt.getView() == null || viewGroup.indexOfChild(this.fvt.getView()) <= -1) ? false : true;
    }

    public void brC() {
        if (this.fvt != null && this.fvt.getView() != null && this.fvt.getView().getParent() != null) {
            ((ViewGroup) this.fvt.getView().getParent()).removeView(this.fvt.getView());
        }
    }

    public void setVisibility(int i) {
        if (this.fvt != null && this.fvt.getView() != null) {
            this.fvt.getView().setVisibility(i);
        }
    }
}
