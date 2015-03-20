package com.baidu.tieba.friendFeed.a;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.friendFeed.message.RequestFriendFeedLocalMessage;
import com.baidu.tieba.friendFeed.message.RequestFriendFeedMessage;
/* loaded from: classes.dex */
public class a extends f {
    private boolean aIE;
    private Context mContext;
    private String timeline;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity.getPageContext().getContext();
    }

    public String getTimeline() {
        return this.timeline;
    }

    public void setTimeline(String str) {
        this.timeline = str;
    }

    public boolean isUseCache() {
        return this.aIE;
    }

    public void setUseCache(boolean z) {
        this.aIE = z;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void initWithBundle(Bundle bundle) {
    }

    public void s(int i, String str) {
        int M = n.M(this.mContext);
        int N = n.N(this.mContext);
        float f = M / 320.0f;
        int i2 = 1;
        if (be.sY().ta()) {
            i2 = 2;
        }
        RequestFriendFeedMessage requestFriendFeedMessage = new RequestFriendFeedMessage();
        requestFriendFeedMessage.setScrW(M);
        requestFriendFeedMessage.setScrH(N);
        requestFriendFeedMessage.setScrDip(f);
        requestFriendFeedMessage.setqType(i2);
        requestFriendFeedMessage.setLimit(i);
        requestFriendFeedMessage.setTimeline(str);
        super.sendMessage(requestFriendFeedMessage);
    }

    public void t(int i, String str) {
        int M = n.M(this.mContext);
        int N = n.N(this.mContext);
        float f = M / 320.0f;
        int i2 = 1;
        if (be.sY().ta()) {
            i2 = 2;
        }
        RequestFriendFeedLocalMessage requestFriendFeedLocalMessage = new RequestFriendFeedLocalMessage();
        requestFriendFeedLocalMessage.setScrW(M);
        requestFriendFeedLocalMessage.setScrH(N);
        requestFriendFeedLocalMessage.setScrDip(f);
        requestFriendFeedLocalMessage.setqType(i2);
        requestFriendFeedLocalMessage.setLimit(i);
        requestFriendFeedLocalMessage.setTimeline(str);
        sendMessage(requestFriendFeedLocalMessage);
    }

    public void saveInstance(Bundle bundle) {
    }
}
