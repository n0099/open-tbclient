package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.i;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class b {
    private CustomMessageListener dEz = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.b.1
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
    private c dVr;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public b(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        MessageManager.getInstance().registerListener(this.dEz);
    }

    public void b(ViewGroup viewGroup, i iVar) {
        if (viewGroup != null && this.mTbPageContext != null && iVar != null) {
            this.dVr = new c(this.mTbPageContext);
            aNZ();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds34);
            viewGroup.addView(this.dVr.getView(), layoutParams);
            if (iVar.OR != null) {
                this.dVr.ce(iVar.OR.alaId);
            }
        }
    }

    public void aNZ() {
        if (this.dVr != null && this.dVr.getView() != null && this.dVr.getView().getParent() != null) {
            ((ViewGroup) this.dVr.getView().getParent()).removeView(this.dVr.getView());
        }
    }
}
