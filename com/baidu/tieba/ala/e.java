package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer;
/* loaded from: classes4.dex */
public class e implements com.baidu.live.ac.d {
    private LiveFreeTaskLayer fUI;
    private CustomMessageListener fUJ = new CustomMessageListener(2913220) { // from class: com.baidu.tieba.ala.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.ac.e eVar = null;
            if (customResponsedMessage.getData() instanceof com.baidu.live.ac.e) {
                eVar = (com.baidu.live.ac.e) customResponsedMessage.getData();
            }
            if (eVar != null) {
                e.this.q(e.this.mTbPageContext.getPageActivity(), eVar.btd);
            } else {
                e.this.q(e.this.mTbPageContext.getPageActivity(), false);
            }
        }
    };
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void q(Context context, boolean z) {
        if (this.fUI == null) {
            this.fUI = new LiveFreeTaskLayer(context);
            this.fUI.setNeedHideAnim(true);
            this.fUI.setNeedShowAnim(true);
            this.fUI.setCanceledOnTouchOutside(true);
        }
        this.fUI.setIsFromFlowerGuide(z);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            BdUtilHelper.showToast(context, a.i.ala_task_page_not_support_landscape);
        } else {
            com.baidu.live.core.layer.b.DE().d(this.fUI);
        }
    }

    @Override // com.baidu.live.ac.d
    public void f(w wVar) {
        this.fUJ.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fUJ);
    }

    @Override // com.baidu.live.ac.d
    public void Kn() {
        MessageManager.getInstance().unRegisterListener(this.fUJ);
    }

    @Override // com.baidu.live.ac.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fUJ);
    }
}
