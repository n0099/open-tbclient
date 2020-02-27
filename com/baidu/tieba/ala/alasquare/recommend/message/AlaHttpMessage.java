package com.baidu.tieba.ala.alasquare.recommend.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.mobstat.Config;
/* loaded from: classes3.dex */
public class AlaHttpMessage extends HttpMessage {
    public int mPn;

    public AlaHttpMessage(int i) {
        super(i);
        this.mPn = 0;
    }

    public AlaHttpMessage(int i, BdUniqueId bdUniqueId) {
        super(i, bdUniqueId);
        this.mPn = 0;
    }

    @Override // com.baidu.adp.framework.message.HttpMessage
    public Object addParam(String str, int i) {
        if (Config.PACKAGE_NAME.equals(str) && i >= 0) {
            this.mPn = i;
        }
        return super.addParam(str, i);
    }
}
