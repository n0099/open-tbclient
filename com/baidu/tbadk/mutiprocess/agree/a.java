package com.baidu.tbadk.mutiprocess.agree;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mutiprocess.b;
import com.baidu.tieba.tbadkCore.data.e;
/* loaded from: classes2.dex */
public class a implements b<AgreeEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mutiprocess.b
    public boolean a(AgreeEvent agreeEvent) {
        if (agreeEvent == null || agreeEvent.agreeData == null) {
            return false;
        }
        e eVar = new e();
        eVar.agreeData = agreeEvent.agreeData;
        String str = agreeEvent.agreeExtra;
        if (AgreeEvent.IS_THREAD.equals(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            return true;
        } else if (AgreeEvent.IS_POST.equals(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, eVar));
            return true;
        } else {
            return false;
        }
    }
}
