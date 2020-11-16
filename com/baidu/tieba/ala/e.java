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
public class e implements com.baidu.live.ad.d {
    private LiveFreeTaskLayer gaf;
    private CustomMessageListener gag = new CustomMessageListener(2913220) { // from class: com.baidu.tieba.ala.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.ad.e eVar = null;
            if (customResponsedMessage.getData() instanceof com.baidu.live.ad.e) {
                eVar = (com.baidu.live.ad.e) customResponsedMessage.getData();
            }
            if (eVar != null) {
                e.this.q(e.this.mTbPageContext.getPageActivity(), eVar.bxF);
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
        if (this.gaf == null) {
            this.gaf = new LiveFreeTaskLayer(context);
            this.gaf.setNeedHideAnim(true);
            this.gaf.setNeedShowAnim(true);
            this.gaf.setCanceledOnTouchOutside(true);
        }
        this.gaf.setIsFromFlowerGuide(z);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            BdUtilHelper.showToast(context, a.h.ala_task_page_not_support_landscape);
        } else {
            com.baidu.live.core.layer.b.Do().d(this.gaf);
        }
    }

    @Override // com.baidu.live.ad.d
    public void e(w wVar) {
        this.gag.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gag);
    }

    @Override // com.baidu.live.ad.d
    public void Ke() {
        MessageManager.getInstance().unRegisterListener(this.gag);
    }

    @Override // com.baidu.live.ad.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gag);
    }
}
