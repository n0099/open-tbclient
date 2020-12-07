package com.baidu.tieba.ala.liveroom.b;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class a {
    private CustomMessageListener gDE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.a.1
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
    private c hel;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.gDE.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gDE);
    }

    public void d(ViewGroup viewGroup, w wVar) {
        if (viewGroup != null && this.mTbPageContext != null && wVar != null) {
            this.hel = new c(this.mTbPageContext);
            cac();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.anthor_task_viewpager_id);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds24);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            if (!TbadkCoreApplication.getInst().isOther()) {
                viewGroup.addView(this.hel.getView(), layoutParams);
                C(wVar);
            }
        }
    }

    public void C(w wVar) {
        if (wVar.aJV != null) {
            this.hel.fw(wVar.aJV.alaId);
        }
    }

    public boolean au(ViewGroup viewGroup) {
        return (this.hel == null || this.hel.getView() == null || viewGroup.indexOfChild(this.hel.getView()) <= -1) ? false : true;
    }

    public void cac() {
        if (this.hel != null && this.hel.getView() != null && this.hel.getView().getParent() != null) {
            ((ViewGroup) this.hel.getView().getParent()).removeView(this.hel.getView());
        }
    }

    public void setVisibility(int i) {
        if (this.hel != null && this.hel.getView() != null) {
            this.hel.getView().setVisibility(i);
        }
    }
}
