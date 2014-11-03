package com.baidu.tieba.im.a;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseQueryGroupCountMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ a bcM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.bcM = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        e eVar;
        e eVar2;
        e eVar3;
        int i;
        int i2;
        String str;
        String str2;
        String str3;
        e eVar4;
        e eVar5;
        e eVar6;
        e eVar7;
        if (socketResponsedMessage.getError() != 0) {
            eVar5 = this.bcM.bcJ;
            if (eVar5 != null) {
                eVar6 = this.bcM.bcJ;
                eVar6.ig();
                if (socketResponsedMessage.getError() > 0 && !TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                    eVar7 = this.bcM.bcJ;
                    eVar7.ge(socketResponsedMessage.getErrorString());
                }
            }
        } else if (socketResponsedMessage instanceof ResponseQueryGroupCountMessage) {
            ResponseQueryGroupCountMessage responseQueryGroupCountMessage = (ResponseQueryGroupCountMessage) socketResponsedMessage;
            this.bcM.bcH = responseQueryGroupCountMessage.getUserGroupCount();
            this.bcM.bcI = responseQueryGroupCountMessage.getLocalGroupCount();
            this.bcM.geographicLocation = responseQueryGroupCountMessage.getGeographicLocation();
            this.bcM.picUrl = responseQueryGroupCountMessage.getPicUrl();
            this.bcM.link = responseQueryGroupCountMessage.getLink();
            a.bcG = false;
            eVar = this.bcM.bcJ;
            if (eVar != null) {
                eVar4 = this.bcM.bcJ;
                eVar4.ig();
            }
            eVar2 = this.bcM.bcJ;
            if (eVar2 != null) {
                eVar3 = this.bcM.bcJ;
                i = this.bcM.bcH;
                i2 = this.bcM.bcI;
                str = this.bcM.link;
                str2 = this.bcM.picUrl;
                str3 = this.bcM.geographicLocation;
                eVar3.a(i, i2, str, str2, str3);
            }
        }
    }
}
