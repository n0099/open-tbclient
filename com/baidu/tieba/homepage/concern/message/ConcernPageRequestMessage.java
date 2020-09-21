package com.baidu.tieba.homepage.concern.message;

import android.text.TextUtils;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.util.u;
import tbclient.Userlike.DataReq;
import tbclient.Userlike.UserlikeReqIdl;
/* loaded from: classes21.dex */
public class ConcernPageRequestMessage extends NetMessage {
    private String pageTag;

    public ConcernPageRequestMessage() {
        super(1003343, CmdConfigSocket.CMD_CONCERN_PAGE);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.page_tag = this.pageTag;
            builder.last_req_unix = Long.valueOf(b.bjf().getLong(b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), 0L));
            builder.follow_type = Integer.valueOf(d.bbc() ? b.bjf().getInt("key_home_concern_all_status", 0) : 1);
            if (z) {
                u.a(builder, true);
            }
            builder.load_type = Integer.valueOf(TextUtils.isEmpty(this.pageTag) ? 1 : 2);
            UserlikeReqIdl.Builder builder2 = new UserlikeReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }

    public String getPageTag() {
        return this.pageTag;
    }

    public void setPageTag(String str) {
        this.pageTag = str;
    }
}
