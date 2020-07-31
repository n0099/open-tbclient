package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer;
/* loaded from: classes4.dex */
public class d implements com.baidu.live.x.d {
    private LiveFreeTaskLayer flw;
    private CustomMessageListener flx = new CustomMessageListener(2913220) { // from class: com.baidu.tieba.ala.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.x.e eVar = null;
            if (customResponsedMessage.getData() instanceof com.baidu.live.x.e) {
                eVar = (com.baidu.live.x.e) customResponsedMessage.getData();
            }
            if (eVar != null) {
                d.this.o(d.this.mTbPageContext.getPageActivity(), eVar.beE);
            } else {
                d.this.o(d.this.mTbPageContext.getPageActivity(), false);
            }
        }
    };
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void o(Context context, boolean z) {
        if (this.flw == null) {
            this.flw = new LiveFreeTaskLayer(context);
            this.flw.setNeedHideAnim(true);
            this.flw.setNeedShowAnim(true);
            this.flw.setCanceledOnTouchOutside(true);
        }
        this.flw.setIsFromFlowerGuide(z);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            BdUtilHelper.showToast(context, a.i.ala_task_page_not_support_landscape);
        } else {
            com.baidu.live.core.layer.b.wN().d(this.flw);
        }
    }

    @Override // com.baidu.live.x.d
    public void h(q qVar) {
        this.flx.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.flx);
    }

    @Override // com.baidu.live.x.d
    public void Fi() {
        MessageManager.getInstance().unRegisterListener(this.flx);
    }

    @Override // com.baidu.live.x.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.flx);
    }
}
