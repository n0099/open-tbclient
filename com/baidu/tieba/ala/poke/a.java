package com.baidu.tieba.ala.poke;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.d.r;
import com.baidu.live.data.w;
import com.baidu.live.message.AlaPokeResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.v.a {
    w bur;
    boolean hSM = false;
    CustomMessageListener hSN = new CustomMessageListener(2913263) { // from class: com.baidu.tieba.ala.poke.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                a.this.hSM = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private Context mContext;
    String mOtherParams;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.v.a
    public void b(w wVar, String str) {
        this.bur = wVar;
        this.mOtherParams = str;
        MessageManager.getInstance().registerListener(this.hSN);
        col();
    }

    @Override // com.baidu.live.v.a
    public void a(w wVar) {
        this.bur = wVar;
    }

    @Override // com.baidu.live.v.a
    public void iq(String str) {
        if (!this.hSM) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(this.mContext, this.bur, this.mOtherParams, str)));
            return;
        }
        BdUtilHelper.showToast(this.mContext, this.mContext.getString(a.h.sdk_poke_not_poke_twice));
    }

    @Override // com.baidu.live.v.a
    public void Do() {
        this.hSM = false;
        MessageManager.getInstance().unRegisterListener(this.hSN);
        MessageManager.getInstance().unRegisterTask(1021227);
    }

    @Override // com.baidu.live.v.a
    public void onDestroy() {
        this.hSM = false;
        MessageManager.getInstance().unRegisterListener(this.hSN);
        MessageManager.getInstance().unRegisterTask(1021227);
    }

    private void col() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021227, TbConfig.SERVER_ADDRESS + "ala/live/poke");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(AlaPokeResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
