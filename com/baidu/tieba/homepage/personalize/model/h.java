package com.baidu.tieba.homepage.personalize.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ RecPersonalizePageModel czo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(RecPersonalizePageModel recPersonalizePageModel, int i) {
        super(i);
        this.czo = recPersonalizePageModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        onMessage2((CustomResponsedMessage) customResponsedMessage);
    }

    /* renamed from: onMessage  reason: avoid collision after fix types in other method */
    public void onMessage2(CustomResponsedMessage customResponsedMessage) {
        String str;
        String str2;
        String str3;
        if (customResponsedMessage != null) {
            if (!(customResponsedMessage.getData() instanceof com.baidu.tieba.homepage.personalize.data.g)) {
                this.czo.czh = null;
                this.czo.czk = 0;
                return;
            }
            com.baidu.tieba.homepage.personalize.data.g gVar = (com.baidu.tieba.homepage.personalize.data.g) customResponsedMessage.getData();
            if (gVar.cyX) {
                str2 = this.czo.czh;
                if (!StringUtils.isNull(str2)) {
                    str3 = this.czo.czh;
                    if (str3.equals(gVar.Uu)) {
                        this.czo.czk = 2;
                        this.czo.czh = gVar.Uu;
                        return;
                    }
                }
                this.czo.czk = 1;
                this.czo.czh = gVar.Uu;
                return;
            }
            str = this.czo.czh;
            if (StringUtils.isNull(str)) {
                this.czo.czk = 2;
            } else {
                this.czo.czk = 1;
            }
            this.czo.czh = null;
        }
    }
}
