package com.baidu.tieba.homepage.personalize.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ RecPersonalizePageModel czs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(RecPersonalizePageModel recPersonalizePageModel, int i) {
        super(i);
        this.czs = recPersonalizePageModel;
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
                this.czs.czl = null;
                this.czs.czo = 0;
                return;
            }
            com.baidu.tieba.homepage.personalize.data.g gVar = (com.baidu.tieba.homepage.personalize.data.g) customResponsedMessage.getData();
            if (gVar.czb) {
                str2 = this.czs.czl;
                if (!StringUtils.isNull(str2)) {
                    str3 = this.czs.czl;
                    if (str3.equals(gVar.OZ)) {
                        this.czs.czo = 2;
                        this.czs.czl = gVar.OZ;
                        return;
                    }
                }
                this.czs.czo = 1;
                this.czs.czl = gVar.OZ;
                return;
            }
            str = this.czs.czl;
            if (StringUtils.isNull(str)) {
                this.czs.czo = 2;
            } else {
                this.czs.czo = 1;
            }
            this.czs.czl = null;
        }
    }
}
