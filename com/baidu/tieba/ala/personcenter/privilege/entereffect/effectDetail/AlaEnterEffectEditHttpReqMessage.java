package com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.ala.AlaCmdConfigHttp;
/* loaded from: classes9.dex */
public class AlaEnterEffectEditHttpReqMessage extends HttpMessage {
    private boolean mIsSelected;

    public AlaEnterEffectEditHttpReqMessage(String str, boolean z) {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT);
        this.mIsSelected = z;
        addParam("effect_id", str);
        if (z) {
            addParam("action", 1);
        } else {
            addParam("action", 2);
        }
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }
}
