package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer;
/* loaded from: classes4.dex */
public class e implements com.baidu.live.z.d {
    private LiveFreeTaskLayer fAi;
    private CustomMessageListener fAj = new CustomMessageListener(2913220) { // from class: com.baidu.tieba.ala.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.z.e eVar = null;
            if (customResponsedMessage.getData() instanceof com.baidu.live.z.e) {
                eVar = (com.baidu.live.z.e) customResponsedMessage.getData();
            }
            if (eVar != null) {
                e.this.q(e.this.mTbPageContext.getPageActivity(), eVar.bnl);
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
        if (this.fAi == null) {
            this.fAi = new LiveFreeTaskLayer(context);
            this.fAi.setNeedHideAnim(true);
            this.fAi.setNeedShowAnim(true);
            this.fAi.setCanceledOnTouchOutside(true);
        }
        this.fAi.setIsFromFlowerGuide(z);
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            BdUtilHelper.showToast(context, a.i.ala_task_page_not_support_landscape);
        } else {
            com.baidu.live.core.layer.b.CA().d(this.fAi);
        }
    }

    @Override // com.baidu.live.z.d
    public void i(u uVar) {
        this.fAj.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fAj);
    }

    @Override // com.baidu.live.z.d
    public void Lv() {
        MessageManager.getInstance().unRegisterListener(this.fAj);
    }

    @Override // com.baidu.live.z.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fAj);
    }
}
