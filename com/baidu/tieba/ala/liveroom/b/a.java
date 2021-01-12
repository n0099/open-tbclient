package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class a {
    private CustomMessageListener gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.a.1
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
    private c hlt;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.gKM.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gKM);
    }

    public void d(ViewGroup viewGroup, x xVar) {
        if (viewGroup != null && this.mTbPageContext != null && xVar != null) {
            this.hlt = new c(this.mTbPageContext);
            bYT();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.anthor_task_viewpager_id);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds24);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            if (!TbadkCoreApplication.getInst().isOther()) {
                viewGroup.addView(this.hlt.getView(), layoutParams);
                C(xVar);
            }
        }
    }

    public void C(x xVar) {
        if (xVar.aFH != null) {
            this.hlt.fw(xVar.aFH.alaId);
        }
    }

    public boolean aG(ViewGroup viewGroup) {
        return (this.hlt == null || this.hlt.getView() == null || viewGroup.indexOfChild(this.hlt.getView()) <= -1) ? false : true;
    }

    public void bYT() {
        if (this.hlt != null && this.hlt.getView() != null && this.hlt.getView().getParent() != null) {
            ((ViewGroup) this.hlt.getView().getParent()).removeView(this.hlt.getView());
        }
    }

    public void setVisibility(int i) {
        if (this.hlt != null && this.hlt.getView() != null) {
            this.hlt.getView().setVisibility(i);
        }
    }
}
