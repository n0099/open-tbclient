package com.baidu.tieba.homepage.concern.message;

import android.text.TextUtils;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.util.c;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.homepage.concern.d;
import tbclient.Userlike.DataReq;
import tbclient.Userlike.UserlikeReqIdl;
/* loaded from: classes2.dex */
public class ConcernPageRequestMessage extends NetMessage {
    private c adInfo;
    private String pageTag;

    public ConcernPageRequestMessage() {
        super(1003343, CmdConfigSocket.CMD_CONCERN_PAGE);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.page_tag = this.pageTag;
            if (d.cOV()) {
                if (!d.cOZ()) {
                    builder.page_tag = d.cOX();
                } else {
                    builder.page_tag = d.cOW();
                }
            }
            builder.last_req_unix = Long.valueOf(b.brQ().getLong(b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), 0L));
            builder.follow_type = Integer.valueOf(com.baidu.tbadk.a.d.bjg() ? b.brQ().getInt("key_home_concern_all_status", 0) : 1);
            if (z) {
                v.b(builder, true);
            }
            builder.load_type = Integer.valueOf(TextUtils.isEmpty(this.pageTag) ? 1 : 2);
            builder.ad_ext_params = buildAdParam();
            UserlikeReqIdl.Builder builder2 = new UserlikeReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }

    private String buildAdParam() {
        boolean isEmpty = TextUtils.isEmpty(this.pageTag);
        int RH = isEmpty ? 0 : com.baidu.tieba.recapp.report.b.dEl().RH("CONCERN");
        return AdExtParam.a.bEU().rC(RH).DG(TbadkCoreApplication.getInst().getCuidGalaxy2()).DJ((this.adInfo == null || isEmpty) ? "" : this.adInfo.adFloorInfo).DH(isEmpty ? "" : com.baidu.tieba.recapp.report.b.dEl().RF("CONCERN")).bEV();
    }

    public String getPageTag() {
        return this.pageTag;
    }

    public void setPageTag(String str) {
        this.pageTag = str;
    }

    public void setAdInfo(c cVar) {
        this.adInfo = cVar;
    }
}
