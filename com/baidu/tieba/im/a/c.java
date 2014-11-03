package com.baidu.tieba.im.a;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseQueryGroupCountLocalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a bcM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.bcM = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        e eVar;
        e eVar2;
        int i;
        int i2;
        String str;
        String str2;
        String str3;
        e eVar3;
        e eVar4;
        e eVar5;
        if (customResponsedMessage.getError() != 0) {
            eVar3 = this.bcM.bcJ;
            if (eVar3 != null) {
                eVar4 = this.bcM.bcJ;
                eVar4.ig();
                if (customResponsedMessage.getError() > 0 && !TextUtils.isEmpty(customResponsedMessage.getErrorString())) {
                    eVar5 = this.bcM.bcJ;
                    eVar5.ge(customResponsedMessage.getErrorString());
                }
            }
        } else if (customResponsedMessage instanceof ResponseQueryGroupCountLocalMessage) {
            ResponseQueryGroupCountLocalMessage responseQueryGroupCountLocalMessage = (ResponseQueryGroupCountLocalMessage) customResponsedMessage;
            this.bcM.bcH = responseQueryGroupCountLocalMessage.getUserGroupCount();
            this.bcM.bcI = responseQueryGroupCountLocalMessage.getLocalGroupCount();
            this.bcM.geographicLocation = responseQueryGroupCountLocalMessage.getGeographicLocation();
            this.bcM.picUrl = responseQueryGroupCountLocalMessage.getPicUrl();
            this.bcM.link = responseQueryGroupCountLocalMessage.getLink();
            this.bcM.update();
            eVar = this.bcM.bcJ;
            if (eVar != null) {
                eVar2 = this.bcM.bcJ;
                i = this.bcM.bcH;
                i2 = this.bcM.bcI;
                str = this.bcM.link;
                str2 = this.bcM.picUrl;
                str3 = this.bcM.geographicLocation;
                eVar2.a(i, i2, str, str2, str3);
            }
        }
    }
}
