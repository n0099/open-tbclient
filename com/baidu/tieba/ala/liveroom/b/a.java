package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private c fJB;
    private CustomMessageListener foe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.a.1
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
        this.foe.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.foe);
    }

    public void b(ViewGroup viewGroup, q qVar) {
        if (viewGroup != null && this.mTbPageContext != null && qVar != null) {
            this.fJB = new c(this.mTbPageContext);
            bxy();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
            viewGroup.addView(this.fJB.getView(), layoutParams);
            n(qVar);
        }
    }

    public void n(q qVar) {
        if (qVar.avj != null) {
            this.fJB.dA(qVar.avj.alaId);
        }
    }

    public boolean ap(ViewGroup viewGroup) {
        return (this.fJB == null || this.fJB.getView() == null || viewGroup.indexOfChild(this.fJB.getView()) <= -1) ? false : true;
    }

    public void bxy() {
        if (this.fJB != null && this.fJB.getView() != null && this.fJB.getView().getParent() != null) {
            ((ViewGroup) this.fJB.getView().getParent()).removeView(this.fJB.getView());
        }
    }

    public void setVisibility(int i) {
        if (this.fJB != null && this.fJB.getView() != null) {
            this.fJB.getView().setVisibility(i);
        }
    }
}
