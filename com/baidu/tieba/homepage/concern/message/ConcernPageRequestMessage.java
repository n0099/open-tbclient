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
            if (d.cPj()) {
                if (!d.cPn()) {
                    builder.page_tag = d.cPl();
                } else {
                    builder.page_tag = d.cPk();
                }
            }
            builder.last_req_unix = Long.valueOf(b.brR().getLong(b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_DATA_RES_REQUEST_TIME), 0L));
            builder.follow_type = Integer.valueOf(com.baidu.tbadk.a.d.bji() ? b.brR().getInt("key_home_concern_all_status", 0) : 1);
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
        int RZ = isEmpty ? 0 : com.baidu.tieba.recapp.report.b.dEB().RZ("CONCERN");
        return AdExtParam.a.bEY().rE(RZ).DL(TbadkCoreApplication.getInst().getCuidGalaxy2()).DO((this.adInfo == null || isEmpty) ? "" : this.adInfo.adFloorInfo).DM(isEmpty ? "" : com.baidu.tieba.recapp.report.b.dEB().RX("CONCERN")).bEZ();
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
