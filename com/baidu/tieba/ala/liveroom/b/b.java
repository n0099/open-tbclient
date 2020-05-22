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
public class b {
    private c fJq;
    private CustomMessageListener fnT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.b.1
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
        this.fnT.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fnT);
    }

    public void b(ViewGroup viewGroup, q qVar) {
        if (viewGroup != null && this.mTbPageContext != null && qVar != null) {
            this.fJq = new c(this.mTbPageContext);
            bxw();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds58);
            viewGroup.addView(this.fJq.getView(), layoutParams);
            if (qVar.avj != null) {
                this.fJq.dA(qVar.avj.alaId);
            }
        }
    }

    public void bxw() {
        if (this.fJq != null && this.fJq.getView() != null && this.fJq.getView().getParent() != null) {
            ((ViewGroup) this.fJq.getView().getParent()).removeView(this.fJq.getView());
        }
    }
}
