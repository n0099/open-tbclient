package com.baidu.tieba.im.a;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseQueryGroupCountLocalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a bcy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.bcy = aVar;
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
            eVar3 = this.bcy.bcv;
            if (eVar3 != null) {
                eVar4 = this.bcy.bcv;
                eVar4.ig();
                if (customResponsedMessage.getError() > 0 && !TextUtils.isEmpty(customResponsedMessage.getErrorString())) {
                    eVar5 = this.bcy.bcv;
                    eVar5.ge(customResponsedMessage.getErrorString());
                }
            }
        } else if (customResponsedMessage instanceof ResponseQueryGroupCountLocalMessage) {
            ResponseQueryGroupCountLocalMessage responseQueryGroupCountLocalMessage = (ResponseQueryGroupCountLocalMessage) customResponsedMessage;
            this.bcy.bct = responseQueryGroupCountLocalMessage.getUserGroupCount();
            this.bcy.bcu = responseQueryGroupCountLocalMessage.getLocalGroupCount();
            this.bcy.geographicLocation = responseQueryGroupCountLocalMessage.getGeographicLocation();
            this.bcy.picUrl = responseQueryGroupCountLocalMessage.getPicUrl();
            this.bcy.link = responseQueryGroupCountLocalMessage.getLink();
            this.bcy.update();
            eVar = this.bcy.bcv;
            if (eVar != null) {
                eVar2 = this.bcy.bcv;
                i = this.bcy.bct;
                i2 = this.bcy.bcu;
                str = this.bcy.link;
                str2 = this.bcy.picUrl;
                str3 = this.bcy.geographicLocation;
                eVar2.a(i, i2, str, str2, str3);
            }
        }
    }
}
