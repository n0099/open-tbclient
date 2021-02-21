package com.baidu.tieba.ala.poke;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.d.r;
import com.baidu.live.data.ab;
import com.baidu.live.message.AlaPokeResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.v.a {
    ab bxN;
    boolean ifp = false;
    CustomMessageListener ifq = new CustomMessageListener(2913263) { // from class: com.baidu.tieba.ala.poke.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                a.this.ifp = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private Context mContext;
    String mOtherParams;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.v.a
    public void b(ab abVar, String str) {
        this.bxN = abVar;
        this.mOtherParams = str;
        MessageManager.getInstance().registerListener(this.ifq);
        cos();
    }

    @Override // com.baidu.live.v.a
    public void a(ab abVar) {
        this.bxN = abVar;
    }

    @Override // com.baidu.live.v.a
    public void hs(String str) {
        if (!this.ifp) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(this.mContext, this.bxN, this.mOtherParams, str)));
            return;
        }
        BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.sdk_poke_not_poke_twice));
    }

    @Override // com.baidu.live.v.a
    public void xh() {
        this.ifp = false;
        MessageManager.getInstance().unRegisterListener(this.ifq);
        MessageManager.getInstance().unRegisterTask(1021227);
    }

    @Override // com.baidu.live.v.a
    public void onDestroy() {
        this.ifp = false;
        MessageManager.getInstance().unRegisterListener(this.ifq);
        MessageManager.getInstance().unRegisterTask(1021227);
    }

    private void cos() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021227, TbConfig.SERVER_ADDRESS + "ala/live/poke");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(AlaPokeResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
