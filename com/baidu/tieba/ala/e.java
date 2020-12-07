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
public class e implements com.baidu.live.ah.d {
    private LiveFreeTaskLayer gir;
    private CustomMessageListener gis = new CustomMessageListener(2913220) { // from class: com.baidu.tieba.ala.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.ah.e eVar = null;
            if (customResponsedMessage.getData() instanceof com.baidu.live.ah.e) {
                eVar = (com.baidu.live.ah.e) customResponsedMessage.getData();
            }
            if (eVar != null) {
                e.this.v(e.this.mTbPageContext.getPageActivity(), eVar.bCN);
            } else {
                e.this.v(e.this.mTbPageContext.getPageActivity(), false);
            }
        }
    };
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void v(Context context, boolean z) {
        if (this.gir == null) {
            this.gir = new LiveFreeTaskLayer(context);
            this.gir.setNeedHideAnim(true);
            this.gir.setNeedShowAnim(true);
            this.gir.setCanceledOnTouchOutside(true);
        }
        this.gir.setIsFromFlowerGuide(z);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            BdUtilHelper.showToast(context, a.h.ala_task_page_not_support_landscape);
        } else {
            com.baidu.live.core.layer.b.EY().d(this.gir);
        }
    }

    @Override // com.baidu.live.ah.d
    public void e(w wVar) {
        this.gis.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gis);
    }

    @Override // com.baidu.live.ah.d
    public void Mg() {
        MessageManager.getInstance().unRegisterListener(this.gis);
    }

    @Override // com.baidu.live.ah.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gis);
    }
}
