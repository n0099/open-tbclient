package com.baidu.tieba.ala.alasquare.recommend.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class AlaHttpMessage extends HttpMessage {
    public int mPn;

    public AlaHttpMessage(int i2) {
        super(i2);
        this.mPn = 0;
    }

    @Override // com.baidu.adp.framework.message.HttpMessage
    public Object addParam(String str, int i2) {
        if (Config.PACKAGE_NAME.equals(str) && i2 >= 0) {
            this.mPn = i2;
        }
        return super.addParam(str, i2);
    }

    public AlaHttpMessage(int i2, BdUniqueId bdUniqueId) {
        super(i2, bdUniqueId);
        this.mPn = 0;
    }
}
