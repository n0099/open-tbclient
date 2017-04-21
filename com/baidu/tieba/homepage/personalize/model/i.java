package com.baidu.tieba.homepage.personalize.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ RecPersonalizePageModel cBF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(RecPersonalizePageModel recPersonalizePageModel, int i) {
        super(i);
        this.cBF = recPersonalizePageModel;
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
                this.cBF.cBz = null;
                this.cBF.cBB = 0;
                return;
            }
            com.baidu.tieba.homepage.personalize.data.g gVar = (com.baidu.tieba.homepage.personalize.data.g) customResponsedMessage.getData();
            if (gVar.cBo) {
                str2 = this.cBF.cBz;
                if (!StringUtils.isNull(str2)) {
                    str3 = this.cBF.cBz;
                    if (str3.equals(gVar.Uw)) {
                        this.cBF.cBB = 2;
                        this.cBF.cBz = gVar.Uw;
                        return;
                    }
                }
                this.cBF.cBB = 1;
                this.cBF.cBz = gVar.Uw;
                return;
            }
            str = this.cBF.cBz;
            if (StringUtils.isNull(str)) {
                this.cBF.cBB = 2;
            } else {
                this.cBF.cBB = 1;
            }
            this.cBF.cBz = null;
        }
    }
}
