package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer;
/* loaded from: classes7.dex */
public class d implements com.baidu.live.y.d {
    private LiveFreeTaskLayer fwS;
    private CustomMessageListener fwT = new CustomMessageListener(2913220) { // from class: com.baidu.tieba.ala.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.y.e eVar = null;
            if (customResponsedMessage.getData() instanceof com.baidu.live.y.e) {
                eVar = (com.baidu.live.y.e) customResponsedMessage.getData();
            }
            if (eVar != null) {
                d.this.p(d.this.mTbPageContext.getPageActivity(), eVar.bkp);
            } else {
                d.this.p(d.this.mTbPageContext.getPageActivity(), false);
            }
        }
    };
    private TbPageContext mTbPageContext;

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void p(Context context, boolean z) {
        if (this.fwS == null) {
            this.fwS = new LiveFreeTaskLayer(context);
            this.fwS.setNeedHideAnim(true);
            this.fwS.setNeedShowAnim(true);
            this.fwS.setCanceledOnTouchOutside(true);
        }
        this.fwS.setIsFromFlowerGuide(z);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            BdUtilHelper.showToast(context, a.i.ala_task_page_not_support_landscape);
        } else {
            com.baidu.live.core.layer.b.Cl().d(this.fwS);
        }
    }

    @Override // com.baidu.live.y.d
    public void h(r rVar) {
        this.fwT.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fwT);
    }

    @Override // com.baidu.live.y.d
    public void KP() {
        MessageManager.getInstance().unRegisterListener(this.fwT);
    }

    @Override // com.baidu.live.y.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fwT);
    }
}
