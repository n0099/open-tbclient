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
    private CustomMessageListener gaA = new CustomMessageListener(2913220) { // from class: com.baidu.tieba.ala.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.ad.e eVar = null;
            if (customResponsedMessage.getData() instanceof com.baidu.live.ad.e) {
                eVar = (com.baidu.live.ad.e) customResponsedMessage.getData();
            }
            if (eVar != null) {
                e.this.r(e.this.mTbPageContext.getPageActivity(), eVar.bzq);
            } else {
                e.this.r(e.this.mTbPageContext.getPageActivity(), false);
            }
        }
    };
    private LiveFreeTaskLayer gaz;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void r(Context context, boolean z) {
        if (this.gaz == null) {
            this.gaz = new LiveFreeTaskLayer(context);
            this.gaz.setNeedHideAnim(true);
            this.gaz.setNeedShowAnim(true);
            this.gaz.setCanceledOnTouchOutside(true);
        }
        this.gaz.setIsFromFlowerGuide(z);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            BdUtilHelper.showToast(context, a.h.ala_task_page_not_support_landscape);
        } else {
            com.baidu.live.core.layer.b.DX().d(this.gaz);
        }
    }

    @Override // com.baidu.live.ad.d
    public void e(w wVar) {
        this.gaA.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gaA);
    }

    @Override // com.baidu.live.ad.d
    public void KN() {
        MessageManager.getInstance().unRegisterListener(this.gaA);
    }

    @Override // com.baidu.live.ad.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gaA);
    }
}
