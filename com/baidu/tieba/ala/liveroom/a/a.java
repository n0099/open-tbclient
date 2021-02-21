package com.baidu.tieba.ala.liveroom.a;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class a {
    private CustomMessageListener gNG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.a.a.1
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
    private c hpV;
    private final boolean mIsHost;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.gNG.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gNG);
    }

    public void d(ViewGroup viewGroup, ab abVar) {
        if (viewGroup != null && this.mTbPageContext != null && abVar != null) {
            this.hpV = new c(this.mTbPageContext);
            bZW();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.anthor_task_viewpager_id);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds24);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            if (!TbadkCoreApplication.getInst().isOther()) {
                viewGroup.addView(this.hpV.getView(), layoutParams);
                C(abVar);
            }
        }
    }

    public void C(ab abVar) {
        if (abVar.aId != null) {
            this.hpV.fB(abVar.aId.alaId);
        }
    }

    public boolean aG(ViewGroup viewGroup) {
        return (this.hpV == null || this.hpV.getView() == null || viewGroup.indexOfChild(this.hpV.getView()) <= -1) ? false : true;
    }

    public void bZW() {
        if (this.hpV != null && this.hpV.getView() != null && this.hpV.getView().getParent() != null) {
            ((ViewGroup) this.hpV.getView().getParent()).removeView(this.hpV.getView());
        }
    }

    public void setVisibility(int i) {
        if (this.hpV != null && this.hpV.getView() != null) {
            this.hpV.getView().setVisibility(i);
        }
    }
}
