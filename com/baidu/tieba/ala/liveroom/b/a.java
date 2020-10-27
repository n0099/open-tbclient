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
    private c gPo;
    private CustomMessageListener gpA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.b.a.1
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
        this.gpA.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gpA);
    }

    public void c(ViewGroup viewGroup, w wVar) {
        if (viewGroup != null && this.mTbPageContext != null && wVar != null) {
            this.gPo = new c(this.mTbPageContext);
            bUz();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.g.ala_main_anthor_task_entry_id);
            layoutParams.rightMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
            layoutParams.topMargin = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
            if (!TbadkCoreApplication.getInst().isOther()) {
                viewGroup.addView(this.gPo.getView(), layoutParams);
                w(wVar);
            }
        }
    }

    public void w(w wVar) {
        if (wVar.aIe != null) {
            this.gPo.ew(wVar.aIe.alaId);
        }
    }

    public boolean aw(ViewGroup viewGroup) {
        return (this.gPo == null || this.gPo.getView() == null || viewGroup.indexOfChild(this.gPo.getView()) <= -1) ? false : true;
    }

    public void bUz() {
        if (this.gPo != null && this.gPo.getView() != null && this.gPo.getView().getParent() != null) {
            ((ViewGroup) this.gPo.getView().getParent()).removeView(this.gPo.getView());
        }
    }

    public void setVisibility(int i) {
        if (this.gPo != null && this.gPo.getView() != null) {
            this.gPo.getView().setVisibility(i);
        }
    }
}
